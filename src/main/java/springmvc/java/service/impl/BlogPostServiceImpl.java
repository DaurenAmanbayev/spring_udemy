package springmvc.java.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
import springmvc.java.service.BlogPostService;

public class BlogPostServiceImpl implements BlogPostService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	private BlogPostDAO blogPostDAO;	
	
	@Override
	public void savePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
		LOGGER.info("BlogPostServiceImpl: save post is called");
		blogPost.setPublishDate(new Date());
		blogPostDAO.save(blogPost);	
		
	}

	@Override
	public void saveDraft(BlogPost blogPost) {
		blogPost.setDraft(true);
		blogPostDAO.save(blogPost);
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		blogPostDAO.delete(blogPost);		
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {

		return blogPostDAO.findAllBlogPostByUserAndDraft(user, draft);
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
		
		return blogPostDAO.findAllBlogPostByUserAndTitleContaining(user, title);
	}

	@Override
	public BlogPost fingBlogPostById(long id) {

		return blogPostDAO.findOne(id);
	}
	
	
}
