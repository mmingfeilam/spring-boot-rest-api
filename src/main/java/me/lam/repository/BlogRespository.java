package me.lam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.lam.model.Blog;

import java.util.List;

@Repository
public interface BlogRespository extends JpaRepository<Blog, Integer> {

    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

}
