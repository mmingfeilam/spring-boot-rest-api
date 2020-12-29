package me.lam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.lam.model.Blog;
import me.lam.repository.BlogRespository;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogRespository blogRespository;

	public List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain) {
		return blogRespository.findByTitleContainingOrContentContaining(text, textAgain);
	}

	@Transactional
	public Blog save(Blog blog) {
		return blogRespository.save(blog);
	}
}
