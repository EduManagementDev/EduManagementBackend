package com.fzu.edumanagement.controller;

import com.fzu.edumanagement.model.vo.request.LoginVO;
import com.fzu.edumanagement.model.vo.response.ResultVO;
import com.fzu.edumanagement.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResultVO login(@Validated @RequestBody LoginVO loginVO) {
        String username = loginVO.getUsername();
        String password = loginVO.getPassword();
        Integer userType = loginVO.getUserType();
        return service.login(username, password, userType);
    }

    @RequestMapping("/login/status")
    public ResultVO getLoginStatus() {
        return service.getLoginStatus();
    }

    @RequestMapping("/logout")
    public ResultVO logout() {
        return service.logout();
    }
}
