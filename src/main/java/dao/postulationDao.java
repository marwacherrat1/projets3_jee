package dao;
import java.util.List;
import com.octest.beans.postulation;

public interface postulationDao {
	void ajouter(postulation p);
    List<postulation> listerpostulation();
	void delete(int idpostulation);
	postulation un(int idpostulation) ;
	void modifier(postulation p);
	public List<postulation> listerpostulation_entreprise(int identreprise) ;
	public List<postulation> listerpostulation_candidat(int idc);
}
