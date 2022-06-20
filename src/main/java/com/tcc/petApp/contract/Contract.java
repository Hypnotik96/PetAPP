package com.tcc.petApp.contract;

import com.tcc.petApp.appUser.petOwner.PetOwner;
import com.tcc.petApp.careService.CareService;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "PETAPP01_CONTRACT")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PETAPP01_CONTRACT_ID", nullable = false)
    private Long id;

    @Column(name = "PETAPP01_CONTRACT_WHEN", nullable = false)
    private LocalDateTime when;

    @Column(name = "PETAPP01_CONTRACT_PET_NAME", nullable = false)
    private String petName;

    @ManyToOne
    @JoinColumn(name = "PETAPP01_CARE_SERVICE_ID")
    private CareService careService;

    @ManyToOne
    @JoinColumn(name = "PETAPP_USER_ID")
    private PetOwner petOwner;
}
