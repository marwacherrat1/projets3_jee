package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.candidat;
import com.octest.beans.recruteur;

public class candidatDaoImpl implements candidatDao {
    private daofactory factory;
    

    candidatDaoImpl(daofactory factory) {
        this.factory = factory;
    }

    public void ajouter(candidat c) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO candidat(nom,prenom,mail,tel,competences,projets,diplomes,langues,age,paswd) VALUES(?,?,?,?,?,?,?,?,?,?);");
            
            preparedStatement.setString(1, c.getNom());
            preparedStatement.setString(2, c.getPrenom());
            preparedStatement.setString(3, c.getMail());
            preparedStatement.setString(4, c.getTel());
            preparedStatement.setString(5, c.getCompetences());
            preparedStatement.setString(6, c.getProjets());
            preparedStatement.setString(7, c.getDiplomes());
            preparedStatement.setString(8, c.getLangues());
            preparedStatement.setInt(9,c.getAge());
            preparedStatement.setString(10, c.getPaswd());
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<candidat> lister() {
        List<candidat> candidats= new ArrayList<candidat>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM candidat;");

            while (resultat.next()) {
            	
                int idc = resultat.getInt("idc");
                
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String mail = resultat.getString("mail"); 
                String competences = resultat.getString("competences");
                String projets = resultat.getString("projets");
                String langues = resultat.getString("langues");
                int age = resultat.getInt("age");
                String tel = resultat.getString("tel");
                String diplomes = resultat.getString("diplomes");
                String paswd=resultat.getString("paswd");
                
                candidat c = new candidat();
                c.setIdc(idc);
                c.setNom(nom);
                c.setPrenom(prenom);
                c.setMail(mail);
                c.setAge(age);
                c.setCompetences(competences);
                c.setDiplomes(diplomes);      
                c.setTel(tel);
                c.setProjets(projets);
                c.setLangues(langues);
                c.setPaswd(paswd);
        
                

                candidats.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidats;
    }

	public void deleteC(int idc) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = factory.getConnection();
			statement = connexion.prepareStatement("delete from candidat where idc = ?");
			statement.setInt(1,idc);
			statement.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public candidat un(int idc) {
		candidat c= new candidat();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	statement = connexion.prepareStatement("SELECT * FROM candidat where idc=?;");
        	statement.setInt(1,idc);
        	resultat = statement.executeQuery();
            
            while (resultat.next()) {
            	
               
                
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String mail = resultat.getString("mail"); 
                String competences = resultat.getString("competences");
                String projets = resultat.getString("projets");
                String langues = resultat.getString("langues");
                int age = resultat.getInt("age");
                String tel = resultat.getString("tel");
                String diplomes = resultat.getString("diplomes");
                String paswd=resultat.getString("paswd");
                
                
                c.setIdc(idc);
                c.setNom(nom);
                c.setPrenom(prenom);
                c.setMail(mail);
                c.setAge(age);
                c.setCompetences(competences);
                c.setDiplomes(diplomes);      
                c.setTel(tel);
                c.setProjets(projets);
                c.setLangues(langues);
                c.setPaswd(paswd);
        
                

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return c ;
	}

	public void modifier_candidat(candidat c) {
		// TODO Auto-generated method stub
				Connection connexion = null;
				PreparedStatement preparedStatement = null;
				try {
					connexion = factory.getConnection();
					preparedStatement = connexion.prepareStatement("UPDATE candidat SET  nom=?,prenom=?,mail=?,tel=?,competences=?,projets=?,diplomes=?,langues=?,age=?,paswd=? WHERE idc=?");

		            preparedStatement.setString(1, c.getNom());
		            preparedStatement.setString(2, c.getPrenom());
		            preparedStatement.setString(3, c.getMail());
		            preparedStatement.setString(4, c.getTel());
		            preparedStatement.setString(5, c.getCompetences());
		            preparedStatement.setString(6, c.getProjets());
		            preparedStatement.setString(7, c.getDiplomes());
		            preparedStatement.setString(8, c.getLangues());
		            preparedStatement.setInt(9,c.getAge());
		            preparedStatement.setString(10, c.getPaswd());
		            preparedStatement.setInt(11, c.getIdc());
		            preparedStatement.executeUpdate();
		       
					
				}
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	}

	public candidat getcandidatByEmail(String email) {

		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultat = null;
		  candidat c= new candidat();
		    
	  	try {
         connexion = factory.getConnection();
      	
      	
      	preparedStatement = connexion.prepareStatement("SELECT * FROM candidat WHERE mail=? ");
  		
      	preparedStatement.setString(1,email);
      	
      	resultat = preparedStatement.executeQuery();
	  		if ( resultat.next() ) {
	  			
	  		  int id = resultat.getInt("idc");
              String nom = resultat.getString("nom");
              String prenom = resultat.getString("prenom");
              String tel = resultat.getString("tel");
              String competences = resultat.getString("competences");
              String projets = resultat.getString("projets");
              String diplomes = resultat.getString("diplomes");
              String langues = resultat.getString("langues");
              String paswd = resultat.getString("paswd");
              int age = resultat.getInt("age");
              String mail = resultat.getString("mail"); 
              c.setIdc(id);
              c.setNom(nom);
              c.setMail(mail);
              c.setAge(age);
              c.setCompetences(competences);
              c.setDiplomes(diplomes);
              c.setLangues(langues);
              c.setPaswd(paswd);
              c.setPrenom(prenom);
              c.setProjets(projets);
              c.setTel(tel);
              
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  	return c;
	  }
	public boolean Check_login_ass(String email, String password) {
		boolean flag=false;
		
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	
        	statement = connexion.prepareStatement("SELECT idc, nom FROM candidat WHERE mail=? AND paswd=?");
    		
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


	
		
	}

	

