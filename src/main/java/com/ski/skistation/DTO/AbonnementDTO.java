package com.ski.skistation.DTO;

import java.time.LocalDate;

import com.ski.skistation.entities.enums.TypeAbonnement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbonnementDTO {
 	private Long numAbon;
    private LocalDate dateDebut;
    private LocalDate dataFin;
    private Float prixAbon;
    private TypeAbonnement TypeAbonnement;
}
