package com.unipago.ejb.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Pais;
import com.unipago.ciudadano.interfaces.PaisDao;

@Stateless
@Remote(PaisDao.class)
public class PaisBean implements PaisDao {
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public Pais crear(Pais pais) {
		em.persist(pais);
		return pais;
	}

	@Override
	public Pais editar(Pais pais) {
		return em.merge(pais);
	}

	@Override
	public void eliminar(int id) {
		Pais aEliminar = obtenerPais(id);
			if(aEliminar != null){
				em.remove(aEliminar);	
			}
	}

	@Override
	public Pais obtenerPais(int id) {
		return em.find(Pais.class, id);
	}

}
