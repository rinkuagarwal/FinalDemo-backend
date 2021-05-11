package com.ibm.ibmBank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ibm.ibmBank.entity.Account;
import com.ibm.ibmBank.repo.AccountRepository;
import com.ibm.ibmBank.service.AccountService;

public class AccountServiceTest {
	
	@Test
	public void testCreateAccount() {
		AccountService accountService = new AccountService();
		AccountRepository dummyRepo = new DummyAccountRepository();
		accountService.setAccountRepository(dummyRepo);
		Account account = new Account();
		String accountId = accountService.createAccount(account);
		assertNotNull(accountId);
	}
	@Test
	void testGetAccounts() {
		AccountService accountService = new AccountService();
		AccountRepository dummyRepo = new DummyAccountRepository();
		accountService.setAccountRepository(dummyRepo);
		Account account = new Account();
		String accountId = accountService.createAccount(account);
		assertNotNull(accountId);
	}
	@Test
	void testUpdateAccountStatus() {
		AccountService accountService= new AccountService();
		AccountRepository dummyRepo = new DummyAccountRepository();
		accountService.setAccountRepository(dummyRepo);
		Account account = new Account();
		STATUS status = accountService.updateAccountStatus(account);
		assertNotNull(status);
		assertEquals(STATUS.ACTIVE, status);
	}

}
