package com.gevbagratunyan.medicalwebapp.entity.examinations;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "radiology")
public class Radiology {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="exam_id", nullable=false)
    private Exams exams;

    @Column(name = "exam_date", nullable = false)
    private LocalDate date;

    @Column(name = "ultrasound")
    private String ULTRASOUND;

    @Column(name = "ct")
    private String CT;

    @Column(name = "mrt")
    private String MRT;

    @Column(name = "x_ray")
    private String X_RAY;
}
