package com.gevbagratunyan.medicalwebapp.entity;

import com.gevbagratunyan.medicalwebapp.enums.Disease;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "tel")
    private String telNumber;

    @Column(name = "address")
    private String address;

    @ElementCollection
    @CollectionTable(name = "diseases")
    @MapKeyColumn(name = "date")
    private Map<LocalDate,String> diseases;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

}
