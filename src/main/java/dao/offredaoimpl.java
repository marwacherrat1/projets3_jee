package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.octest.beans.offre;
import com.octest.beans.recruteur;
public class offredaoimpl implements offredao{
    private daofactory factory;
    

    offredaoimpl (daofactory factory) {
        this.factory = factory;
    }


	
	public void ajouter(offre o) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = factory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO offre(id_entreprise,dateoffre,delai,description,competence,titre) VALUES(?,?,?,?,?,?);");
            
            
            preparedStatement.setInt(1, o.getId_entreprise());
        	preparedStatement.setDate(2, java.sql.Date.valueOf(o.getDateoffre()));
			preparedStatement.setDate(3, java.sql.Date.valueOf(o.getDelai()));
            preparedStatement.setString(4, o.getDescription());
            preparedStatement.setString(5, o.getCompetence());
            preparedStatement.setString(6, o.getTitre());
           
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}


	
	public List<offre> lister() {
		List<offre> offres= new ArrayList<offre>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM offre;");

            while (resultat.next()) {
            	
                int idoffre = resultat.getInt("idoffre");
                int id_entreprise = resultat.getInt("id_entreprise");
                String dateoffre = resultat.getString("dateoffre");
                String delai = resultat.getString("delai"); 
                String description = resultat.getString("description");
                String competence = resultat.getString("competence");
                String titre=resultat.getString("titre");
                
                offre o = new offre();
               o.setIdoffre(idoffre);
               o.setId_entreprise(id_entreprise);
               o.setDateoffre(dateoffre);
               o.setDelai(delai);
               o.setDescription(description);
               o.setCompetence(competence);
               o.setTitre(titre);

                offres.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offres;
	}


	
	public void deletoffre(int idoffre) {
		Connection connexion = null;
		PreparedStatement statement = null;
		try {
			connexion = factory.getConnection();
			statement = connexion.prepareStatement("delete from offre where idoffre = ?");
			statement.setInt(1,idoffre);
			statement.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


	
	public offre un(int idoffre) {
		offre o= new offre();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	statement = connexion.prepareStatement("SELECT * FROM offre where idoffre=?;");
        	statement.setInt(1,idoffre);
        	resultat = statement.executeQuery();
            
            while (resultat.next()) {
            	
               
                
            	 int idoffre1 = resultat.getInt("idoffre");
                 int id_entreprise = resultat.getInt("id_entreprise");
                 String dateoffre = resultat.getString("dateoffre");
                 String delai = resultat.getString("delai"); 
                 String description = resultat.getString("description");
                 String competence = resultat.getString("competence");
                 String titre= resultat.getString("titre");
                 
                
                o.setIdoffre(idoffre1);
                o.setId_entreprise(id_entreprise);
                o.setDateoffre(dateoffre);
                o.setDelai(delai);
                o.setDescription(description);
                o.setCompetence(competence);
                o.setTitre(titre);
        
                

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return o ;
		
	}


	public void modifier_offre(offre o) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = factory.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE offre SET id_entreprise=?,dateoffre=?,delai=?,description=? ,competence=?,titre=? WHERE idoffre=?");			
			preparedStatement.setInt(1, o.getId_entreprise());
			preparedStatement.setDate(2, java.sql.Date.valueOf(o.getDateoffre()));
			preparedStatement.setDate(3, java.sql.Date.valueOf(o.getDelai()));
            preparedStatement.setString(4, o.getDescription());
            preparedStatement.setString(5, o.getCompetence());
            preparedStatement.setString(6, o.getTitre());
            preparedStatement.setInt(7, o.getIdoffre());

            preparedStatement.executeUpdate();
       
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}



	
	public List<offre> lister_offres(int idr) {
		List<offre> offres= new ArrayList<offre>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
           
            preparedStatement = connexion.prepareStatement("SELECT * FROM offre where id_entreprise=? ;");
            preparedStatement.setInt(1,idr);
        	resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
            	
                int idoffre = resultat.getInt("idoffre");
                int id_entreprise = resultat.getInt("id_entreprise");
                String dateoffre = resultat.getString("dateoffre");
                String delai = resultat.getString("delai"); 
                String description = resultat.getString("description");
                String competence = resultat.getString("competence");
                String titre=resultat.getString("titre");
                
                offre o = new offre();
               o.setIdoffre(idoffre);
               o.setId_entreprise(id_entreprise);
               o.setDateoffre(dateoffre);
               o.setDelai(delai);
               o.setDescription(description);
               o.setCompetence(competence);
               o.setTitre(titre);

                offres.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offres;
		
	}



	
	public List<offre> lister_offresnonpostulé(int idc) {
		List<offre> offres= new ArrayList<offre>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
           
            preparedStatement = connexion.prepareStatement("SELECT * FROM offre where idoffre NOT IN (SELECT id_offre FROM postulation  where id_postulant=?);");
            preparedStatement.setInt(1,idc);
        	resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
            	
                int idoffre = resultat.getInt("idoffre");
                int id_entreprise = resultat.getInt("id_entreprise");
                String dateoffre = resultat.getString("dateoffre");
                String delai = resultat.getString("delai"); 
                String description = resultat.getString("description");
                String competence = resultat.getString("competence");
                String titre=resultat.getString("titre");
                
                offre o = new offre();
               o.setIdoffre(idoffre);
               o.setId_entreprise(id_entreprise);
               o.setDateoffre(dateoffre);
               o.setDelai(delai);
               o.setDescription(description);
               o.setCompetence(competence);
               o.setTitre(titre);

                offres.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offres;
		
	}




	public List<offre> recherche_titre(String nom,int i) {
		
		List<offre> offres= new ArrayList<offre>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
        	connexion = factory.getConnection();
        	
        	statement = connexion.prepareStatement("SELECT * FROM offre where id_entreprise In (SELECT idr from recruteur where nom=?) and idoffre NOT IN (SELECT id_offre FROM postulation  where id_postulant=?);");
        	statement.setString(1,nom);
        	statement.setInt(2, i);
        	resultat = statement.executeQuery();
            
            while (resultat.next()) {
            	
               
            	 offre o= new offre();
            	 int idoffre1 = resultat.getInt("idoffre");
                 int id_entreprise = resultat.getInt("id_entreprise");
                 String dateoffre = resultat.getString("dateoffre");
                 String delai = resultat.getString("delai"); 
                 String description = resultat.getString("description");
                 String competence = resultat.getString("competence");
                 String titre= resultat.getString("titre");
                 
                
                o.setIdoffre(idoffre1);
                o.setId_entreprise(id_entreprise);
                o.setDateoffre(dateoffre);
                o.setDelai(delai);
                o.setDescription(description);
                o.setCompetence(competence);
                o.setTitre(titre);
                offres.add(o);
        
                

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return offres ;
		
	}




	
}

