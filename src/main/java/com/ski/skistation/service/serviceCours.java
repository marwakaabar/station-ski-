package com.ski.skistation.service;

import com.ski.skistation.Exception.ResourceNotFoundException;
import com.ski.skistation.entities.Cours;
import com.ski.skistation.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class serviceCours implements IserviceCours {

   @Autowired
    CoursRepository coursRepo;


    @Override
    public List<Cours> retrieveAllCourses() {
        return (List<Cours>) coursRepo.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Optional<Cours> retrieveCours(Long numCours) {
        Optional<Cours> cours = coursRepo.findById(numCours);
        if(cours.isPresent()){

            return cours ;
        }else {
            throw new IllegalArgumentException("Cours with ID " + numCours + " not found");
        }
    }

    @Override
    public void removeCours(Long numCours) {
        if (coursRepo.existsById(numCours)) {
            coursRepo.deleteById(numCours);
        } else {
            throw new IllegalArgumentException("Cours with ID " + numCours + " not found");

        }
    }

    @Override
    public ResponseEntity<Cours> partialUpdateCours(Long numCours, Map<String, Object> updates) {
        Optional<Cours> course = Optional.ofNullable(coursRepo.findById(numCours).orElseThrow(() -> new ResourceNotFoundException("il n'existe pas le cours avec l'id  = " + numCours)));


        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Cours cours = course.get();

        updates.forEach((key, value) -> {
            if (value != null) {
                try {
                    Field field = Cours.class.getDeclaredField(key);
                    field.setAccessible(true);

                    if (field.getType().isEnum()) {
                        // Vérifier si le champ est de type enum
                        Enum<?> enumValue = Enum.valueOf((Class<Enum>) field.getType(), (String) value);
                        field.set(cours, enumValue);
                    } else {
                        field.set(cours, value);
                    }
                } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
                    e.printStackTrace(); // Gérer l'exception selon vos besoins
                }
            }
        });

        coursRepo.save(cours);

        return ResponseEntity.ok(cours);
        }
}
