package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Setter
@Getter
@Data
@Table(name = "leaves")
public class Leave {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_Id;
    
    private String date;
    private String reason;
    
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empId")//referencedColumnName="emp_id" // this refering for column name
    private Employee employee;*/
    

    
}
