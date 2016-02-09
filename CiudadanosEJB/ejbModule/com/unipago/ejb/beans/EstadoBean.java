package com.unipago.ejb.beans;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Estado;
import com.unipago.ciudadano.interfaces.EstadoDao;


@Stateless
@Remote(EstadoDao.class)
public class EstadoBean implements EstadoDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Estado crear(Estado estado) {
		em.persist(estado);
		return estado;
	}

	@Override
	public Estado editar(Estado estado) {
		return em.merge(estado);
	}

	@Override
	public void eliminar(int id) {
	Estado aEliminar = obtenerEstado(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
	}

	@Override
	public Estado obtenerEstado(int id) {
		return em.find(Estado.class, id);
	}

	
}
