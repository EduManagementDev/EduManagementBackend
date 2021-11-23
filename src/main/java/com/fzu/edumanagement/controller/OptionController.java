package com.fzu.edumanagement.controller;

import com.fzu.edumanagement.config.themis.annotation.Admin;
import com.fzu.edumanagement.model.vo.request.BoolOptionVO;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.OptionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/option")
@RestController
public class OptionController extends BaseController {
    private final OptionService service;

    public OptionController(OptionService service) {
        this.service = service;
    }

    @GetMapping("/allowStudentSelect")
    public ResultVO getAllowStudentSelect() {
        return service.getAllowStudentSelect();
    }

    @Admin(Admin.STUDENT_COURSE_MANAGE)
    @PutMapping("/allowStudentSelect")
    public ResultVO setAllowStudentSelect(@RequestBody @Validated BoolOptionVO option) {
        return service.setAllowStudentSelect(option.getOption());
    }

    @GetMapping("/allowTeacherGrade")
    public ResultVO getAllowTeacherGrade() {
        return service.getAllowTeacherGrade();
    }

    @Admin(Admin.STUDENT_COURSE_MANAGE)
    @PutMapping("/allowTeacherGrade")
    public ResultVO setAllowTeacherGrade(@RequestBody @Validated BoolOptionVO option) {
        return service.setAllowTeacherGrade(option.getOption());
    }
}
