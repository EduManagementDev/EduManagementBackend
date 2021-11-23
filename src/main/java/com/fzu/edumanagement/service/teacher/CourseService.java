package com.fzu.edumanagement.service.teacher;

import com.fzu.edumanagement.manager.teacher.CourseManager;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.model.vo.response.table.TeacherCourseItemVO;
import com.fzu.edumanagement.service.BaseService;
import com.fzu.edumanagement.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherCourseItemVO> list = manager.listTeacherCourse(teacherId);
        for (TeacherCourseItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }
}
