package com.blog.rest.resourceAssemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.blog.entity.Account;
import com.blog.rest.resources.AccountResource;
import com.spring.controller.AccountController;
import com.spring.controller.BlogEntryController;

public class AccountResourceAssembler extends ResourceAssemblerSupport<Account,AccountResource> {
	

	public AccountResourceAssembler() {
		super(AccountController.class, AccountResource.class);		
	}

	@Override
	public AccountResource toResource(Account account) {
		AccountResource accountResource=new AccountResource();
		accountResource.setPassword(account.getPassword());
		accountResource.setUsername(account.getusername());
		Link link=linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel();
		accountResource.add(link.withSelfRel());
		return accountResource;
	}

}
