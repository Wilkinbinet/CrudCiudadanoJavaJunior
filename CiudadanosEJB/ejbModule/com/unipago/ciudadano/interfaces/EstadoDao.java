package com.unipago.ciudadano.interfaces;

import java.util.List;

import com.unipago.ciudadano.entity.Estado;


public interface EstadoDao {
	
Estado crear(Estado estado);
	
	Estado editar(Estado estado);
	
	void eliminar(int id);
	
	Estado obtenerEstado(int id);
	
}
