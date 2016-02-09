package com.unipago.ciudadano.interfaces;

import java.util.List;

import com.unipago.ciudadano.entity.Correoelectronico;



public interface CorreoElectronicoDao {
Correoelectronico crear(Correoelectronico correoelectronico);
	
	Correoelectronico editar(Correoelectronico correoelectronico);
	
	void eliminar(int id);
	
	Correoelectronico obtenerCorreo(int id);
	
}
