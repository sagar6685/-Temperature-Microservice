package com.sdp.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdp.user.VO.ResponseTemplateVO;
import com.sdp.user.constant.UserConstant;
import com.sdp.user.model.User;
import com.sdp.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        logger.info("Inside saveUser of UserController");
        userService.saveUser(user);
        return user.getUserName() + " " + UserConstant.SUCCESS_RESPONSE;
    }

    @GetMapping("/findUserById/{id}")
	public ResponseTemplateVO getUserById(@PathVariable int id) {
    	logger.info("Inside getUserById of UserController");
		return userService.userById(id);
	}


}
