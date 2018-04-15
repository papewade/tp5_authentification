/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.IMetier;
import main.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author devv
 */
public class ImplementeIMetier implements IMetier {
        
	public void ajoutCategerie(Categorie cat) {
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement  stat = cnx.prepareStatement("INSERT INTO `categorie`(`nom_categorie`) "
					+ "VALUES (?)");
			stat.setString(1, cat.getNom_categorie());	
			stat.executeUpdate();
			stat.close();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void ajoutProduit(Produit pr, int id_produit) {
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement  stat = cnx.prepareStatement("INSERT INTO `produit`"
					+ "(`nom_produit`, `prix_produit`, `quantite_produit`, `categorie_fk`)"
					+ " VALUES (?,?,?,?)");
			
			stat.setString(1, pr.getNom_produit());
			stat.setInt(2, pr.getPrix_produit());
			stat.setInt(3, pr.getQuantite_produit());
			//stat.setInt(4, pr.getCategorie_fk());
			
			stat.executeUpdate();
			stat.close();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

	public List<Produit> consulter_nomCle(String mc) {
		
		List<Produit> resTable = new ArrayList<Produit>();
		
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement  stat = cnx.prepareStatement("SELECT * FROM `produit`"
					+ " WHERE `nom_produit`LIKE ?");
			stat.setString(1, "%"+mc+"%");
			
			ResultSet res = stat.executeQuery();
			
			//nom_produit	prix_produit	quantite_produit	categorie_fk
			
			
			while(res.next())
			{
				Produit p= new Produit();
				p.setId_produit(res.getInt(1));
				p.setNom_produit(res.getString(2));
				p.setPrix_produit(res.getInt(3));
				p.setQuantite_produit(res.getInt(4));
				
				resTable.add(p);
				
			}
			
			stat.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return resTable;
	}

	public List<Categorie> consultertoutCategorie(int code) {

		List<Categorie> resTable = new ArrayList<Categorie>();
		
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement  stat = cnx.prepareStatement("SELECT * FROM `categorie`");
			
			ResultSet res = stat.executeQuery();
			
			
			while(res.next())
			{
				Categorie p= new Categorie(0,"");
				p.setCode(res.getInt(1));
				p.setNom_categorie(res.getString(2));
				
				resTable.add(p);
				
			}
			
			stat.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return resTable;
	}

	public List<Produit> consulterparCode(int code) {
		
		
		List<Produit> resTable = new ArrayList<Produit>();
		
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement  stat = cnx.prepareStatement("SELECT * FROM `produit`"
					+ " WHERE `categorie_fk` = ?");
			// dire de quoi ressemble le categorie_fk
			stat.setInt(1,code);
			
			ResultSet res = stat.executeQuery();
			
			
			while(res.next())
			{
				Produit p= new Produit();
				p.setId_produit(res.getInt("id_produit"));
				p.setNom_produit(res.getString("nom_produit"));
				p.setPrix_produit(res.getInt("prix_produit"));
				p.setQuantite_produit(res.getInt("quantite_produit"));
				//p.setCategorie_fk(res.getInt(5));
				
	              // le deuxieme statement du a la declaation de categorie dans produit 
				// la preparation de la connexion
				
				PreparedStatement  stat1 = cnx.prepareStatement("SELECT * FROM `categorie`"
						+ " WHERE `code` = ?");
				//a quoi ressemble le code
				
				stat1.setInt(1, code);
				
				//l'execution de la requette
				
				ResultSet res1= stat1.executeQuery();
				if(res1.next()) {
					Categorie cat = new Categorie();
					cat.setCode(res1.getInt("code "));
					cat.setNom_categorie(res1.getString("nom_categorie"));
					
					//lajout du resultat dans produit
					p.setCategorie(cat);
					
					// la fermiture du deuxieme statement
					stat.close();
				}
				
				
				resTable.add(p);
				
			}
			
			stat.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resTable;
	}

	public Categorie consulterCategorie(int code) {
		

		Categorie c = null;
		
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement  stat = cnx.prepareStatement("SELECT * FROM `categorie`"
					+ " WHERE `code` = ?");
			// dire de quoi ressemble le categorie_fk
			stat.setInt(1,code);
			
			ResultSet res = stat.executeQuery();
			
			while(res.next()){
				
				 c= new Categorie();
				c.setCode(res.getInt(1));
				c.setNom_categorie(res.getString(2));	
			}
			
			stat.close();
			
		} catch (SQLException e){
			
				e.printStackTrace();
			}
	
		
		return c;
			
	
	}
    
}
