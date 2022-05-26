package com.openclassroom.teste.service;

import com.openclassroom.teste.model.Categorie;
import com.openclassroom.teste.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Iterable<Categorie> getCategories()
    {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorieById(Integer id)
    {
        return categorieRepository.findById(id);
    }
    public Categorie addCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    public void deleteCategorieById(Integer id){
        categorieRepository.deleteById(id);
    }
}
