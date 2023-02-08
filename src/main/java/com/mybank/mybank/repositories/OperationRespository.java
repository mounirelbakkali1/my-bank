package com.mybank.mybank.repositories;


import com.mybank.mybank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRespository extends JpaRepository<Operation,Long> {
}
