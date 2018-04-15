/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import java.awt.Label;
import java.awt.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.SingletonConnection;
import main.SingletonConnection;


/**
 * FXML Controller class
 *
 * @author devv
 */
public class AuthentificationController implements Initializable {
    
    
    @FXML private PasswordField motdepasse;
    @FXML private TextField identifiant;
    @FXML private ImageView imageidentifiant;
    @FXML private ImageView immotpass;
    @FXML private Label entrerid;
    @FXML private ImageView vraie;
    @FXML private Label incorrecte1;
    @FXML private Label entrermotdepass;
    @FXML private Label incorrete2;
    @FXML private Label reussit;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {	
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			conn = SingletonConnection.getConnection();

		

			String iden = identifiant.getText();
			String queryVerif = "Select identifiant from authentification where identifiant = '"+ iden +"' ";
                        ps = conn.prepareStatement(queryVerif);
                        ResultSet rs = ps.executeQuery();
                        if(!rs.equals(iden)){
                            
                            incorrecte1.setVisible(true);
                        
                        }else{
                            
                            vraie.setVisible(true);
                            motdepasse.setVisible(true);
                            entrermotdepass.setVisible(true);
                            incorrecte1.setVisible(false);
                            entrerid.setVisible(false);
                            
                           String pass = motdepasse.getText();
			   String queryVerif1 = "Select motdepasse from authentification where identifiant = '"+ pass +"'" ;
                           ps2 = conn.prepareStatement(queryVerif);
                          ResultSet rs2 = ps2.executeQuery();
                            if(!rs2.equals(pass)){
                                incorrete2.setVisible(true);
                            }else{
                               incorrete2.setVisible(false);
                               entrermotdepass.setVisible(false);
                               reussit.setVisible(true);
                               
					
                            }                       
                        }
                           			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
        
        // TODO
        
    
}
