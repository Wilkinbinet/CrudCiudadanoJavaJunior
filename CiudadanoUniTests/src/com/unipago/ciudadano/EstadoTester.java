package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudad;
import com.unipago.ciudadano.entity.Direccion;
import com.unipago.ciudadano.entity.Estado;
import com.unipago.ciudadano.entity.Pais;
import com.unipago.ciudadano.interfaces.EstadoDao;

public class EstadoTester {

	EstadoDao estadoDao;
	@Before
	public void setUp() throws Exception {
		
		try {
	        final Hashtable<String, Comparable> jndiProperties = 
				new Hashtable<String, Comparable>();

	        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, 
					"org.jboss.naming.remote.client.InitialContextFactory");
	        
		    jndiProperties.put("jboss.naming.client.ejb.context", true);
		    
		    jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
	        jndiProperties.put(Context.SECURITY_PRINCIPAL, "admin");
	        jndiProperties.put(Context.SECURITY_CREDENTIALS, "1234");
	        
	        final Context context = new InitialContext(jndiProperties);
	        
	        final String lookupName = 
					"Ciudadanos/CiudadanosEJB/EstadoBean!com.unipago.ciudadano.interfaces.EstadoDao";
	        
	        estadoDao = (EstadoDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	
	}

	@Test
	public void test() {
		assertNotNull(estadoDao);
		
		Estado estado = new Estado();
		estado.setNombre("Distrito Capital");
		
		Pais pais = new Pais();
		pais.setIdPais(1);
		estado.setPais(pais);
		Ciudad ciudad = new Ciudad();
		ciudad.setIdCiudad(1);
		estado.setCiudad(ciudad);
		
		Estado result2 = estadoDao.crear(estado);
		assertNotEquals(result2.getIdEstado(), 0);
		
		estado = new Estado();
		estado.setNombre("Santo Domingo");
		
		pais = new Pais();
		pais.setIdPais(2);
		estado.setPais(pais);
		
		ciudad = new Ciudad();
		ciudad.setIdCiudad(2);
		estado.setCiudad(ciudad);
		
		result2 = estadoDao.crear(estado);
		assertNotEquals(result2.getIdEstado(), 0);
	}

}
