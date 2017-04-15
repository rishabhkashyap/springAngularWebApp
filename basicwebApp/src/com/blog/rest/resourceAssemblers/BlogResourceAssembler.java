package com.blog.rest.resourceAssemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.blog.entity.Blog;
import com.blog.rest.resources.BlogResource;
import com.spring.controller.BlogController;
import com.spring.controller.BlogEntryController;

public class BlogResourceAssembler extends ResourceAssemblerSupport<Blog, BlogResource> {
	

	public BlogResourceAssembler(Class<?> controllerClass, Class<BlogResource> resourceType) {
		super(BlogController.class, BlogResource.class);
		
	}

	@Override
	public BlogResource toResource(Blog entity) {
		BlogResource resource=new BlogResource();
		resource.setTitle(entity.getTitle());		
		Link link=linkTo(methodOn(BlogController.class).getBlog(entity.getId())).withSelfRel();
		resource.add(link);		
		return resource;
	}

}
