package com.sdp.user.service;

import com.sdp.user.VO.ResponseTemplateVO;
import com.sdp.user.model.User;

public interface UserService {

	public User saveUser(User user);

	public ResponseTemplateVO userById(int id);

}
