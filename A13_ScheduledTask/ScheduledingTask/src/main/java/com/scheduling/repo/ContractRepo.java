package com.scheduling.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduling.entity.Contract;

@Repository
public interface ContractRepo extends JpaRepository<Contract, String> {
}
