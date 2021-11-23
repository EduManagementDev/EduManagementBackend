package com.fzu.edumanagement;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fzu.edumanagement.dao.mapper.MajorMapper;
import com.fzu.edumanagement.dao.mapper.StudentCourseMapper;
import com.fzu.edumanagement.model.entity.MajorEntity;
import com.fzu.edumanagement.model.entity.StudentCourseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.AccessType;

import java.util.List;

@SpringBootTest
class EduManagementApplicationTests {
    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<StudentCourseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(StudentCourseEntity::getId)
                .eq(StudentCourseEntity::getCourseId, 1)
                .eq(StudentCourseEntity::getStudentId, 1);
        System.out.println(studentCourseMapper.selectOne(wrapper));
    }
}
