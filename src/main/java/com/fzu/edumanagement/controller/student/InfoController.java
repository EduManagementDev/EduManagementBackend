package com.fzu.edumanagement.controller.student;

import com.fzu.edumanagement.config.themis.annotation.Student;
import com.fzu.edumanagement.controller.BaseController;
import com.fzu.edumanagement.model.vo.request.StudentInfoFormVO;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.student.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/student/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
