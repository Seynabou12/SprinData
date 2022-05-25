package com.openclassroom.teste.service;

import com.openclassroom.teste.model.Product;
import com.openclassroom.teste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public  Iterable<Product> getProducts()
    {
        return  productRepository.findAll();
    }
    public Optional<Product> getProductById(Integer id)
    {
        return  productRepository.findById(id);
    }

    public Product addProduct(Product produit) {
        return productRepository.save(produit);
    }
}
