package com.unipago.ejb.beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Correoelectronico;
import com.unipago.ciudadano.interfaces.CorreoElectronicoDao;

@Stateless
@Remote(CorreoElectronicoDao.class)
public class CorreoElectronicoBean implements CorreoElectronicoDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Correoelectronico crear(Correoelectronico correoelectronico) {
		em.persist(correoelectronico);
		return correoelectronico;
	}

	@Override
	public Correoelectronico editar(Correoelectronico correoelectronico) {
		return em.merge(correoelectronico);
	}

	@Override
	public void eliminar(int id) {
		Correoelectronico aEliminar = obtenerCorreo(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
	}

	@Override
	public Correoelectronico obtenerCorreo(int id) {
		return em.find(Correoelectronico.class, id);
	}

}
