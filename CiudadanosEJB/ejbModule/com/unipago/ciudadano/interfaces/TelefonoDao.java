package com.unipago.ciudadano.interfaces;

import java.util.List;

import com.unipago.ciudadano.entity.Telefono;


public interface TelefonoDao {
	
	Telefono crear(Telefono telefono);
	
	Telefono editar(Telefono telefono);
	
	void eliminar(int id);
	
	Telefono obtenerTelefono(int id);
	
}
