package com.openclassroom.teste.model;

import javax.persistence.*;

@Entity
@Table(name= "commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentaire_id;
    @Column(name = "contenu")
    private String content;
//    @Column(name = "produit_id")
//    private int product_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produit_id")

    private Product product;

    public int getCommentaire_id() {
        return commentaire_id;
    }

    public void setCommentaire_id(int commentaire_id) {
        this.commentaire_id = commentaire_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public int getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(int product_id) {
//        this.product_id = product_id;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
