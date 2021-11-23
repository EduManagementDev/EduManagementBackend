package com.fzu.edumanagement.service.student;

import com.fzu.edumanagement.manager.student.InfoManager;
import com.fzu.edumanagement.model.entity.StudentEntity;
import com.fzu.edumanagement.model.vo.request.StudentInfoFormVO;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.BaseService;
import com.fzu.edumanagement.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InfoService extends BaseService {
    private final UserService userService;

    private final InfoManager manager;

    public InfoService(UserService userService, InfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getStudentInfoByStudentId(getUserId()));
    }

    public ResultVO update(@RequestBody @Validated StudentInfoFormVO studentInfoForm) {
        StudentEntity student = manager.getStudentById(getUserId());

        String password = studentInfoForm.getPassword();
        if (password == null || password.equals("")) {
            password = student.getPassword();
        } else {
            password = userService.computePasswordHash(password);
        }

        BeanUtils.copyProperties(studentInfoForm, student);
        student.setPassword(password);
        manager.updateStudent(student);

        return result("更新成功");
    }
}
