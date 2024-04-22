package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Qualification;
import com.example.demo.repository.QualificationRepository;


@Service
public class QualificationServiceImpl implements QualificationService {
	
	@Autowired
	QualificationRepository qualificationrepository;
	

	@Override
	public Qualification saveQualification(Qualification qualification) {
		return qualificationrepository.save(qualification);
	}

	@Override
	public List<Qualification> getAllQualification() {
		return qualificationrepository.findAll();
	}

	@Override
	public Qualification getQualificationById(int id) {
		return qualificationrepository.findById(id).orElse(null);
	}

	@Override
	public Qualification updateQualification(Qualification qualification, int id) {
		Qualification ExistingQualification = qualificationrepository.findById(id).orElse(qualification);
		ExistingQualification.setPosition(qualification.getPosition());
		qualificationrepository.save(ExistingQualification);
		return ExistingQualification;
	}

	@Override
	public void deleteById(int id) {
		qualificationrepository.findById(id).orElse(null);
		qualificationrepository.deleteById(id);
		
	}

}
