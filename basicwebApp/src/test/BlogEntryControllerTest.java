package test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.EndsWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.blog.entity.BlogEntry;
import com.blog.services.BlogEntryService;
import com.spring.controller.BlogEntryController;

public class BlogEntryControllerTest {

	@InjectMocks
	private BlogEntryController blogEntryController;
	
	@Mock
	private BlogEntryService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(blogEntryController).build();
	}
	
//	@Test
//	public void test() throws Exception {
//		mockMvc.perform(get("/test"))
//				.andDo(print());
//		
//	}
	@Test
	public void getExistingBlog()throws Exception{
		//Creating mock blog
		BlogEntry blog=new BlogEntry();
		blog.setId(1L);
		blog.setTitle("Maiden blog");
		
		//Testing findby method and returning mock blog
		when(service.findBlogById(1L))
		.thenReturn(blog);
		
		//This method chaining defines what controller should do 
		//ones it gets request or resource
		mockMvc.perform(get("/rest/blog-entries/1"))
				.andDo(print())
				.andExpect(jsonPath("$.title", is(blog.getTitle())))
				.andExpect(	jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
				.andExpect(status().isOk());
				
		
	}

}
