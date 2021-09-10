package com.ecommerce.microcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;

@RestController
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	 //Récupérer la liste des produits
    @RequestMapping(value="/Produits", method=RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }


    //Récupérer un produit par son Id
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }
    
    @PostMapping(value = "/Produits")
    public void ajouterProduit(@RequestBody Product product) {
    	productDao.save(product);
    }
    
    @DeleteMapping(value="/deleteProduits/{id}")
    public void supprimerProduit(@PathVariable int id) {
    	productDao.delete(id);
    }
    
}
