package com.tcc.petApp.appUser.petOwner;

import com.tcc.petApp.appUser.AppUser;
import com.tcc.petApp.pet.Pet;
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
@Table(name = "PETAPP01_USER_PET-OWNER")
public class PetOwner extends AppUser {

    @OneToMany(mappedBy = "petOwner")
    @Column(name = "PETAPP01_USER_PET-OWNER_PETS")
    private List<Pet> pets;
}
