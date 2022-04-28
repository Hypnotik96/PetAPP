package com.tcc.petApp.appUser.petCaregiver;

import com.tcc.petApp.appUser.AppUser;
import com.tcc.petApp.careService.CareService;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "PETAPP01_PET-CAREGIVER")
public class PetCaregiver extends AppUser {

    @Column(name = "PETAPP01_USER_PET-CAREGIVER_ASSOCIATION")
    private String association;

    @OneToMany(mappedBy = "petCaregiver")
    @Column(name = "PETAPP01_USER_PET-CAREGIVER_CARE-SERVICES")
    private List<CareService> careServices;

}
