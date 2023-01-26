package com.rishabh.booking.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rishabh.booking.entity.BookNow;
import com.rishabh.booking.repo.BookNowRepository;

@Service
public class PhotoService {
	
	@Autowired
    private BookNowRepository bookNowRepository;

    public String addCustomerData(String username,String firstName, String lastName, String email, String contactNo, String address1, String address2,
			String city, String state, String zip, String carNo, String date ,String packageName, String packageDesc,int price,String imageUrl,String washerName,String status,boolean isCancelled,  MultipartFile file) throws IOException { 
       // BookNow bookNow = new BookNow(book.getFirstName(),book.getLastName(),book.getEmail(),book.getContactNo(),book.getAddress1(),book.getAddress2(),book.getCity(),book.getState(),book.getZip(),book.getCarNo(),book.getDate()); 
    	List<String> list=new ArrayList<>();
    	
    	BookNow bookNow = new BookNow(username,firstName,lastName,email,contactNo,address1,address2,city,state,zip,carNo,date,packageName,packageDesc,price,imageUrl,washerName,status,isCancelled,list);
    	bookNow.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
    	bookNow.setWashedCarImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        bookNow = bookNowRepository.insert(bookNow);
        return bookNow.getId(); 
    }

    public BookNow getPhoto(String id) { 
        return bookNowRepository.findById(id).get(); 
    }
    
    public ResponseEntity<?> getDetails(String username)
    {
    	//bookNowRepository.findByUsername(username);
    	
    	return ResponseEntity.ok(bookNowRepository.findAllByUsername(username));
    }
}


