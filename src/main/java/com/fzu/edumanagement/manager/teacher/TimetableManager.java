package com.fzu.edumanagement.manager.teacher;

import com.fzu.edumanagement.dao.TeacherDAO;
import com.fzu.edumanagement.manager.BaseManager;
import com.fzu.edumanagement.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public TimetableManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TimetableItemVO> listTeacherTimetable(Integer teacherId) {
        return teacherDAO.listTeacherTimetable(teacherId);
    }
}
