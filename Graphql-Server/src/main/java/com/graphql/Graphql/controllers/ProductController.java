package com.graphql.Graphql.controllers;

import com.graphql.Graphql.entity.Product;
import com.graphql.Graphql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @QueryMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
   @QueryMapping
   public List<Product> getProductsByCategory(@Argument String category){
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateStock(@Argument int id,@Argument int quantity){
        return productService.updateStock(id,quantity);
    }
    @MutationMapping
    public Product receiveNewShipment(@Argument int id,@Argument int quantity){
        return productService.receiveNewShipment(id,quantity);
    }
}
