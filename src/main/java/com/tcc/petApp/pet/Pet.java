package com.tcc.petApp.pet;

import com.tcc.petApp.appUser.petOwner.PetOwner;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "PETAPP01_PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PETAPP01_PET_ID", nullable = false)
    private Long id;

    @Column(name = "PETAPP01_PET_NAME", nullable = false)
    private String name;

    @Column(name = "PETAPP01_PET_TYPE", nullable = false)
    private String type;

    @Column(name = "PETAPP01_PET_BREED", nullable = false)
    private String breed;

    @Column(name = "PETAPP01_PET_SEX", nullable = false)
    private char sex;

    @Column(name = "PETAPP01_PET_SIZE", nullable = false)
    private String size;

    @Column(name = "PETAPP01_PET_BORN_DATE")
    private LocalDate bornDate;

    @Column(name = "PETAPP01_PET_NOTE")
    private String note;

    @ManyToOne
    @JoinColumn(name = "petOwner_id")
    private PetOwner petOwner;

}
