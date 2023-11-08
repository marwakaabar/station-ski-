package com.ski.skistation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ski.skistation.entities.Cours;
import java.util.List;
@Repository

public interface CoursRepository extends CrudRepository<Cours,Long> {


/*
	@Query(value = "SELECT c"+
	"FROM Cours c"+
	"JOIN moniteur_cours mc ON c.num_cours = mc.cours_num_cours"+
	"JOIN moniteur m ON m.moniteur = mc.moniteur_num_moniteur" +
	"WHERE m.nom = :nameMon", nativeQuery = true
	)
	List<Cours>GetCoursByMoniteurSql(@Param("nameMon")String nameMon);
	
	@Query(value = "SELECT c"+
			"FROM Cours c "+
			"JOIN moniteur m ON c member m.cours" +
			"WHERE m.nomM = :nameMon"
			)
	List<Cours>GetCoursByMoniteurJPql(@Param("nameMon")String nameMon);

*/

}
