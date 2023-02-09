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
    @Query("select o from Operation o where o.compte.codeDeCompte =:x order by o.dateOfOperation desc")
    public Page<Operation> getListOperations(@Param("x") String codeCompte , Pageable pageable);
}
