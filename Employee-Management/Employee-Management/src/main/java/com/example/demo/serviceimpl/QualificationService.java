package com.example.demo.serviceimpl;


import java.util.List;
import com.example.demo.model.Qualification;

public interface QualificationService {

	Qualification saveQualification(Qualification qualification);

	List<Qualification> getAllQualification();

	Qualification getQualificationById(int id);

	Qualification updateQualification(Qualification qualification,int id);

	void deleteById(int id);


}
