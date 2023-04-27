package dao;
import java.util.List;

import com.octest.beans.recruteur;
public  interface recDao {
	    void ajouter_rec(recruteur re );
	    List<recruteur> lister_rec();
		void delete_rec(int idr);
		public void modifier_rec(recruteur rec);
		public recruteur un(int idr) ;
		public boolean Check_login_ass(String email, String password);
		public recruteur getrecruteurByEmail(String email);

}
