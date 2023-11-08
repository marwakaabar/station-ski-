package com.ski.skistation.controller;

import com.ski.skistation.DTO.AbonnementDTO;
import com.ski.skistation.entities.Abonnement;
import com.ski.skistation.entities.enums.TypeAbonnement;
import com.ski.skistation.service.IserviceAbonnement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abonnement")
@RequiredArgsConstructor
public class abonnementController {

  private  final  IserviceAbonnement iserviceAbonnement;

   /* @GetMapping
    public List<Abonnement> getAll(){
        return iserviceAbonnement.retrieveAllAbonnements();
    }*/
    @GetMapping
    public List<AbonnementDTO> getAllAbonnements(){
        return iserviceAbonnement.getAllAbonnement();
    }
    /*
    @PostMapping("/addAbon")
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return iserviceAbonnement.addAbonnements(abonnement);
    }*/
    @PostMapping("/addAbon")
    public AbonnementDTO addAbonnementDTO(@RequestBody Abonnement abonnement){
        return iserviceAbonnement.saveAbonnement(abonnement);
    }
    /*
    @GetMapping("/{numAbonnement}")
    public Optional<Abonnement> getByIdAbonnement(@PathVariable("numAbonnement") Long numAbon){
        return (Optional<Abonnement>) iserviceAbonnement.retrieveAbonnements(numAbon);
    }*/
    
    @GetMapping("/{numAbonnement}")
    public AbonnementDTO getByIdAbon(@PathVariable("numAbonnement") Long numAbon){
        return iserviceAbonnement.getAbonnement(numAbon);
    }

    @PutMapping("/updateAbonnement")
    public Abonnement updateAbonnement (@RequestBody  Abonnement abonnement){
        return iserviceAbonnement.updateAbonnements(abonnement);
    }

    @DeleteMapping("/deleteAbonnement/{numAbon}")
    public void deleteAbonnement(@PathVariable("numAbon") Long numAbon){
        iserviceAbonnement.removeAbonnements(numAbon);

    }

    @GetMapping("/subscriptions")
    public List<Abonnement> getSubscriptionsByType(@RequestParam TypeAbonnement typeAbonnement) {
        return iserviceAbonnement.getSubsciptionByType(typeAbonnement);
    }

  
    

}
