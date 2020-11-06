package com.usermanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.usermanagement.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>  
{
public User findByFirstnameAndPassword(String firstName,String password);
  
}  