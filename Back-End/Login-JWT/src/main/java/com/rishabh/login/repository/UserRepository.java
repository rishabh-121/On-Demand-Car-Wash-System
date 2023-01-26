package com.rishabh.login.repository;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.rishabh.login.entity.User;

/*
 * public interface UserRepository extends JpaRepository<User,Integer> { User
 * findByUserName(String username); }
 */
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, Integer>
{
	public User findByUserName(String userName );
}
