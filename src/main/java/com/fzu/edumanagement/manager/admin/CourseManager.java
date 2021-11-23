package com.fzu.edumanagement.manager.admin;

import com.fzu.edumanagement.dao.CourseDAO;
import com.fzu.edumanagement.dao.StudentCourseDAO;
import com.fzu.edumanagement.dao.TeacherDAO;
import com.fzu.edumanagement.manager.BaseManager;
import com.fzu.edumanagement.model.bo.CourseItemBO;
import com.fzu.edumanagement.model.entity.CourseEntity;
import com.fzu.edumanagement.model.entity.TeacherEntity;
import com.fzu.edumanagement.model.vo.response.IdNameVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseManager extends BaseManager {
    private final TeacherDAO teacherDAO;
    private final CourseDAO courseDAO;
    private final StudentCourseDAO studentCourseDAO;

    public CourseManager(TeacherDAO teacherDAO, CourseDAO courseDAO, StudentCourseDAO studentCourseDAO) {
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
        this.studentCourseDAO = studentCourseDAO;
    }

    public Integer getPageCount(String departmentName, String teacherName, String name) {
        int count = courseDAO.count(departmentName, teacherName, name);
        return calcPageCount(count, CourseDAO.PAGE_SIZE);
    }

    public List<CourseItemBO> getPage(Integer index, String departmentName, String teacherName, String name) {
        return courseDAO.getPage(index, departmentName, teacherName, name);
    }

    public CourseEntity get(Integer id) {
        return courseDAO.get(id);
    }

    public int create(CourseEntity entity) {
        return courseDAO.insert(entity);
    }

    public int update(CourseEntity entity) {
        return courseDAO.update(entity);
    }

    public int delete(Integer id) {
        return courseDAO.delete(id);
    }

    public TeacherEntity getTeacherById(Integer teacherId) {
        return teacherDAO.get(teacherId);
    }

    public boolean hasStudentCourse(Integer courseId) {
        return studentCourseDAO.countByCourseId(courseId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<CourseEntity> entityList = courseDAO.listName();
        for (CourseEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
