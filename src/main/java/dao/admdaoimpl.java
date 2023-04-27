package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.administrateu;
import com.octest.beans.candidat;

public class admdaoimpl implements admdao {

	 private daofactory factory;
	    

	    admdaoimpl(daofactory factory) {
	        this.factory = factory;
	    }
	public  administrateu lister(int id) {
		
		 List<administrateu> a= new ArrayList<administrateu>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
            administrateu ad =new administrateu();
	        try {
	        	connexion = factory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM administrateur;");

	            while (resultat.next()) {
	            	
	                int ida = resultat.getInt("ida");
	                
	                String nom = resultat.getString("nom");
	                String prenom = resultat.getString("prenom");
	                String mail = resultat.getString("mail"); 
	                String tel = resultat.getString("tel");
	                String passwd = resultat.getString("passwd");
	                	                
	                
	                ad.setId(ida);
	                ad.setNom(nom);
	                ad.setPrenom(prenom);
	                ad.setMail(mail);
	                ad.setTel(tel);
	                
	                ad.setPasswd(passwd);
	        
	                

	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ad;
		
	}
	@Override
	public boolean Check_login_ass(String email, String password) {
		boolean flag=false;
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	statement = connexion.prepareStatement("SELECT ida, nom FROM administrateur WHERE mail=? AND passwd=?");
    		
        	statement.setString(1,email);
        	statement.setString(2, password);
        	resultat = statement.executeQuery();
		
        
	         if(resultat.next()) {
	    		flag=true; 
	         }
	         statement.close();
	         
	     }catch(SQLException e){
	         e.printStackTrace();
	     }
		return flag;
	}
	
	
	public administrateu getadministrateurByEmail(String email) {
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultat = null;
		  administrateu a= new administrateu();
		    
	  	try {
         connexion = factory.getConnection();
      	
      	
      	preparedStatement = connexion.prepareStatement("SELECT * FROM administrateur WHERE mail=? ");
  		
      	preparedStatement.setString(1,email);
      	
      	resultat = preparedStatement.executeQuery();
	  		if ( resultat.next() ) {
	  			
	  		  int id = resultat.getInt("ida");
              String nom = resultat.getString("nom");
              String prenom = resultat.getString("prenom");
              String tel = resultat.getString("tel");
              String paswd = resultat.getString("passwd");
              String mail = resultat.getString("mail"); 
              a.setId(id);
              a.setMail(email);
              a.setNom(nom);
              a.setPasswd(paswd);
              a.setPrenom(prenom);
              a.setTel(tel);
             
              
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  	return a;
	  	}

}
