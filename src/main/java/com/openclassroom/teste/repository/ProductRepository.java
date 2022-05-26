package com.openclassroom.teste.repository;

import com.openclassroom.teste.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    //Utilisation des requétes personnalisées

     Iterable<Product> findAByName(String name);

}
