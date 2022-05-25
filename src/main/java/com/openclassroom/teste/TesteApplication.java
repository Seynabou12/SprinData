package com.openclassroom.teste;

import com.openclassroom.teste.model.Categorie;
import com.openclassroom.teste.model.Commentaire;
import com.openclassroom.teste.model.Product;
import com.openclassroom.teste.repository.CommentaireRepository;
import com.openclassroom.teste.service.CategorieService;
import com.openclassroom.teste.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.openclassroom.teste.service.ProductService;

import javax.transaction.Transactional;


@SpringBootApplication
public class TesteApplication implements CommandLineRunner {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentaireService commentaireService;

    public static void main(String[] args) {
        SpringApplication.run(TesteApplication.class, args);
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Pour afficher la liste des nom  de produit à partir de la base de odnnée
//        Iterable<Product> products = productService.getProducts();
//        products.forEach(product -> System.out.println(product.getName()));

        // Recupération par le nom par id

//        Optional<Product> optProduct = productService.getProductById(1);
//        Product productId1 = optProduct.get();
//        System.out.println(productId1.getName());
//
//        productId1.getCommentaires().forEach(
//        commentaire -> System.out.println(commentaire.getContent()));

//        Optional<Categorie> optCategorie = categorieService.getCategorieById(1);
//        Categorie categorieId1  = optCategorie.get();
//        System.out.println(categorieId1.getNom());
//
//        categorieId1.getProducts().forEach(
//                product -> System.out.println(product.getName()));

        // Affiche la liste des catégories présent dans la base de donnée

        categorieService.getCategories().forEach(
                categorie -> System.out.println(categorie.getNom()));

        // Instenciation de l'objet Category
        Categorie newCategorie = new Categorie();
        newCategorie.setNom("promotion");
        // Appelle de la méthode addCategorie
        newCategorie = categorieService.addCategorie(newCategorie);
        // Affichgae de nouveau catégorie
        categorieService.getCategories().forEach(
                categorie -> System.out.println(categorie.getNom())
        );

        productService.getProducts().forEach(
                product -> System.out.println(product.getName())
        );
        Product newProduit = new Product();
        newProduit.setName("Créme");
        newProduit.setDescription("Description produit");
        newProduit.setCost(2000);

       //Applelle à la methode ADD
        newProduit = productService.addProduct(newProduit);
        productService.getProducts().forEach(
                product -> System.out.println(product.getName())
        );

        commentaireService.getCommentaires().forEach(
                commentaire -> System.out.println(commentaire.getContent())
        );
        Commentaire newCommentaire = new Commentaire();
        newCommentaire.setContent("contenu de mon produit");
        newCommentaire = commentaireService.addCommentaire(newCommentaire);
        commentaireService.getCommentaires().forEach(
                commentaire -> System.out.println(commentaire.getContent())
        );
    }

}