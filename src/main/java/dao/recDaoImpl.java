package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.candidat;
import com.octest.beans.recruteur;

public class recDaoImpl implements recDao {
    private daofactory factory;

    recDaoImpl(daofactory factory) {
        this.factory = factory;
    }

    public void ajouter_rec(recruteur rec) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO recruteur(nom,mail,adresse,passwd,description) VALUES(?,?,?,?,?);");
            
            preparedStatement.setString(1,rec.getNom());
            preparedStatement.setString(2,rec.getMail());

            preparedStatement.setString(3,rec.getAdresse());
            preparedStatement.setString(4,rec.getPasswd());
            preparedStatement.setString(5,rec.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<recruteur> lister_rec() {
        List<recruteur> recruteurs= new ArrayList<recruteur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM recruteur;");

            while (resultat.next()) {
            	
                int idr = resultat.getInt("idr");
                
                String nom = resultat.getString("nom");
               
                String mail = resultat.getString("mail"); 
               
                String adresse = resultat.getString("adresse");
                String passwd = resultat.getString("passwd");
                String description = resultat.getString("description");
                
                recruteur rec = new recruteur();
                rec.setIdr(idr);
                rec.setNom(nom);
                rec.setMail(mail);
                rec.setAdresse(adresse);
                rec.setPasswd(passwd);
                rec.setDescription(description);
                

                recruteurs.add(rec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recruteurs;
    }
// declaration methode supprimer recruteur    

	public void delete_rec(int idr) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = factory.getConnection();
			statement = connexion.prepareStatement("delete from recruteur where idr = ?");
			statement.setInt(1,idr);
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

// declaration methode modifier
	

	public void modifier_rec(recruteur rec) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = factory.getConnection();
			statement = connexion.prepareStatement("UPDATE recruteur SET  nom=?,mail=?,adresse=?,passwd=?,description=? WHERE idr=?");
 			statement.setString(1,rec.getNom());
 			statement.setString(2,rec.getMail());
 			statement.setString(3,rec.getAdresse());
 			statement.setString(4,rec.getPasswd());
 			statement.setString(5,rec.getDescription());
 			statement.setInt(6,rec.getIdr());
 			statement.executeUpdate();	
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public recruteur un(int idr) {
		recruteur rec= new recruteur();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	
        	statement = connexion.prepareStatement("SELECT * FROM recruteur where idr=?;");
        	statement.setInt(1,idr);
        	resultat = statement.executeQuery();
            
            while (resultat.next()) {
            	
               
                int id = resultat.getInt("idr");
                
                String nom = resultat.getString("nom");
               
                String mail = resultat.getString("mail"); 
               
                String adresse = resultat.getString("adresse");
                String passwd = resultat.getString("passwd");
                String description = resultat.getString("description");
                rec.setIdr(id);
                rec.setNom(nom);
                rec.setMail(mail);
                rec.setAdresse(adresse);
                rec.setPasswd(passwd);
                rec.setDescription(description);
                
                
                
                
        
                

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return rec ;
	}

	@Override
	public boolean Check_login_ass(String email, String password) {
		boolean flag=false;
		
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	
        	statement = connexion.prepareStatement("SELECT idr, nom FROM recruteur WHERE mail=? AND passwd=?");
    		
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


	@Override
	public recruteur getrecruteurByEmail(String email) {
	
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultat = null;
		  recruteur rec = new recruteur();
		    
	  	try {
           connexion = factory.getConnection();
        	
        	
        	preparedStatement = connexion.prepareStatement("SELECT * FROM recruteur WHERE mail=? ");
    		
        	preparedStatement.setString(1,email);
        	
        	resultat = preparedStatement.executeQuery();
	  		if ( resultat.next() ) {
	  			
	  			int id = resultat.getInt("idr");
                
                String nom = resultat.getString("nom");
               
                String mail = resultat.getString("mail"); 
               
                String adresse = resultat.getString("adresse");
                String passwd = resultat.getString("passwd");
                String description = resultat.getString("description");
                rec.setIdr(id);
                rec.setNom(nom);
                rec.setMail(mail);
                rec.setAdresse(adresse);
                rec.setPasswd(passwd);
                rec.setDescription(description);
                
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  	return rec;
	  }

	
	}

	

