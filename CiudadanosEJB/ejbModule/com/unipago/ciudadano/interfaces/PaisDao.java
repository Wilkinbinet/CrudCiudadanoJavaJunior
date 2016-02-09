package com.unipago.ciudadano.interfaces;

import java.util.List;

import com.unipago.ciudadano.entity.Pais;


public interface PaisDao {
	
Pais crear(Pais ciudadano);
	
	Pais editar(Pais ciudadano);
	
	void eliminar(int id);
	
	Pais obtenerPais(int id);
	
}
