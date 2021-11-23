package com.fzu.edumanagement.model.bo;

import lombok.Data;

@Data
public class FZUNewsBO {
    private String title;
    private String url;
    private String date;

    public FZUNewsBO(String title, String date, String url) {
        this.title = title;
        this.date = date;
        this.url = url;
    }
}
