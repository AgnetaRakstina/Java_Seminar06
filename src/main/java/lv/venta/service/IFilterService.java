package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;


public interface IFilterService {
	
	//visi profesori, kura grads ir konkretais
	public abstract ArrayList<Professor> filterProfessorByDegree(Degree dgeree) throws Exception;
	
	//iegut kursus, kurus pasniedz professors ar konkreto id
	public abstract ArrayList<Course> filterCourseByProfessorId(long id) throws Exception;
	
	//iegut visas atzimes, ja zinams studena vards un uzvards
	public abstract ArrayList<Grade> filterGradeByStudentNameAndSurname(String name, String surname) throws Exception;
	
	//iegut video atzimju vertiba, ja ir zinams kursa nosaukums
	public abstract float calculateAvgGradeByCourseTitle(String title) throws Exception;
	
	//iegut visus studentus kuriem ir kada nesekmiga atzime
	public abstract ArrayList<Student> filterStudentsWithFailedGrades() throws Exception;
	
}
