/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.Categorie;

/**
 *
 * @author devv
 */
public class Produit {
        private int id_produit;
	private String nom_produit;
	private int prix_produit;
	private int quantite_produit;
	//private int categorie_fk;
	private Categorie categorie;
	
	/**
	 * 
	 * @param id_produit
	 * @param nom_produit
	 * @param prix_produit
	 * @param quantite_produit
	 * @param categorie
	 */
	public Produit(int id_produit, String nom_produit, int prix_produit, int quantite_produit, Categorie categorie) {
		super();
		this.id_produit = id_produit;
		this.nom_produit = nom_produit;
		this.prix_produit = prix_produit;
		this.quantite_produit = quantite_produit;
		this.categorie = categorie;
	}
	/**
	 * 
	 * @param nom_produit
	 * @param prix_produit
	 * @param quantite_produit
	 * @param categorie
	 */
	public Produit(String nom_produit, int prix_produit, int quantite_produit) {
		super();
		this.nom_produit = nom_produit;
		this.prix_produit = prix_produit;
		this.quantite_produit = quantite_produit;
		this.categorie = categorie;
	}
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public int getPrix_produit() {
		return prix_produit;
	}
	public void setPrix_produit(int prix_produit) {
		this.prix_produit = prix_produit;
	}
	public int getQuantite_produit() {
		return quantite_produit;
	}
	public void setQuantite_produit(int quantite_produit) {
		this.quantite_produit = quantite_produit;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}	
    
}
