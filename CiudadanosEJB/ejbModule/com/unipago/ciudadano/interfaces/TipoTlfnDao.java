package com.unipago.ciudadano.interfaces;

import com.unipago.ciudadano.entity.Tipotlfn;

public interface TipoTlfnDao {
	
	Tipotlfn crear(Tipotlfn tipotlfn);

	Tipotlfn editar(Tipotlfn tipotlfn);
	
	void eliminar(int id);
	
	Tipotlfn obtenerTipoTlf(int id);
}
