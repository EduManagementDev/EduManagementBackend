package com.fzu.edumanagement.controller.student;

import com.fzu.edumanagement.config.themis.annotation.Student;
import com.fzu.edumanagement.controller.BaseController;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.student.ExamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/exam")
@RestController
public class ExamController extends BaseController {
    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
