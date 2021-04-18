package com.gevbagratunyan.medicalwebapp.entity.examinations;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class BloodGeneral {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="exam_id", nullable=false)
    private Exams exams;

    @Column(name = "exam_date", nullable = false)
    private LocalDate date;

    @Column(name = "m_rbc")
    private double M_RED_BLOOD_CELLS;

    @Column(name = "f_rbc")
    private double F_RED_BLOOD_CELLS;

    @Column(name = "wbc")
    private double WHITE_BLOOD_CELLS;

    @Column(name = "m_hb")
    private double M_HEMOGLOBIN;

    @Column(name = "f_hb")
    private double F_HEMOGLOBIN;

    @Column(name = "m_esr")
    private double M_ESR;

    @Column(name = "f_esr")
    private double F_ESR;
}
