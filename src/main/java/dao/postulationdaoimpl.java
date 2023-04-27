package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.postulation;

public class postulationdaoimpl implements postulationDao{
	private daofactory factory;
    

    postulationdaoimpl (daofactory factory) {
        this.factory = factory;
    }
	public void ajouter(postulation p) {

		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO postulation (id_postulant,id_offre,lettremotivation) VALUES(?,?,?);");
            
            
            
            preparedStatement.setInt(1,p.getId_postulant());
            preparedStatement.setInt(2,p.getId_offre());
            preparedStatement.setString(3,p.getLettremotivation());
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}


	
	


	public void delete(int id_postulation) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = factory.getConnection();
			statement = connexion.prepareStatement("delete from postulation where id_postulation = ?");
			statement.setInt(1,id_postulation);
			statement.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		
	}


	public postulation un(int idpostulation) {
		postulation p= new postulation();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	statement = connexion.prepareStatement("SELECT * FROM postulation where id_postulation=?;");
        	statement.setInt(1,idpostulation);
        	resultat = statement.executeQuery();
            
            while (resultat.next()) {
            	
               
                
                int idoffre = resultat.getInt("id_offre");
                int idpostulant = resultat.getInt("id_postulant");
                String lettremotivation = resultat.getString("lettremotivation"); 
                
                
                p.setId_offre(idoffre);;
                p.setId_postulant(idpostulant);
                p.setLettremotivation(lettremotivation);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return p ;
	}


	@Override
	public void modifier(postulation p) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = factory.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE postulation id_postulant=?,id_offre=?,lettremotivation=? WHERE id_postulation=?");
			
			 preparedStatement.setInt(1,p.getId_postulant());
	        preparedStatement.setInt(2,p.getId_offre());
	        preparedStatement.setString(3,p.getLettremotivation());
	        preparedStatement.setInt(4, p.getId_postulation());
            preparedStatement.executeUpdate();
       
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
	

	public List<postulation> listerpostulation() {
		
		    List<postulation> postulations= new ArrayList<postulation>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	        	connexion = factory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM postulation ;");
            
            while (resultat.next()) {
            	
               
                int idpostulation = resultat.getInt("id_postulation");
                int idoffre = resultat.getInt("id_offre");
                int idpostulant = resultat.getInt("id_postulant");
                String lettremotivation = resultat.getString("lettremotivation"); 
                
                postulation p = new postulation();
                p.setId_postulation(idpostulation);
                p.setId_offre(idoffre);;
                p.setId_postulant(idpostulant);
                p.setLettremotivation(lettremotivation);
                postulations.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	        return postulations ;
	}
	public List<postulation> listerpostulation_entreprise(int idr) {
		
		List<postulation> postulations= new ArrayList<postulation>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {connexion = factory.getConnection();
        	
        	statement = connexion.prepareStatement("SELECT * FROM postulation p ,offre o,recruteur r where p.id_offre=o.idoffre  and r.idr= o.id_entreprise and r.idr=? ;");
            statement.setInt(1,idr);
        	resultat = statement.executeQuery();
        while (resultat.next()) {
        	
           
            int idpostulation = resultat.getInt("id_postulation");
            int idoffre = resultat.getInt("id_offre");
            int idpostulant = resultat.getInt("id_postulant");
            String lettremotivation = resultat.getString("lettremotivation"); 
            
            postulation p = new postulation();
            p.setId_postulation(idpostulation);
            p.setId_offre(idoffre);;
            p.setId_postulant(idpostulant);
            p.setLettremotivation(lettremotivation);
            postulations.add(p);

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return postulations ;
}
		
	

public List<postulation> listerpostulation_candidat(int idc) {
	
	List<postulation> postulations= new ArrayList<postulation>();
    Connection connexion = null;
    PreparedStatement statement = null;
    ResultSet resultat = null;

    try {connexion = factory.getConnection();
    	
    	statement = connexion.prepareStatement("SELECT * FROM postulation p ,offre o,candidat c where p.id_offre=o.idoffre  and c.idc=p.id_postulant and c.idc=? ;");
        statement.setInt(1,idc);
    	resultat = statement.executeQuery();
    while (resultat.next()) {
    	
       
        int idpostulation = resultat.getInt("id_postulation");
        int idoffre = resultat.getInt("id_offre");
       
        String lettremotivation = resultat.getString("lettremotivation"); 
        
        postulation p = new postulation();
        p.setId_postulation(idpostulation);
        p.setId_offre(idoffre);;
        
        p.setLettremotivation(lettremotivation);
        postulations.add(p);

    }
} catch (SQLException e) {
    e.printStackTrace();
}
    return postulations ;
}
	
}

	
	
	
