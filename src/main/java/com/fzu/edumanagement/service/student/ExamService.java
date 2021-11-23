package com.fzu.edumanagement.service.student;

import com.fzu.edumanagement.manager.student.ExamManager;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends BaseService {
    private final ExamManager manager;

    public ExamService(ExamManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        return result(manager.listStudentExam(getUserId()));
    }
}
