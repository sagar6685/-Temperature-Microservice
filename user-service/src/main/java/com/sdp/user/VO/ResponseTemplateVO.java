package com.sdp.user.VO;

import java.util.List;

import com.sdp.user.model.User;

public class ResponseTemplateVO {

    private User user;
    private List<Temperature> temperature;
	
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Temperature> getTemperature() {
		return temperature;
	}
	public void setTemperature(List<Temperature> temperature) {
		this.temperature = temperature;
	}
	
    
}
