package lv.venta.service;

import lv.venta.model.Student;


public interface IStudentCRUDService extends ICRUDServiceBase<Student> {
	//CRUD prieks studenta - retrieveAll, retrieveById, deleteById (nak no ICRUDServiceBase)
	
	//C - create
	public abstract void create(String name, String surname) throws Exception;
	
	//U - update
	public abstract void updateById(long sid,  String name, String surname) throws Exception;
	
	
	
	
}
