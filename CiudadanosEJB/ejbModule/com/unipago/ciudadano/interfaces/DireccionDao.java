package com.unipago.ciudadano.interfaces;

import java.util.List;

import com.unipago.ciudadano.entity.Direccion;


public interface DireccionDao {
	
Direccion crear(Direccion direccion);
	
	Direccion editar(Direccion direccion);
	
	void eliminar(int id);
	
	Direccion obtenerDireccion(int id);
	
}
