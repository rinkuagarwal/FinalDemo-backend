package com.ibm.ibmBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ibmBank.STATUS;
import com.ibm.ibmBank.entity.Account;
import com.ibm.ibmBank.repo.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;

	public String createAccount(Account account) {
		Account savedAccount = accountRepository.save(account);
		return savedAccount.getId();
	}

	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	public Optional<Account> getAccount(long number) {
		return accountRepository.findByNumber(number);
	}

	public STATUS updateAccountStatus(Account account) {
		accountRepository.save(account);
		return account.getStatus();
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

}
