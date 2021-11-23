package com.fzu.edumanagement.manager.student;

import com.fzu.edumanagement.dao.StudentCourseDAO;
import com.fzu.edumanagement.manager.BaseManager;
import com.fzu.edumanagement.model.vo.response.table.StudentExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;

    public ExamManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return studentCourseDAO.listStudentExam(studentId);
    }
}
