package com.rishabh.eureka;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rishabh.eureka.entity.Packages;
import com.rishabh.eureka.repo.PackagesRepo;
import com.rishabh.eureka.services.PackageService;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class PackagesApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	@Autowired
	private PackageService packageService;
	
	@MockBean
	private PackagesRepo packagesRepo;
	
	@Test
	public void savePackageTest() {
		Packages packages=new Packages("1","image.jpg","Latest","everything",500);
		when(packagesRepo.save(packages)).thenReturn(packages);
		assertEquals(packages,packageService.addPackages(packages));
	}
	
	@Test
	public void getPackagesTest() {
		when(packagesRepo.findAll()).thenReturn(Stream
				.of(new Packages("1","image.jpg","Latest","everything",500),new Packages("2","image.jpg","Latest","everything",500)).collect(Collectors.toList()));
		assertEquals(2, packageService.getPackages().size());
	}
	
	@Test
	public void deletePackageTest() {
		Packages packages=new Packages("1","image.jpg","Latest","everything",500);
		packageService.deletePackages(packages);
		verify(packagesRepo, times(1)).delete(packages);
	}
}
