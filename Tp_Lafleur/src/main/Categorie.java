/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author devv
 */
public class Categorie {
    
        private int code;
	private String nom_categorie;
	private Produit produit;
	
	public Categorie() {
		
	}
	
	public Categorie(int code, String nom_categorie) {
		super();
		this.code = code;
		this.nom_categorie = nom_categorie;
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom_categorie() {
		return nom_categorie;
	}
	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	

    
}
