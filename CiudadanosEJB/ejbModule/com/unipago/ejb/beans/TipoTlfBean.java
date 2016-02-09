package com.unipago.ejb.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Tipotlfn;
import com.unipago.ciudadano.interfaces.TipoTlfnDao;

@Stateless
@Remote(TipoTlfnDao.class)
public class TipoTlfBean implements TipoTlfnDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Tipotlfn crear(Tipotlfn tipotlfn) {
		em.persist(tipotlfn);
		return tipotlfn;
	}

	@Override
	public Tipotlfn editar(Tipotlfn tipotlfn) {
		return em.merge(tipotlfn);
	}

	@Override
	public void eliminar(int id) {
		Tipotlfn aEliminar = obtenerTipoTlf(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
		
	}

	@Override
	public Tipotlfn obtenerTipoTlf(int id) {
		return em.find(Tipotlfn.class, id);
	}

}
