package com.unipago.ejb.beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.interfaces.CiudadanoDao;

@Stateless
@Remote(CiudadanoDao.class)
public class CiudadanoBean implements CiudadanoDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Ciudadano crear(Ciudadano ciudadano) {
		em.persist(ciudadano);
		return ciudadano;
	}

	@Override
	public Ciudadano editar(Ciudadano ciudadano) {
		return em.merge(ciudadano);
	}

	@Override
	public void eliminar(int id) {
		Ciudadano aEliminar = obtenerCiudadano(id);
		if(aEliminar != null){
			em.remove(aEliminar);	
		}
		
	}

	@Override
	public Ciudadano obtenerCiudadano(int id) {
		return em.find(Ciudadano.class, id);
	}

	@Override
	public List<Ciudadano> obtenerCiudadanosAll() {
		return em.createNamedQuery(Ciudadano.FINDALL, Ciudadano.class).getResultList();
	}
	
	
	public List<Object[]> obtenerCiudadanosTodos() {
		return em.createNativeQuery("SELECT c.IDCIUDADANO, c.NOMBRE, c.APELLIDO, c.SEXO , ce.DIRECCION, p.NOMBRE as pais, e.NOMBRE as estado, ci.NOMBRE as ciudad, d.CALLE, t.NUMERO as telefono, c.FECHANACIMIENTO FROM ciudadano c INNER JOIN direccion d ON c.IDCIUDADANO=d.IdCiudadano INNER JOIN paises p on p.IDPAIS=d.idPais INNER JOIN ciudad ci on ci.IDCIUDAD = d.idCiudad INNER JOIN estados e on e.IDESTADO = d.idEstado LEFT JOIN telefono t on c.IDCIUDADANO = t.idCiudadano LEFT join correoelectronico ce on ce.idCiudadano= c.IDCIUDADANO GROUP BY c.IDCIUDADANO").getResultList();
	}
}
