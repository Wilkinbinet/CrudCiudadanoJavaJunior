package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudad;
import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.interfaces.CiudadDao;

public class CiudadTester {
	
	CiudadDao ciudadDao;
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
					"Ciudadanos/CiudadanosEJB/CiudadBean!com.unipago.ciudadano.interfaces.CiudadDao";
	        
	        ciudadDao = (CiudadDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Test
	public void test() {
		assertNotNull(ciudadDao);
		
		Ciudad ciudad = new Ciudad();
		ciudad.setNombre("Caracas");
		
		
		Ciudad result = ciudadDao.crear(ciudad);
		assertNotEquals(result.getIdCiudad(), 0);
		ciudad.setNombre("Santo Domingo");
		 result = ciudadDao.crear(ciudad);
		assertNotEquals(result.getIdCiudad(), 0);
	}

}
