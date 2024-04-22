package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@Setter@Getter
@NoArgsConstructor@AllArgsConstructor
@Table(name = "job_department")
public class JobDepartment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    private String job_dept;
    private String name;
    private String description;
    private String salary_range;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobId")
    private Set<Salary> salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobId")
    private Set<Payroll> payroll;
    
    
    
    

}
