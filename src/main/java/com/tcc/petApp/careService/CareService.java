package com.tcc.petApp.careService;

import com.tcc.petApp.appUser.petCaregiver.PetCaregiver;
import com.tcc.petApp.feedback.Feedback;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "PETAPP01_CARE_SERVICE")
public class CareService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PETAPP01_CARE_SERVICE_ID", nullable = false)
    private Long id;

    @Column(name = "PETAPP01_CARE_SERVICE_NAME", nullable = false)
    private String name;

    @Column(name = "PETAPP01_CARE_SERVICE_PET_NAME", nullable = false)
    private String petName;

    @Column(name = "PETAPP01_CARE_SERVICE_TYPE", nullable = false)
    private String type;

    @Column(name = "PETAPP01_CARE_SERVICE_RANGE", nullable = false)
    private byte range;

    @Column(name = "PETAPP01_CARE_SERVICE_DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PETAPP01_CARE_SERVICE_COST", nullable = false)
    private double cost;

    @Column(name = "PETAPP01_CARE_SERVICE_TIME", nullable = false)
    @ElementCollection(targetClass = String.class)
    private List<String> time;

    @Column(name = "PETAPP01_CARE_SERVICE_DATE", nullable = false)
    @ElementCollection(targetClass = String.class)
    private List<String> date;

    @OneToMany(mappedBy = "careService")
    @Column(name = "PETAPP01_CARE_SERVICE_FEEDBACKS")
    private List<Feedback> feedbackList;

    @ManyToOne
    @JoinColumn(name = "petCaregiver_id")
    private PetCaregiver petCaregiver;
}
