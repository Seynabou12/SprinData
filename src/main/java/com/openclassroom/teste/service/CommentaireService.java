package com.openclassroom.teste.service;

import com.openclassroom.teste.model.Commentaire;
import com.openclassroom.teste.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public  Iterable<Commentaire> getCommentaires()
    {
        return commentaireRepository.findAll();
    }
    public Optional<Commentaire> getCommentaireById(Integer id)
    {
        return commentaireRepository.findById(id);
    }

    public Commentaire addCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public void deleteCommentaireById(Integer id){
        commentaireRepository.deleteById(id);
    }
}
