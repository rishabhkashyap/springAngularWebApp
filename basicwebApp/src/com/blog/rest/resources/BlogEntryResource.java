package com.blog.rest.resources;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.blog.entity.BlogEntry;

public class BlogEntryResource extends ResourceSupport {
	
	private String title;
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public BlogEntry toBlogEntry() {
		BlogEntry entry = new BlogEntry();
		entry.setTitle(title);
		return entry;
	}

	
}
