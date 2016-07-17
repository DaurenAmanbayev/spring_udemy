package springmvc.java.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;
import springmvc.java.service.EmailService;

public class WordPressBlogPostServiceImpl implements BlogPostService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WordPressBlogPostServiceImpl.class);
	
	@Autowired
	private BlogPostDAO blogPostDAO;	
	
	@Override
	public void savePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
		LOGGER.info("BlogPostServiceImpl: save post is called");
		
		blogPostDAO.save(blogPost);	
		
	}

	@Override
	public void saveDraft(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost fingBlogPostById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
