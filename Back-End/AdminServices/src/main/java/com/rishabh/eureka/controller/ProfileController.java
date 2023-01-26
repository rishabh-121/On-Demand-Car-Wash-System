package com.rishabh.eureka.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.eureka.entity.Profile;
import com.rishabh.eureka.repo.ProfileRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	ProfileRepo profileRepo;
	@PostMapping("/addProfile")
	public ResponseEntity<?> addProfile(@RequestBody Profile profile)
	{
		if(profileRepo.existsByUsername(profile.getUsername())) {
			profileRepo.deleteByUsername(profile.getUsername());
			Profile pro= new Profile(profile.getUsername(), profile.getFirstName(), profile.getLastName(),profile.getEmail(), profile.getPhone(), profile.getStreet(), profile.getCity(), profile.getState(), profile.getZip());
			profileRepo.save(pro);
			return ResponseEntity.ok(pro);
			
		}
		else {
			Profile pro= new Profile(profile.getUsername(), profile.getFirstName(), profile.getLastName(),profile.getEmail(), profile.getPhone(), profile.getStreet(), profile.getCity(), profile.getState(), profile.getZip());
			profileRepo.save(pro);
			return ResponseEntity.ok(pro);
			
		}
		
	}
	@GetMapping("/getProfile/{username}")
	public Optional<Profile> getProfile(@PathVariable("username") String username )
	{
		return Optional.of(profileRepo.findByUsername(username));
		
	}

}
