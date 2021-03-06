package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;

import springmvc.java.domain.User;


public interface UserDAO extends CrudRepository<User, Long>{

	User findUserByUserName(String username);
	
}
