package com.unipago.ejb.beans;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudad;
import com.unipago.ciudadano.entity.Telefono;
import com.unipago.ciudadano.interfaces.CiudadDao;

@Stateless
@Remote(CiudadDao.class)
public class CiudadBean implements CiudadDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Ciudad crear(Ciudad ciudad) {
		em.persist(ciudad);
		return ciudad;
	}

	@Override
	public Ciudad editar(Ciudad ciudad) {
		return em.merge(ciudad);
	}

	@Override
	public void eliminar(int id) {
		Ciudad aEliminar = obtenerCiudad(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
		
	}

	@Override
	public Ciudad obtenerCiudad(int id) {
		return em.find(Ciudad.class, id);

	}
	
}
