package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class daofactory {
	    private String url;
	    private String username;
	    private String password;

	    daofactory(String url, String username, String password) {
	        this.url = url;
	        this.username = username;
	        this.password = password;
	    }

	    public static daofactory getInstance() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {

	        }

	        daofactory instance = new daofactory(
	                "jdbc:mysql://localhost:3306/pojetjee", "root", "Vgnd2810");
	        return instance;
	    }


	    // Récupération du Dao

		public Connection getConnection() throws SQLException {
			// TODO Auto-generated method stub
			return DriverManager.getConnection(url, username, password);
		}
		public candidatDao getcandidatDao() {
	        return new candidatDaoImpl(this);
	    }

		public Object getrecDao() {
			// TODO Auto-generated method stub
			return new recDaoImpl(this);
		}

		public offredao getoffredao() {
			// TODO Auto-generated method stub
			return new offredaoimpl(this);
		}


		public postulationDao getpostulationDao() {
			
			return new postulationdaoimpl(this);
		}

		public admdao  getadmdao() {
			// TODO Auto-generated method stub
			return new admdaoimpl(this);
		}



	
			
		}

