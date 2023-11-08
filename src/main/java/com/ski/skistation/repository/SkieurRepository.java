package com.ski.skistation.repository;

import com.ski.skistation.entities.Skieur;
import com.ski.skistation.entities.enums.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur,Long> {

    @Query("SELECT s FROM Skieur s WHERE s.abonnement.TypeAbonnement = :typeAbonnement")

    List<Skieur> findByAbonnementTypeAbonnement(@Param("typeAbonnement")TypeAbonnement typeAbonnement);

    /*
    @Query(value ="SELECT *" +
			"FROM skieur s" +
		    "JOIN inscription i ON s.num_skieur= i.skieur_num_skieur"+
			"JOIN moniteur_cours mc ON i.cours_num_cours = mc.cours_num_cours"+
		    "JOIN moniteur m ON m.num_moniteur = mc.moniteur_num_moniteur"+
			"WHERE m.nomm = :MoniteurName" +
		    "ORDER BY (select count(*) from piste where piste.skieur_num_skieur = s.num_skieur) DESC",nativeQuery =true)
	List<Skieur> GetSkieurByMoniteurNameSql(@Param("MoniteurName")String Moniteur);
	
	@Query("select i.skieur"+
	"from Inscription i"+
	"join Moniteur on i.cour member m.cours"+
	"where m.nomM = :MoniteurName"+
	"order by size(i.skieur.pistes) DESC"//ordonné par le nombre de piste affecté au skieur bel sql wel jpql
	)
	List<Skieur> GetSkieurByMoniteurNameJPql(@Param("MoniteurName")String Moniteur);
*/
}
