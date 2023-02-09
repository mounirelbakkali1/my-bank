package com.mybank.mybank.repositories;


import com.mybank.mybank.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRespository extends JpaRepository<Operation,Long> {
    @Query(value = "select * from operations  where code_client =:x order by date_of_operation desc",nativeQuery = true)
    public Page<Operation> getListOperations(@Param("x") String codeCompte , Pageable pageable);
}
