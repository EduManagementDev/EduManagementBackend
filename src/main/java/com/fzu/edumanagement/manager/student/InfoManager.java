package com.fzu.edumanagement.manager.student;

import com.fzu.edumanagement.dao.StudentDAO;
import com.fzu.edumanagement.manager.BaseManager;
import com.fzu.edumanagement.model.entity.StudentEntity;
import com.fzu.edumanagement.model.vo.response.StudentInfoVO;
import org.springframework.stereotype.Component;

@Component
public class InfoManager extends BaseManager {
    private final StudentDAO studentDAO;

    public InfoManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInfoVO getStudentInfoByStudentId(Integer studentId) {
        return studentDAO.getStudentInfoById(studentId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }

    public int updateStudent(StudentEntity entity) {
        return studentDAO.update(entity);
    }
}
