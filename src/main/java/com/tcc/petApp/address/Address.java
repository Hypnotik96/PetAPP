package com.tcc.petApp.address;

import com.tcc.petApp.appUser.AppUser;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "PETAPP01_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PETAPP01_ADDRESS_ID", nullable = false)
    private Long id;

    @Column(name = "PETAPP01_ADDRESS_STREET", nullable = false)
    private String street;

    @Column(name = "PETAPP01_ADDRESS_NUMBER", nullable = false)
    private Integer number;

    @Column(name = "PETAPP01_ADDRESS_POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "PETAPP01_ADDRESS_CITY", nullable = false)
    private String city;

    @Column(name = "PETAPP01_ADDRESS_STATE", nullable = false)
    private String state;

    @Column(name = "PETAPP01_ADDRESS_COMPLEMENT", nullable = false)
    private String complement;

    @ManyToOne
    @JoinColumn(name = "appUser")
    private AppUser appUser;

}
