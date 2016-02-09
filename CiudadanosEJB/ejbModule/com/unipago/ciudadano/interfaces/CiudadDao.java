package com.unipago.ciudadano.interfaces;

import com.unipago.ciudadano.entity.Ciudad;

public interface CiudadDao {
	
	Ciudad crear(Ciudad ciudad);
	
	Ciudad editar(Ciudad ciudad);
	
	void eliminar(int id);
	
	Ciudad obtenerCiudad(int id);
}
