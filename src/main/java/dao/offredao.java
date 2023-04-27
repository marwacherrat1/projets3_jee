package dao;

import java.util.List;

import com.octest.beans.offre;
import com.octest.beans.recruteur;

public interface offredao {
	void ajouter(offre o);
    List<offre> lister();
	void deletoffre(int idoffre);
	offre un(int idoffre) ;
	void modifier_offre(offre o);
	List<offre>lister_offres(int idr);
	List<offre>lister_offresnonpostulé(int idc);
	List<offre> recherche_titre(String nom,int i);

}
