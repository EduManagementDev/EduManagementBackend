package com.fzu.edumanagement.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fzu.edumanagement.model.bo.FZUNewsBO;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FZUNewsItemVO {
    private String title;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;

    private String url;

    private static FZUNewsItemVO fromSdnuNewsBO(FZUNewsBO bo) {
        FZUNewsItemVO vo = new FZUNewsItemVO();
        vo.setTitle(bo.getTitle());
        vo.setUrl(bo.getUrl());

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            vo.setDate(format.parse(bo.getDate()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return vo;
    }

    public static List<FZUNewsItemVO> fromSdnuNewsBOList(List<FZUNewsBO> boList) {
        List<FZUNewsItemVO> voList = new ArrayList<>();
        for (FZUNewsBO bo : boList) {
            voList.add(FZUNewsItemVO.fromSdnuNewsBO(bo));
        }

        return voList;
    }

}
