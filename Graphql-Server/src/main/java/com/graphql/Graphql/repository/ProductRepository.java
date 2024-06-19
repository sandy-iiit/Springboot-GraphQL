package com.graphql.Graphql.repository;

import com.graphql.Graphql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(String category);
}
