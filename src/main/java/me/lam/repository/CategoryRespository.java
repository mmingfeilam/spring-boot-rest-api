package me.lam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.lam.model.Category;

import java.util.List;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Integer> {

//    List<Product> findByNameContainingOrPriceContaining(String name, Float price);

}
