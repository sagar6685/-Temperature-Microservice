package com.sdp.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sdp.user.VO.ResponseTemplateVO;
import com.sdp.user.VO.Temperature;
import com.sdp.user.model.User;
import com.sdp.user.repository.UserRepository;
import com.sdp.user.service.UserService;

@Service("TemperatureServiceImpl")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	   
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		logger.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO userById(int id) {
		logger.info("Inside userById of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Optional<User> user = userRepository.findById(id);

		logger.debug("UserService : user data isPresent ->"+ user.isPresent());
		
		User userData = null;
		if (user.isPresent()) {
			userData = user.get();
		}
		
		logger.debug("UserService : user data ->"+ userData.toString());

		ResponseEntity<List<Temperature>> rateResponse = restTemplate.exchange(
				"http://TEMPERATURE-SERVICE/temperature/findByUserName/" + userData.getUserName(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Temperature>>() {	});
		
		List<Temperature> temperatureLst = rateResponse.getBody();

		logger.debug("UserService : temperatureLst data ->"+ temperatureLst.toString());
		
		vo.setUser(userData);
		vo.setTemperature(temperatureLst);

		logger.info("End of userById of UserService");
		
		return vo;
	}

}
