package com.rishabh.eureka.repo;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.rishabh.eureka.entity.Profile;

public interface ProfileRepo extends MongoRepository<Profile, String> {
	
	Profile findByUsername(String username);
	Boolean existsByUsername(String username);
	Profile deleteByUsername(String username);

}
