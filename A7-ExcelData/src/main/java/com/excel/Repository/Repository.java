package com.excel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.model.Model;

public interface Repository extends JpaRepository<Model, Long>{

}
