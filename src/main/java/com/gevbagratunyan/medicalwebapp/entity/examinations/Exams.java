package com.gevbagratunyan.medicalwebapp.entity.examinations;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "examinations")
@Data
public class Exams {
    @Id
    @GeneratedValue
    private  Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exams")
    private List<BloodChemistry> bloodChemistry;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exams")
    private List<BloodGeneral> bloodGeneral;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exams")
    private List<Radiology> radiology;

}
