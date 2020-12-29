package me.lam.service;

import java.util.List;

import me.lam.model.Blog;

public interface BlogService {

	List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

	Blog save(Blog blog);
}
