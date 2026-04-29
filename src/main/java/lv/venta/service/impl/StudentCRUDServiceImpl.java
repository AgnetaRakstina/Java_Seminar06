/*
package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Student;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IStudentCRUDService;



@Service
public class StudentCRUDServiceImpl implements IStudentCRUDService {
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public void create(String name, String surname) throws Exception {
		
		
	}
	
	@Override
	public ArrayList<Student> retrieveAll() throws Exception {
		if( studRepo.count() == 0) {
			throw new Exception("Studentu tabula DB ir tuksa");
		}
		
		ArrayList<Student> allStudentsFromDB = (ArrayList<Student>) studRepo.findAll();
		
		return allStudentsFromDB;
	}
	
	@Override 
	public Student ArrayList<Student> retrieveById(long sid) throws Exception {
		if (sid <= 0) {
			throw new Exception("ID nevar but negativs vai nulle");
		}
		if (!prodRepo.existsById(sid)) {
			throw new Exception("Students ar sadu id neeksiste DB");
		}
		Student studentFromDB = studRepo.findById(sid).get();
		
		return studentFromDB;
		
	}
	
	@Override
	public abstract void updateById(long sid, String name, String surname) throws Exception {
		
	}
	
	@Override
	public abstract void deleteById(long sid) throws Exception {
		
	}
	
}
*/
