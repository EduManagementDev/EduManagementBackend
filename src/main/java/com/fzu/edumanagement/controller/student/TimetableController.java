package com.fzu.edumanagement.controller.student;

import com.fzu.edumanagement.config.themis.annotation.Student;
import com.fzu.edumanagement.controller.BaseController;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.student.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/timetable")
@RestController("student_timeTableController")
public class TimetableController extends BaseController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
