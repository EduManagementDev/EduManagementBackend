package com.fzu.edumanagement.controller.student;

import com.fzu.edumanagement.config.themis.annotation.Student;
import com.fzu.edumanagement.controller.BaseController;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.student.CourseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/course")
@RestController("student_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}
