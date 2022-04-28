package com.tcc.petApp.feedback;

import com.tcc.petApp.careService.CareService;
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
@Table(name = "PETAPP01_FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PETAPP01_FEEDBACK_ID")
    private Long id;

    @Column(name = "PETAPP01_FEEDBACK_SCORE")
    private byte score;

    @Column(name = "PETAPP01_FEEDBACK_COMMENT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "careService_id")
    private CareService careService;
}
