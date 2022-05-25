package com.openclassroom.teste.repository;

import com.openclassroom.teste.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository  extends CrudRepository<Categorie, Integer> {
}
