package com.fzu.edumanagement.controller.teacher;

import com.fzu.edumanagement.config.themis.annotation.Teacher;
import com.fzu.edumanagement.controller.BaseController;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.teacher.TimetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/timetable")
@RestController
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
