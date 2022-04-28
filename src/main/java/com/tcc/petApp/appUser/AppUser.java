package com.tcc.petApp.appUser;

import com.tcc.petApp.address.Address;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PETAPP01_USER_ID")
    private Long id;

    @Column(name = "PETAPP01_USER_CPF", nullable = false)
    private String cpf;

    @Column(name = "PETAPP01_USER_RG", nullable = false)
    private String rg;

    @Column(name = "PETAPP01_USER_NAME", nullable = false)
    private String name;

    @Column(name = "PETAPP01_USER_NAME", nullable = false)
    private String lastName;

    @Column(name = "PETAPP01_USER_PHONE", nullable = false)
    private String phone;

    @Column(name = "PETAPP01_USER_EMAIL", nullable = false)
    private String email;

    @Column(name = "PETAPP01_USER_BORN_DATE")
    private LocalDate bornDate;

    @Column(name = "PETAPP01_USER_PASSWORD", nullable = false)
    private String password;

    @OneToMany(mappedBy = "appUser")
    @Column(name = "PETAPP01_USER_ADDRESSES")
    private List<Address> addresses;
}
