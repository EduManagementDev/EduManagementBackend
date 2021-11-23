package com.fzu.edumanagement.service;

import com.fzu.edumanagement.manager.FZUNewsManager;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.model.vo.response.table.FZUNewsItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FZUNewsService extends BaseService {
    private final FZUNewsManager manager;

    public FZUNewsService(FZUNewsManager manager) {
        this.manager = manager;
    }

    public ResultVO getAllNews() {
        List<FZUNewsItemVO> voList = FZUNewsItemVO.fromSdnuNewsBOList(manager.getAllNews());
        voList.sort((a, b) -> b.getDate().compareTo(a.getDate()));

        return result(voList);
    }
}
