package com.ski.skistation.service;

import com.ski.skistation.DTO.AbonnementDTO;
import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;

import java.util.List;
import java.util.Optional;

public interface IserviceAbonnement {
    List<Abonnement> retrieveAllAbonnements();

    Abonnement addAbonnements(Abonnement abonnement);

    Abonnement updateAbonnements(Abonnement abonnement);

    Optional<Abonnement> retrieveAbonnements(Long numAbon);

    void removeAbonnements(Long numAbon);

    List<Abonnement> getSubsciptionByType(TypeAbonnement typeAbonnement);
    
    AbonnementDTO convertEntityToDTO(Abonnement a);
    
    AbonnementDTO saveAbonnement(Abonnement a);
    
    AbonnementDTO getAbonnement(Long numAbon);
    
    List<AbonnementDTO> getAllAbonnement();
    
    Abonnement convertDtoToEntity(AbonnementDTO abonnementDTO);
    
    
}
