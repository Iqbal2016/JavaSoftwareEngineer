/**
 * 
 */
package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.spring.boot.entity.Transaction;

/**
 * @author MI
 *
 */
@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Id> {

}
