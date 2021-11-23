package com.fzu.edumanagement.service.teacher;

import com.fzu.edumanagement.manager.teacher.TimetableManager;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer teacherId = getUserId();
        return result(manager.listTeacherTimetable(teacherId));
    }
}
