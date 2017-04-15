package com.blog.rest.resourceAssemblers;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.blog.entity.BlogEntry;
import com.blog.rest.resources.BlogEntryResource;
import com.spring.controller.BlogEntryController;

import test.BlogEntryControllerTest;
//Resource assembler takes to type parameter
//1.Entity for which this resource assembler is created
//2.Resource support class for that entity

public class BlogEntryResourceAssembler extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {
	

	public BlogEntryResourceAssembler() {
		super(BlogEntryController.class, BlogEntryResource.class);		
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blog) {
		BlogEntryResource resource=new BlogEntryResource();
		resource.setTitle(blog.getTitle());
		Link link=linkTo(methodOn(BlogEntryController.class).getBlogEntry(blog.getId())).withSelfRel();
		resource.add(link.withSelfRel());
		return resource;
	}

}
