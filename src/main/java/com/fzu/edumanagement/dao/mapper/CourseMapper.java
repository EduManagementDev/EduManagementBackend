package com.fzu.edumanagement.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fzu.edumanagement.model.bo.CourseItemBO;
import com.fzu.edumanagement.model.bo.StudentCourseSelectItemBO;
import com.fzu.edumanagement.model.entity.CourseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper extends BaseMapper<CourseEntity> {
    Integer count(String departmentName, String teacherName, String name);

    IPage<CourseItemBO> getPage(IPage<CourseItemBO> page, String departmentName, String teacherName, String name);

    Integer countStudentCanSelect(Integer studentId, Integer departmentId, Integer grade, String courseName, String teacherName);

    IPage<StudentCourseSelectItemBO> getStudentCanSelectPage(IPage<StudentCourseSelectItemBO> page, Integer studentId, Integer departmentId, Integer grade, String courseName, String teacherName);

    Integer getDepartmentIdById(Integer courseId);
}
