package com.excel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excel.Helper.ExcelHelper;
import com.excel.Repository.Repository;
import com.excel.model.Model;

@Service
public class ExcelService {

	@Autowired
	  Repository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<Model> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
	      repository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<Model> getAllTutorials() {
	    return repository.findAll();
	  }
}
