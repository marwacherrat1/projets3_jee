package dao;

import java.util.List;

import com.octest.beans.administrateu;

public interface admdao {
         administrateu lister(int id);

		boolean Check_login_ass(String email, String password);

		administrateu getadministrateurByEmail(String email);
}
