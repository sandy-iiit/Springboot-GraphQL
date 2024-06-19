package com.graphql.Graphql.service;

import com.graphql.Graphql.entity.Product;
import com.graphql.Graphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public Product updateStock(int id,int quantity){
        Product existing=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found with id "+id));
        existing.setStock(quantity);
        return productRepository.save(existing);
    }
    public Product receiveNewShipment(int id,int quantity){
        Product existing=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found with id "+id));
        existing.setStock(existing.getStock()+quantity);
        return productRepository.save(existing);
    }

}
