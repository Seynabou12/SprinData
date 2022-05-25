package com.openclassroom.teste.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private int productId;
    @Column(name = "nom")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cout")
    private int cost;

    @OneToMany(

            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )

    @JoinColumn(name = "produit_id")
    // Ajout de nouveau attribut
    private List<Commentaire> commentaires =  new ArrayList<>();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    // Relation Bidirectionnelle
    @ManyToMany(
            mappedBy = "products",
            cascade = CascadeType.ALL
    )
    List<Categorie> categories = new ArrayList<>();

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public void addCommentaire(Commentaire commentaire) {
        commentaires.add(commentaire);
        commentaire.setProduct(this);
    }

    public void removeCommentaire(Commentaire commentaire) {
        commentaires.remove(commentaire);
        commentaire.setProduct(null);
    }

}
