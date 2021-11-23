package com.fzu.edumanagement.manager;

import com.fzu.edumanagement.dao.redis.FZUNewsDAO;
import com.fzu.edumanagement.model.bo.FZUNewsBO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FZUNewsManager extends BaseManager {
    private static final int CRAWL_INTERVAL = 60 * 60 * 1000;
    private static final int CRAWL_TIMEOUT = 30 * 1000;
    private static final String CRAWL_TARGET_URL = "https://jwch.fzu.edu.cn/jxtz.htm";
    private static final String BASE_URL = "https://jwch.fzu.edu.cn/";

    private final FZUNewsDAO FZUNewsDAO;

    public FZUNewsManager(FZUNewsDAO FZUNewsDAO) {
        this.FZUNewsDAO = FZUNewsDAO;
    }

    public List<FZUNewsBO> getAllNews() {
        Map<String, String> map = FZUNewsDAO.getAllNews();

        List<FZUNewsBO> newsList = new ArrayList<>(map.size());
        for (String key : map.keySet()) {
            String value = map.get(key);
            String date = value.substring(0, 10);
            String url = value.substring(10);
            newsList.add(new FZUNewsBO(key, date, url));
        }

        return newsList;
    }

    @Scheduled(fixedDelay = CRAWL_INTERVAL)
    public void crawlNews() {
        Document pageDoc = fetchPage();
        if (pageDoc == null) {
            return;
        }

        List<FZUNewsBO> newsList = parseNews(pageDoc);
        FZUNewsDAO.clear();
        for (FZUNewsBO news : newsList) {
            FZUNewsDAO.addNews(news.getTitle(), news.getDate() + news.getUrl());
        }
    }

    private Document fetchPage() {
        Document doc = null;
        try {
            doc = Jsoup.parse(new URL(CRAWL_TARGET_URL), CRAWL_TIMEOUT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return doc;
    }

    private List<FZUNewsBO> parseNews(Document pageDoc) {
        Elements elements = pageDoc.body()
                .getElementsByClass("list-gl").get(0)
                .getElementsByTag("li");

        List<FZUNewsBO> newsList = new ArrayList<>();
        for (Element element : elements) {
            Element aTag = element.getElementsByTag("a").get(0);
            String title = aTag.text();
            String url = BASE_URL + aTag.attr("href");
            String date = element.getElementsByTag("span").get(0).text();
            FZUNewsBO FZUNewsBO = new FZUNewsBO(title, date, url);
            System.out.println(title);
            newsList.add(FZUNewsBO);
        }

        return newsList;
    }
}
