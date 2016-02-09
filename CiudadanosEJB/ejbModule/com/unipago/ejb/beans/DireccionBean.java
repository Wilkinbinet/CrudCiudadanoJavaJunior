package com.unipago.ejb.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Direccion;
import com.unipago.ciudadano.interfaces.DireccionDao;

@Stateless
@Remote(DireccionDao.class)
public class DireccionBean implements DireccionDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Direccion crear(Direccion direccion) {
		em.persist(direccion);
		return direccion;
	}

	@Override
	public Direccion editar(Direccion direccion) {
		return em.merge(direccion);
	}

	@Override
	public void eliminar(int id) {
		Direccion aEliminar = obtenerDireccion(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
	}

	@Override
	public Direccion obtenerDireccion(int id) {
		return em.find(Direccion.class, id);
	}

		
}
