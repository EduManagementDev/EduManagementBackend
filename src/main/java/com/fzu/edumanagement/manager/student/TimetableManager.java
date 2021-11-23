package com.fzu.edumanagement.manager.student;

import com.fzu.edumanagement.dao.StudentCourseDAO;
import com.fzu.edumanagement.manager.BaseManager;
import com.fzu.edumanagement.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("student_timetableManager")
public class TimetableManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;

    public TimetableManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    public List<TimetableItemVO> listStudentTimetable(Integer studentId) {
        return studentCourseDAO.listStudentTimetable(studentId);
    }
}
