package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.BlogEntry;
import com.blog.rest.resourceAssemblers.BlogEntryResourceAssembler;
import com.blog.rest.resources.BlogEntryResource;
import com.blog.services.BlogEntryService;

import test.BlogEntryControllerTest;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {

	private BlogEntryService service;

	public BlogEntryController(BlogEntryService service) {
		this.service = service;
	}

	// @RequestMapping("/test")
	// public @ResponseBody BlogEntry test() {
	// BlogEntry blog = new BlogEntry();
	// blog.setTitle("My Blog");
	// return blog;
	// }
	
	//To search a blog entry
	@RequestMapping(value = "/{entryId}", method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long entryId) {
		BlogEntry blog = service.findBlogById(entryId);
		if (blog != null) {
			BlogEntryResource resource = new BlogEntryResourceAssembler().toResource(blog);
			return new ResponseEntity<BlogEntryResource>(resource, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}

	}
	
	//To delete a blog entry
	
	@RequestMapping(value="/{entryId}" ,method=RequestMethod.DELETE)
	public ResponseEntity<BlogEntryResource> deleteBlogEntry(@PathVariable Long id){
		BlogEntry blog=service.delete(id);
		if(blog!=null){
			BlogEntryResource resource = new BlogEntryResourceAssembler().toResource(blog);
			return new ResponseEntity<BlogEntryResource>(resource,HttpStatus.OK);
		}else{
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//To update a blog entry
	
	@RequestMapping(value="/{entryId}",method=RequestMethod.PUT)
	public  ResponseEntity<BlogEntryResource> updateBlog(@PathVariable Long id,@RequestBody BlogEntryResource sentResource){
		BlogEntry blog=service.update(id, sentResource.toBlogEntry());
		if(blog!=null){
			//Creating uri for updated blog
			BlogEntryResource resource =new BlogEntryResourceAssembler().toResource(blog);
			return new ResponseEntity<BlogEntryResource>(resource,HttpStatus.OK);
		}else{
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}
