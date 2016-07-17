package springmvc.java.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.java.service.impl.BlogPostServiceImpl;

@Controller
public class EmbeddedDatabaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedDatabaseController.class);


	@Autowired
	@Qualifier("dataSourceEmbedded")
	private DataSource embeded;
	
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/displayusers")
	public void displayUsers() {
		//embedded database
		jdbcTemplate = new JdbcTemplate(embeded);
		
		List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT*FROM USER");
		
		for(Map<String, Object> user: users) {
			LOGGER.debug("username: "+ user.get("username"));
		}
	}
	
}
