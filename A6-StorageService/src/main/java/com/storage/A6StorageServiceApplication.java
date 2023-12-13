package com.storage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.storage.service.StorageService;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class A6StorageServiceApplication {
	
	@Autowired
	private StorageService service;
	
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
	String uploadImage=	service.uploadImage(file);
	return ResponseEntity.status(HttpStatus.OK)
			.body(uploadImage);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
	byte[] imageData=service.downloadImage(fileName);
	return ResponseEntity.status(HttpStatus.OK)
			.contentType(MediaType.valueOf("image/png"))
			.body(imageData);
	
	}
	public static void main(String[] args) {
		SpringApplication.run(A6StorageServiceApplication.class, args);
	}

}