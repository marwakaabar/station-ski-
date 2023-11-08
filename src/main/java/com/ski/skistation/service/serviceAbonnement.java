package com.ski.skistation.service;

import com.ski.skistation.DTO.AbonnementDTO;
import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;
import com.ski.skistation.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class serviceAbonnement implements IserviceAbonnement{

    @Autowired
    public AbonnementRepository repoAbon;
    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return (List<Abonnement>)repoAbon.findAll();

    }

    @Override
    public Abonnement addAbonnements(Abonnement abonnement) {
        return repoAbon.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnements(Abonnement abonnement) {
        return repoAbon.save(abonnement);
    }

    @Override
    public Optional<Abonnement> retrieveAbonnements(Long numAbon) {
        Optional<Abonnement> abonnement = repoAbon.findById(numAbon);
        if(abonnement.isPresent()){
            return abonnement;
        }else {
            throw new IllegalArgumentException("Abonnement with ID " + numAbon + " not found");
        }
    }



    @Override
    public void removeAbonnements(Long numAbon) {
        if (repoAbon.existsById(numAbon)) {
            repoAbon.deleteById(numAbon);
        } else {
            throw new IllegalArgumentException("Abonnement with ID " + numAbon + " not found");

        }

    }

    @Override
    public List<Abonnement> getSubsciptionByType(TypeAbonnement typeAbonnement) {
        return repoAbon.getSubscriptionByType(typeAbonnement);
    }

	@Override
	public AbonnementDTO convertEntityToDTO(Abonnement a) {
		 /*AbonnementDTO abonnementDTO = new AbonnementDTO();
		abonnementDTO.setNumAbon(a.getNumAbon());
		abonnementDTO.setDateDebut(a.getDateDebut());
		abonnementDTO.setDataFin(a.getDataFin());
		abonnementDTO.setPrixAbon(a.getPrixAbon());
		abonnementDTO.setTypeAbonnement(a.getTypeAbonnement());
		return abonnementDTO;*/
		
		//en utilisant le design pattern builder deuxieme façon
		return AbonnementDTO.builder()
				.numAbon(a.getNumAbon())
				.dateDebut(a.getDateDebut())
				.dataFin(a.getDataFin())
				.prixAbon(a.getPrixAbon())
				.TypeAbonnement(a.getTypeAbonnement())
				.build();
		
	}

	@Override
	public AbonnementDTO saveAbonnement(Abonnement a) {
		return convertEntityToDTO(repoAbon.save(a));
	}

	@Override
	public AbonnementDTO getAbonnement(Long numAbon) {
		return convertEntityToDTO(repoAbon.findById(numAbon).get());
	}

	@Override
	public List<AbonnementDTO> getAllAbonnement() {
		return repoAbon.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
		/*ou bien selon la classique façon
        List <Abonnement> abons = repoAbon.findAll();
	    List<AbonnementDTO>listabonDto = new ArrayList<>(abons.size());
        for(Abonnement a : abons)
        	listabonDto.add(convertEntityToDTO(a));
		return listabonDto;*/
		
	}

	@Override
	public Abonnement convertDtoToEntity(AbonnementDTO abonnementDTO) {
		Abonnement abonnement = new Abonnement();
		abonnement.setNumAbon(abonnementDTO.getNumAbon());
		abonnement.setDateDebut(abonnementDTO.getDateDebut());
		abonnement.setDataFin(abonnementDTO.getDataFin());
		abonnement.setPrixAbon(abonnementDTO.getPrixAbon());
		abonnement.setTypeAbonnement(abonnementDTO.getTypeAbonnement());
		
		return abonnement;
	}
}
