package com.unipago.ciudadano.interfaces;

import java.util.List;

import com.unipago.ciudadano.entity.Ciudadano;


public interface CiudadanoDao {

	Ciudadano crear(Ciudadano ciudadano);
	
	Ciudadano editar(Ciudadano ciudadano);
	
	void eliminar(int id);
	
	Ciudadano obtenerCiudadano(int id);
	
	List<Ciudadano> obtenerCiudadanosAll();
	
	List<Object[]> obtenerCiudadanosTodos();
}
