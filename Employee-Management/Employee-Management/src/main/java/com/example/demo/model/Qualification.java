package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Setter@Getter@Data
@Table(name = "qualification")
public class Qualification {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qual_Id;
    
    private String position;
    private String requirements;
    private String date_in;
    
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empId")
    private Employee employee;*/
    
	
}
