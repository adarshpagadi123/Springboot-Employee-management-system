package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Setter@Getter@Data
@Table(name = "salary")
public class Salary {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sal_Id;
    private int Amount;
    private int anual;
    private int bonus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sal_Id")
    private Set<Payroll> payroll;

}
