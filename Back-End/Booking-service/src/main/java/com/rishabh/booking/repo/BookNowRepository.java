package com.rishabh.booking.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import com.rishabh.booking.entity.BookNow;

public interface BookNowRepository extends MongoRepository<BookNow, String> {
	List<BookNow> findAllByUsername(String username);

}
