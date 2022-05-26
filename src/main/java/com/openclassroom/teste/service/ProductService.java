package com.openclassroom.teste.service;

import com.openclassroom.teste.model.Product;
import com.openclassroom.teste.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public  Iterable<Product> getProducts()
    {
        return  productRepository.findAll();
    }
    public Optional<Product> getProductById(@PathVariable("id") Integer id)
    {
        return  productRepository.findById(id);
    }

    public Product addProduct(Product produit) {
        return productRepository.save(produit);
    }

    public void deleteProduitById(@PathVariable("id") Integer id){
        productRepository.deleteById(id);
    }

     //Ajout dd méthode pour
    public Iterable<Product> getProductsByName(String name){
        return productRepository.findByName(name);
    }
//    
    // recupérer les produits en fonction du nom d'une categorie
    public Iterable<Product> getProductsByCategoryName(String nom){
        return productRepository.findByCategoriesName(nom);
    }
}
