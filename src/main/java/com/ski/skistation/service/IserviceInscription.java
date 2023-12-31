package com.ski.skistation.service;

import com.ski.skistation.entities.Inscription;
import com.ski.skistation.entities.enums.TypeAbonnement;

import java.util.List;
import java.util.Optional;

public interface IserviceInscription {

    List<Inscription> retrieveAllInscriptions();

    Inscription addInscriptions(Inscription inscription);

    Inscription updateInscriptions(Inscription inscription);

    Optional<Inscription> retrieveInscriptions(Long numInscription);

    void removeInscriptions(Long numInscription);

    Inscription addRegistrationAndAssignToSkieur(Inscription inscription,Long numSkieur);

    Inscription assignRegistrationToCourse(Long numInscription , Long numCours);

}
