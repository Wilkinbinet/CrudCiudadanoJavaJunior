package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Pais;
import com.unipago.ciudadano.interfaces.PaisDao;

public class PaisTester {
	
	PaisDao paisDao;
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
					"Ciudadanos/CiudadanosEJB/PaisBean!com.unipago.ciudadano.interfaces.PaisDao";
	        
	        paisDao = (PaisDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Test
	public void test() {
		assertNotNull(paisDao);
		
		// Crear
		Pais pais = new Pais();
		pais.setNombre("Venezuela");
		
		Pais result = paisDao.crear(pais);
		assertNotEquals(result.getIdPais(), 0);

		pais.setNombre("Republica Dominicana");
		
		result = paisDao.crear(pais);
		assertNotEquals(result.getIdPais(), 0);
		
		pais.setNombre("Colombia");
		
		 result = paisDao.crear(pais);
		assertNotEquals(result.getIdPais(), 0);
	}

}
