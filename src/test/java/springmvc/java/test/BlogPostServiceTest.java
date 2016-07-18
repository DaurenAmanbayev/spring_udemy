package springmvc.java.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import springmvc.java.config.WebConfig;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {WebConfig.class}, loader=AnnotationConfigWebContextLoader.class)
public class BlogPostServiceTest {

	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testBlogPostService() {
		
		User user = userService.findUserById(1);
		assertNotNull(user);
		
		BlogPost post = new BlogPost();
		post.setTitle("title 1");
		post.setContent("content 1");
		post.setUser(user);
		
		blogPostService.savePost(post);
		
		blogPostService.deleteBlogPost(post);
		
		assertTrue(blogPostService.listAllBlogPostsByUserAndTitleLike(user, "title 1").size() == 0);
	
	
	}
	
	@Test
	public void testBlogPostServiceDraft() {
		
		User user = userService.findUserById(1);
		assertNotNull(user);
		
		BlogPost post = new BlogPost();
		post.setTitle("title 2");
		post.setContent("content 2");
		post.setUser(user);
		
		blogPostService.saveDraft(post);
		
		assertTrue(blogPostService.listAllBlogPostsByUserAndDraftStatus(user, true).size() > 0);

	}

}
