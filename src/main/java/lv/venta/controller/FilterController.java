package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.enums.Degree;
import lv.venta.service.IFilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private IFilterService filterService;
	
	@GetMapping("/professor/degree/{inputdegree}") // localhost:8080/filter/professor/degree/phd
	public String getProfessorsByDegree(@PathVariable(name = "inputdegree") Degree inputdegree, Model model) {
		try {
		ArrayList<Professor> professorsFromDB = filterService.filterProfessorByDegree(inputdegree);
		model.addAttribute("package", professorsFromDB);
		return "show-multiple-professors-page";
		
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	
	@GetMapping("/course/professor/{id}")
	public String getCourseByProfessorID(@PathVariable(name = "id") long id, Model model) {
		try {
			ArrayList<Course> coursesFromDB = filterService.filterCourseByProfessorId(id);
			model.addAttribute("packge", coursesFromDB);
			return "show-multiple-courses-page";
			
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/grades/student/{name}/{surname}")
	public String getGradesByStudentNameAndSurname(@PathVariable(name = "name") String name, @PathVariable(name = "surname") String surname, Model model) {
		try {
			ArrayList<Grade> gradesFromDB = filterService.filterGradeByStudentNameAndSurname(name, surname);
			model.addAttribute("package", gradesFromDB);
			return "show-multiple-grades-page";
			
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	//calculateAvgGradeByCourseTitle
	@GetMapping("/course/title/average")
	public String getAvrCourseGradeByCourseTitle(@PathVariable(name = "title") String title, Model model) {
		try {
			float avgGrade = filterService.calculateAvgGradeByCourseTitle(title);
			model.addAttribute("package", avgGrade);
			
			return "show-average-grade-by-title-page";
			
			
		} catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
}	

