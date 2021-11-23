package com.fzu.edumanagement.controller.teacher;

import com.fzu.edumanagement.config.themis.annotation.Teacher;
import com.fzu.edumanagement.controller.BaseController;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.teacher.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
