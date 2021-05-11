package com.ibm.ibmBank.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.ibmBank.entity.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

	Optional<Account> findByNumber(long number);

}
