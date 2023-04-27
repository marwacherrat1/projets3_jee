package dao;

import java.util.List;

import com.octest.beans.candidat;

public interface candidatDao {
    void ajouter(candidat c);
    List<candidat> lister();
	void deleteC(int idc);
	candidat un(int idc);
	void modifier_candidat(candidat c);
	candidat getcandidatByEmail(String email);
	public boolean Check_login_ass(String email, String password) ;

	
}
