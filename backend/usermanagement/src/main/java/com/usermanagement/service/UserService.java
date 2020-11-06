package com.usermanagement.service;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import com.usermanagement.entities.User;  
import com.usermanagement.repositories.UserRepository; 
@Service 
public class UserService {
	@Autowired  
	UserRepository userRepos;  
	
	public List<User> getAllUsers()   
	{  
		List<User> userList = (List<User>) userRepos.findAll();
        
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<User>();
        }  
	}  
	public User getUserById(long id)   
	{  
	return userRepos.findById(id).get();  
	}  
	public void save(User user1)   
	{  
		userRepos.save(user1);  
	}  
	public void delete(long id)   
	{  
		userRepos.deleteById(id);  
	}  
	public void update(User userUpd)   
	{  
		userRepos.save(userUpd);  
	}  
	public boolean loginCheck(String name,String password)
	{
		User checkExist = userRepos.findByFirstnameAndPassword(name, password);
		if (checkExist != null) {
			return true;
		} else {
			return false;
		}
		
	}
}
