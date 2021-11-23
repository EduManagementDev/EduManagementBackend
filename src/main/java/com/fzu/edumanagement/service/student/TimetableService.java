package com.fzu.edumanagement.service.student;

import com.fzu.edumanagement.manager.student.TimetableManager;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer studentId = getUserId();
        return result(manager.listStudentTimetable(studentId));
    }
}
