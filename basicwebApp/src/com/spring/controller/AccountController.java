package com.spring.controller;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.Account;
import com.blog.rest.resourceAssemblers.AccountResourceAssembler;
import com.blog.rest.resources.AccountResource;
import com.blog.service.exceptions.AccountExistException;
import com.blog.services.AccountService;

@Controller
@RequestMapping("/rest/account")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccount(@RequestBody AccountResource sentAccount) {
		AccountResource accountResource=null;
		HttpHeaders headers=new HttpHeaders();
		try{
			Account createdAccount=accountService.createAccount(sentAccount.toAccount());
			 accountResource=new AccountResourceAssembler().toResource(createdAccount);			
			headers.setLocation(URI.create(accountResource.getLink("self").getHref()));
			
			
		}catch(AccountExistException e){
			
		}
		return new ResponseEntity<AccountResource>(accountResource,headers,HttpStatus.CREATED);
				

	}
	
	@RequestMapping(value="/{accountId}" ,method=RequestMethod.GET)
	public ResponseEntity<AccountResource>getAccount(@PathVariable Long accountId){
		Account accountFound=accountService.findAccount(accountId);
		if(accountFound!=null){
			AccountResource resoure=new AccountResourceAssembler().toResource(accountFound);
			return new ResponseEntity<AccountResource>(resoure,HttpStatus.OK);
		}else{
			return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}

}
