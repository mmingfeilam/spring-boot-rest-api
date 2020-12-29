package me.lam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.lam.model.Product;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingOrPriceContaining(String name, Float price);

}
