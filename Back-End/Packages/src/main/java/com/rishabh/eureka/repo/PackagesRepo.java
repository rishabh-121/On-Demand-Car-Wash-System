package com.rishabh.eureka.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rishabh.eureka.entity.Packages;

public interface PackagesRepo extends MongoRepository<Packages, Integer> {

}
