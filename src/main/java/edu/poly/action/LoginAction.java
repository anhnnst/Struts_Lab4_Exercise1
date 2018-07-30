package edu.poly.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.poly.model.User;
import edu.poly.service.IUserService;

public class LoginAction extends ActionSupport 
		implements SessionAware, ModelDriven<User> {

	private static final long serialVersionUID = -3369875299120377549L;

	private User user = new User();

	@Autowired
	private IUserService service;
	
	private Map<String, Object> sessionAttributes = null;
	
	public LoginAction(IUserService service) {
		this.service = service;
	}
	
	@Override
	public String execute() {
		System.out.println("inside execute");
		System.out.println(service);
		System.out.println(user);
		if (user.getUserName() == null) {
			return INPUT;
		}
		
		user = service.checkLogin(user.getUserName(), user.getPassword());
		if (user != null) {
			//user.setName("Anh Nguyen Ngoc");
			sessionAttributes.put("USER", user);
			return SUCCESS;
		}
		return INPUT;
	}

	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}