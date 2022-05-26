package com.openclassroom.teste.repository;

import com.openclassroom.teste.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Iterable<Product> findByName(String nom);

    public Iterable<Product> findByCategoriesName(String nom);

}
