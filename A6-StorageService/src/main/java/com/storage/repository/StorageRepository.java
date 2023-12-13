package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.entity.ImageData;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String name);
}