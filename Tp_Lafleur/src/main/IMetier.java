/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.Categorie;
import java.util.List;

/**
 *
 * @author devv
 */
public interface IMetier {
    
    public void ajoutCategerie(Categorie c);
	public void ajoutProduit(Produit pr, int id_produit);
	public List<Produit> consulter_nomCle(String noncle);
	
	public List<Produit> consulterparCode(int code);
	public List<Categorie> consultertoutCategorie(int code);
	
	public Categorie consulterCategorie(int code);
	
    
}
