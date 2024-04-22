 package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Setter@Getter@Data
@Table(name = "payroll")
public class Payroll {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payroll_Id;
    
    private String date;
    private String report;
    private long total_amount;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empId")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leave_Id")
    private Leave leave;
    
    

}
