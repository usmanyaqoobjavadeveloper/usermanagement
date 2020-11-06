package com.usermanagement.controllers;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.entities.Login;
import com.usermanagement.entities.User;
import com.usermanagement.service.UserService;  

@RestController 
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	@Autowired  
	UserService userService;  
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	private List<User> getAllUsers()   
	{  
	return userService.getAllUsers();  
	}  
	@RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
	private User getUserById(@PathVariable("userid") int userid)   
	{  
	return userService.getUserById(userid);  
	}  
	@RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE)
	private void deleteUser(@PathVariable("userid") int userid)   
	{  
		userService.delete(userid);  
	}  
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	private long saveUser(@RequestBody User user1)   
	{  
		userService.save(user1);  
	return user1.getUserid();  
	}  
	@RequestMapping(value = "/userupdate", method = RequestMethod.PUT)
	private User update(@RequestBody User userUp)   
	{  
		userService.update(userUp);  
	return userUp;  
	}  
	@RequestMapping(value = "/login/{firstname}/{password}/", method = RequestMethod.GET)
	private boolean logincheck(@PathVariable("firstname") String firstname,@PathVariable("password") String password)   
	{  
		return userService.loginCheck(firstname, password);  
	} 
}
