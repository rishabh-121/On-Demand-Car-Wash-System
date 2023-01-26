package com.rishabh.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.eureka.entity.Packages;
import com.rishabh.eureka.repo.PackagesRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/packages")
public class PackageController {
	
	@Autowired
	PackagesRepo packagesRepo;
	
	@PostMapping("/addpackages")
	public ResponseEntity<?> addPackages(@RequestBody Packages packages)
	{
		Packages pack=new Packages(packages.getId(), packages.getImage(),packages.getPackageName(),packages.getPackageDesc(),packages.getPrice());
		packagesRepo.save(pack);
		return ResponseEntity.ok(pack);
		
	}
	@GetMapping("/getpackages")
	public Iterable<Packages> getPackages(){
		return packagesRepo.findAll();
	}
	

}
