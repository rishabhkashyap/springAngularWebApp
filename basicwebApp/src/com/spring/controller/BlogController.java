package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.entity.Blog;
import com.blog.rest.resourceAssemblers.BlogResourceAssembler;
import com.blog.rest.resources.BlogResource;
import com.blog.services.BlogEntryService;
import com.blog.services.BlogService;

public class BlogController {
	 private BlogService blogService;

	    public BlogController(BlogService blogService) {
	        this.blogService = blogService;
	    }
	    
	    @RequestMapping(value="/{blogId}",
	            method = RequestMethod.GET)
	        public ResponseEntity<BlogResource> getBlog(@PathVariable Long blogId)
	        {
	            Blog blog = blogService.findBlog(blogId);
	            BlogResource res = new BlogResourceAssembler().toResource(blog);
	            return new ResponseEntity<BlogResource>(res, HttpStatus.OK);
	        }

}
