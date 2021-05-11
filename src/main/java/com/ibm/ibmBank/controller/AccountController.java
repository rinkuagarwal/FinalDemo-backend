package com.ibm.ibmBank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ibmBank.entity.Account;
import com.ibm.ibmBank.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;

	/*
	 * Create new account
	 * 
	 * @param account
	 * 
	 * @param bindingResult
	 */
	@PostMapping("/account")
	String createAccount(@RequestBody Account account, BindingResult bindingResult) {
		validateModel(bindingResult);
		return accountService.createAccount(account);
	}

	/**
	 * validation
	 * 
	 * @param bindingResult
	 */
	private void validateModel(Errors bindingResult) {

		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong!!");
		}
	}

	/*
	 * Display all the accounts
	 */
	@GetMapping("/account")
	List<Account> getAccounts() {
		return accountService.getAccounts();
	}

	/*
	 * Display only those account details that matches with a given Account number
	 * 
	 * @param number
	 * 
	 * @return account
	 */
	@GetMapping("/account/number/{number}")
	Optional<Account> getAccount(@PathVariable("number") long number) {
		return accountService.getAccount(number);
	}

	/*
	 * Update account details
	 * 
	 * @param accountId
	 * 
	 * @param bindingResult
	 * 
	 */
	@PutMapping("/account/{id}")
	void updateAccountStatus(@RequestBody Account account, @PathVariable("id") String accountId,
			BindingResult bindingResult) {
		validateModel(bindingResult);
		account.setId(accountId);
		accountService.updateAccountStatus(account);

	}
}
