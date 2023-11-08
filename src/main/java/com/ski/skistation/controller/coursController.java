package com.ski.skistation.controller;

import com.ski.skistation.Exception.ResourceNotFoundException;
import com.ski.skistation.entities.Cours;
import com.ski.skistation.repository.CoursRepository;
import com.ski.skistation.service.IserviceCours;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/cours")
public class coursController {

@Autowired
    IserviceCours iserviceCours;
    @Autowired
    private CoursRepository coursRepository;
@GetMapping
    public List<Cours> getAll(){
    return iserviceCours.retrieveAllCourses();
}

@GetMapping("/{numCours}")
public Optional<Cours> retrieveCours(@PathVariable("numCours") Long numCours){

    return  iserviceCours.retrieveCours(numCours);
}

@PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours cours){
    return  iserviceCours.addCours(cours);
}

@PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours cours){
    return iserviceCours.updateCours(cours);
}

@DeleteMapping("/deleteCours/{numCours}")
    public void removeCours(@PathVariable("numCours") Long numCours){
    iserviceCours.removeCours(numCours);
}




    @PatchMapping("/{numCours}")
    public ResponseEntity<Cours> partialUpdateCourse(@PathVariable Long numCours, @RequestBody Map<String, Object> updates) {
        Cours existingCours = coursRepository.findById(numCours).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + numCours));


        if (existingCours == null) {
            return ResponseEntity.notFound().build();
        }

        applyUpdates(existingCours, updates);

        coursRepository.save(existingCours);

        return ResponseEntity.ok(existingCours);
    }

    private void applyUpdates(Cours existingCours, Map<String, Object> updates) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(existingCours);
        Set<String> nullProperties = new HashSet<>();

        updates.forEach((key, value) -> {
            if (value == null) {
                nullProperties.add(key);
            }
            beanWrapper.setPropertyValue(key, value);
        });

        // Ignore null properties to prevent overwriting existing values with null
        String[] ignoredProperties = nullProperties.toArray(new String[0]);
        BeanUtils.copyProperties(updates, existingCours, ignoredProperties);
    }

    @PatchMapping("/update/{numCours}")
    public ResponseEntity<Cours> partialUpdateCours(@PathVariable Long numCours, @RequestBody Map<String, Object> updates) {
        return iserviceCours.partialUpdateCours(numCours, updates);
    }


}
