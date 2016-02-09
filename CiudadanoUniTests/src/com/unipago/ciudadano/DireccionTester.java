package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudad;
import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Direccion;
import com.unipago.ciudadano.entity.Estado;
import com.unipago.ciudadano.entity.Pais;
import com.unipago.ciudadano.interfaces.DireccionDao;

public class DireccionTester {
	private DireccionDao direcionDao;
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
					"Ciudadanos/CiudadanosEJB/DireccionBean!com.unipago.ciudadano.interfaces.DireccionDao";
	        
	        direcionDao = (DireccionDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Test
	public void test() {
		assertNotNull(direcionDao);
		
		Direccion direccion = new Direccion();
		Ciudad ciudad = new Ciudad();
		
		ciudad.setIdCiudad(1);
	
		Pais pais = new Pais();
		pais.setIdPais(1);


		Estado estado = new Estado();
		estado.setIdEstado(1);
		
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setIdCiudadano(1);
		
	
		direccion.setCalle("Los Manguitos");
		direccion.setCiudad(ciudad);
		direccion.setEstado(estado);
		direccion.setPais(pais);
		direccion.setCiudadano(ciudadano);
		
		
		
		Direccion result2 = direcionDao.crear(direccion);
		assertNotEquals(result2.getIdDireccion(), 0);
	}

}
