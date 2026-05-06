package lv.venta.service;

import java.util.ArrayList;


//Ttype - template datu tips, kas pielagosies velak jau konkretaja CRUD interfeisa
public interface ICRUDServiceBase<Ttype> {
	//CRUD - ka baze tam funkcijam kuras var sablonizet - retrieveAll, retrieveById, deleteById
	
	//R - retrieveAll
	public abstract ArrayList<Ttype> retrieveAll() throws Exception;
	
	//R - retrieveById
	public abstract Ttype retrieveById(long id) throws Exception;
	
	//D - deleteById
	public abstract void deleteById(long id) throws Exception;
	
	
}
