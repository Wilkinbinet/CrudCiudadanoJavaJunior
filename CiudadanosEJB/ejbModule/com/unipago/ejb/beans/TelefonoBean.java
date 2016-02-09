package com.unipago.ejb.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Telefono;
import com.unipago.ciudadano.interfaces.TelefonoDao;

@Stateless
@Remote(TelefonoDao.class)
public class TelefonoBean implements TelefonoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Telefono crear(Telefono telefono) {
		em.persist(telefono);
		return telefono;
	}

	@Override
	public Telefono editar(Telefono telefono) {
		return em.merge(telefono);
	}

	@Override
	public void eliminar(int id) {
		Telefono aEliminar = obtenerTelefono(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
	}

	@Override
	public Telefono obtenerTelefono(int id) {
		return em.find(Telefono.class, id);
	}

}
