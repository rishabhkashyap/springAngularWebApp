package com.blog.services;

import com.blog.entity.Account;
import com.blog.entity.Blog;

public interface AccountService {
	
	public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);


}
