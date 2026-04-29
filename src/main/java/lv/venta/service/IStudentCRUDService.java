package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Student;


public interface IStudentCRUDService {
	//CRUD - create retrieve update delete
	
	//C - create
	public abstract void create(String name, String surname) throws Exception;
	
	//R - retrieve all
	public abstract ArrayList<Student> retireveAll() throws Exception;
	
	//R - retrieve by ID
	public abstract Student retrieveById(long sid) throws Exception;
	
	//U - update
	public abstract void updateById(long sid, String name, String surname) throws Exception;
	
	//D - delete by id
	public abstract void deleteById(long sid) throws Exception;
	
	
	
}
