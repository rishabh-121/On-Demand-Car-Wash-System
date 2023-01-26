package com.rishabh.booking.controller;

/*import java.io.FileInputStream;
import java.io.FileNotFoundException;*/
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.rishabh.booking.entity.BookNow;
import com.rishabh.booking.repo.BookNowRepository;
import com.rishabh.booking.service.PhotoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BinaryData {
	
	@Autowired
	private PhotoService photoService;
	@Autowired
	private BookNowRepository bookNowRepository;
	
	@PostMapping(value="/photos")
	
	public String addPhoto(@RequestParam("username") String un,@RequestParam("first") String fn,@RequestParam("last") String ln,
			@RequestParam("em") String em,@RequestParam("cn") String cn,@RequestParam("ad1") String ad1,@RequestParam("ad2") String ad2,
			@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("zip") String zip,@RequestParam("caN") String caN,
			@RequestParam("date") String date,@RequestParam("pn") String pn,@RequestParam("pd") String pd,@RequestParam("pc") int pc,@RequestParam("iu") String iu,
			@RequestParam(value="wn",defaultValue = "Pending") String wn,@RequestParam("status") String status,
			@RequestParam("isc") Boolean isCancelled, @RequestParam("image") MultipartFile image) throws IOException 
	   {
	    String id = photoService.addCustomerData(un,fn,ln,em,cn,ad1,ad2,city,state,zip,caN,date,pn,pd,pc,iu,wn,status,isCancelled, image);
	    return "redirect:/photos/" + id;
	}
	
	@GetMapping("/getBookingDetails")
	public Iterable<BookNow> getBookingDetails(@RequestParam("username") String un)
	{
		return bookNowRepository.findAllByUsername(un);
	}
	
	@GetMapping("/getInvoiceDetails/{id}")
	public ResponseEntity<BookNow> getInvoiceDetails(@PathVariable("id")String id)
	{
		
		Optional<BookNow> bookNow=bookNowRepository.findById(id);
		if(bookNow.isPresent()) {
			BookNow invoice=bookNow.get();
			StringBuilder base64 = new StringBuilder("data:image/png;base64,");
			base64.append(Base64.getEncoder().encodeToString(invoice.getImage().getData()));
			invoice.setImageString(base64.toString());
			
			StringBuilder newbase64 = new StringBuilder("data:image/png;base64,");
			newbase64.append(Base64.getEncoder().encodeToString(invoice.getWashedCarImage().getData()));
			invoice.setWashedImageString(newbase64.toString());
			return new ResponseEntity<>(invoice,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/getAllBookingDetails")
	public Iterable<BookNow> getAllBookingDetails()
	{
		
		List<BookNow> bookNow=new ArrayList<>();
		bookNow= bookNowRepository.findAll();
		List<BookNow> iter = new ArrayList<>();;
		for(BookNow book:bookNow) {
			StringBuilder base64 = new StringBuilder("data:image/png;base64,");
			base64.append(Base64.getEncoder().encodeToString(book.getImage().getData()));
			book.setImageString(base64.toString());
			iter.add(book);
			
			//bookNow.add(book);
			
		}
		return iter;
		
	}
	@PutMapping("/updateCancellReq/{id}/{isc}")
	public ResponseEntity<BookNow> updateCancellReq(@PathVariable("id")String id,@PathVariable("isc") Boolean isCancelled)
	{
		Optional<BookNow> bookNowData = bookNowRepository.findById(id);
		if(bookNowData.isPresent())
		{
			BookNow bookNow=bookNowData.get();
			bookNow.setCancelled(isCancelled);
			return new ResponseEntity<>(bookNowRepository.save(bookNow),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/acceptBooking/{id}/{washer}")
	public ResponseEntity<BookNow> acceptBooking(@PathVariable("id")String id,@PathVariable("washer") String washerName)
	{
		Optional<BookNow> bookNowData = bookNowRepository.findById(id);
		if(bookNowData.isPresent())
		{
			BookNow bookNow=bookNowData.get();
			bookNow.setWasherName(washerName);
			return new ResponseEntity<>(bookNowRepository.save(bookNow),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/washerCancelBooking/{id}/{washer}")
	public ResponseEntity<BookNow> washerCancelBooking(@PathVariable("id")String id,@PathVariable("washer") String washerName)
	{
		Optional<BookNow> bookNowData = bookNowRepository.findById(id);
		if(bookNowData.isPresent())
		{
			BookNow bookNow=bookNowData.get();
			List<String> washerUserName=bookNow.getIsWasherCancelled();
			washerUserName.add(washerName);
			bookNow.setIsWasherCancelled(washerUserName);
			return new ResponseEntity<>(bookNowRepository.save(bookNow),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
		@PutMapping("/doneBooking")
		public ResponseEntity<BookNow> doneBooking(@RequestParam("id")String id,@RequestParam("status")String status,@RequestParam("image") MultipartFile image) throws IOException
		{
			Optional<BookNow> bookNowData = bookNowRepository.findById(id);
			if(bookNowData.isPresent())
			{
				BookNow bookNow=bookNowData.get();
				bookNow.setStatus(status);
				bookNow.setWashedCarImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
				
				return new ResponseEntity<>(bookNowRepository.save(bookNow),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
	}
	/*
	 * @Autowired private GridFsOperations gridFsOperations;
	 * 
	 * String fileId = "";
	 * 
	 * @PostMapping("/saveFiles") public String saveFile(@RequestParam("image")
	 * MultipartFile file) throws IOException { // define metadata DBObject metaData
	 * = new BasicDBObject(); metaData.put("organization", "Java Techie");
	 * 
	 * 
	 * // store image file InputStream inputStream = file.getInputStream();
	 * metaData.put("type", "image");
	 * 
	 * gridFsOperations.store(inputStream, file.getOriginalFilename(),
	 * file.getContentType(), metaData); System.out.println("File id stored : " +
	 * fileId);
	 * 
	 * return "image added succesfully!";
	 * 
	 * }
	 */
}
