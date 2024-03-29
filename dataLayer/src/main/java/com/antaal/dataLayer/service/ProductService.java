package com.antaal.dataLayer.service;

import com.antaal.dataLayer.model.Product;
import com.antaal.dataLayer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }
    public Iterable<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> getProductsByCategoryName(String name) {
        return productRepository.findByCategoriesName(name);
    }

    public Iterable<Product> getProductsByCostLessThan(Integer cost) {
        return productRepository.findByCostLessThan(cost);
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
