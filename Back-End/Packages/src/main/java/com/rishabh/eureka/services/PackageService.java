package com.rishabh.eureka.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.eureka.entity.Packages;
import com.rishabh.eureka.repo.PackagesRepo;

@Service
public class PackageService {
	
	@Autowired
	private PackagesRepo packagesRepo;
	
	public Packages addPackages(Packages packages) {
		return packagesRepo.save(packages);
	}
	
	public List<Packages> getPackages(){
		return packagesRepo.findAll();
		
	}

	public void deletePackages(Packages packages) {
		packagesRepo.delete(packages);
	}
}
