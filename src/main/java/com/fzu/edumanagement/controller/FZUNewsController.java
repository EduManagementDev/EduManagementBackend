package com.fzu.edumanagement.controller;

import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.FZUNewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fzu/news")
@RestController
public class FZUNewsController extends BaseController {
    private final FZUNewsService service;

    public FZUNewsController(FZUNewsService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.getAllNews();
    }
}
