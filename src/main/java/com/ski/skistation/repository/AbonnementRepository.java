package com.ski.skistation.repository;

import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.Skieur;
import com.ski.skistation.entities.enums.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {


    @Query("SELECT abo FROM Abonnement abo WHERE abo.TypeAbonnement = :typeAbonnement ORDER BY abo.dateDebut ASC"  )
    List<Abonnement> getSubscriptionByType(@Param("typeAbonnement") TypeAbonnement typeAbonnement);




}
