package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IStudentCRUDService;

@Service
public class StudentCRUDServiceImpl implements IStudentCRUDService {
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
	//=================== nak no base

	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if(studRepo.count()==0) {
			throw new Exception("Studenta tabula DB ir tuksa");
		}
		
		ArrayList<Student> allStudentsFromDB = (ArrayList<Student>) studRepo.findAll();
		
		return allStudentsFromDB;
	}

	@Override
	public Student retrieveById(long id) throws Exception {
		if(id <= 0) {
			throw new Exception("Id nevar but negativs vai nulle");
		}
		if(!studRepo.existsById(id)) {
			throw new Exception("Students ar sadu id neeksiste DB");
		}
		//tad no DB izgustam pec id un atgriezam
		Student studentFromDB = studRepo.findById(id).get();
		
		return studentFromDB;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Student studentForRemoving = retrieveById(id); // ja nu students ir "piekabinats" kadai citai tabulai (piem atzime)
		
		ArrayList<Grade> gradesForThisStudent = grRepo.findByStudentSid(id);
		
		for(Grade tempG : gradesForThisStudent) {
			tempG.setStudent(null);
			grRepo.save(tempG); //saglaba to ka student bus null
		}
		
	}

	// ================= nak no studenta
	
	@Override
	public void create(String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(long sid, String name, String surname) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
