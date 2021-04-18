package com.gevbagratunyan.medicalwebapp.entity.examinations;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class BloodChemistry {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="exam_id", nullable=false)
    private Exams exams;

    @Column(name = "exam_date", nullable = false)
    private LocalDate date;

    @Column(name = "alt")
    private double ALT; //4 to 36 IU/L

    @Column(name = "ast")
    private double AST; //8 to 33 IU/L

    @Column(name = "m_creat")
    private double M_CREATININE; //0.6 to 1.2 mg/dL

    @Column(name = "f_creat")
    private double F_CREATININE; //0.5 to 1.3 mg/dL

    @Column(name = "glucose")
    private double GLUCOSE; //70 to 100 mg/dL

    @Column(name = "total_bil")
    private double TOTAL_BILIRUBIN; //0.1 to 1.2 mg/dL

    @Column(name = "uncon_bil")
    private double UNCONJUGATED_BILIRUBIN; // <0.9 mg/dl

    @Column(name = "con_bil")
    private double CONJUGATED_BILIRUBIN; // <0.3 mg/dl

}
