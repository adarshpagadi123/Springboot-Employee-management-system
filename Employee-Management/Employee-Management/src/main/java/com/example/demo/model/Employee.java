package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
@Setter@Getter
@Builder
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;


	private String fname;
	private String lname;
	private String gender;
	private String age;
	private String contact;
	private String emp_email;
	private String emp_pass;
	
	@CreationTimestamp
	@Column(updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp timein;
	
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp timeout;
	
	/*@CreatedDate
    @Column(name = "time_in", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	public Date timeIn;
	
	@LastModifiedDate
    @Column(name = "time_out")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeOut;*/
	
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "empId")
	    private Set<Qualification> qualification;
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "empId")//referencedColumnName="emp_id" // this refering for column name
	    private Set<Leave> leave;


}
