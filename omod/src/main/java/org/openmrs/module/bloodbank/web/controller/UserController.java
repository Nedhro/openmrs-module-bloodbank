package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "module/bloodbank/")
public class UserController {
	
	/**
	 * Logger for this class and subclasses
	 */
	protected final Log log = LogFactory.getLog(getClass());
	
	private final String userView = "module/bloodbank/views/user/users";
	
	private final String donorFormView = "module/bloodbank/views/donor/donorForm";
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String onGet() {
		return userView;
	}
	
	@RequestMapping(value = "donor/info", method = RequestMethod.GET)
	public String donorForm() {
		return donorFormView;
	}
	
	@RequestMapping(value = "bloodbank", method = RequestMethod.POST)
	public String onPost(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		
		if (errors.hasErrors()) {
			// return error view
		}
		
		return userView;
	}
	
	@ModelAttribute("users")
	protected List<User> getUsers() throws Exception {
		List<User> users = userService.getAllUsers();
		return users;
	}
	
}
