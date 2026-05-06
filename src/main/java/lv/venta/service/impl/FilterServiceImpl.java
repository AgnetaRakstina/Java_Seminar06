package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

public class FilterServiceImpl implements IFilterService {

	@Autowired
	private IProfessorRepo profRepo;
	@Autowired
	private IGradeRepo grRepo;
	@Autowired
	private IStudentRepo studRepo;
	@Autowired
	private ICourseRepo courRepo;
	
	
	
	@Override
	public ArrayList<Professor> filterProfessorByDegree(Degree degree) throws Exception {
		if (degree == null) {
			throw new Exception("grads nevar but null");
		}
		
		ArrayList<Professor> result = profRepo.findByDegree(degree);
		
		if (result.isEmpty()) {
			throw new Exception("Nav profesori ar " + degree);
		}
		
		return result;
	}

	@Override
	public ArrayList<Course> filterCourseByProfessorId(long id) throws Exception {
		if (id <= 0) {
			throw new Exception("Id nevar but negativa vai 0");
		}
		
		if (!profRepo.existsById(id)) {
			throw new Exception("Nevar atgriezt kursus, jo profesors ar id " + id + " neeksiste");
		}
		
		ArrayList<Course> result = courRepo.findByProfessorID(id);
		
		if (result.isEmpty()) {
			throw new Exception ("Nav neviena kursa ar pasniedzeju id " + id);
		}
		
		return result;
		
	}

	@Override
	public ArrayList<Grade> filterGradeByStudentNameAndSurname(String name, String surname) throws Exception {
		if (name == null || surname == null) { //var pielikt ari isempty vai regexp (iespejams)
			throw new Exception ("Ievades dati nevar but null");
		}
		
		if (!studRepo.existsByNameAndSurname(name, surname)) {
			throw new Exception("Students " + name + " " + surname + " neeksiste");
		}
		
		ArrayList<Grade> result = grRepo.findByStudentNameAndStudentSurname(name, surname);
		
		if (result.isEmpty()) {
			throw new Exception("Nav nevienas atzimes no ta studenta");
		}
		
		return result;
	}

	@Override
	public float calculateAvgGradeByCourseTitle(String title) throws Exception {
		if (title == null) { //TODO isempty un regexp
			throw new Exception("Ievades dati nav pilnigi");
		}
		if (!courRepo.existsBytitle(title)) {
			throw new Exception("Kurss ar nosaukumu " + title + " neeksiste");
		}
		
		float result = grRepo.calculateAVGGradeForCourse(title);
		
		if (result == 0) {
			throw new Exception("Kursam " + title + " nav piesaistitas atzimes");
		}
		
		return result;
		
	}

	@Override
	public ArrayList<Student> filterStudentsWithFailedGrades() throws Exception {
		
		if (studRepo.count() == 0) {
			throw new Exception("Studentu DB ir tuksa");
		}
		if (grRepo.count() == 0) {
			throw new Exception("Atzimes DB ir tuksa");
		}
		
		ArrayList<Student> result = studRepo.findByGrvalueLessThan(4);
		
		if (result.isEmpty()) {
			throw new Exception("Nav neviena studenta ar nesekmigu atzimi");
		}
		
		return result;
		
	} 
	
	
	
	
	
	
}
