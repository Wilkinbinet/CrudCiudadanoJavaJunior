package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Tipotlfn;
import com.unipago.ciudadano.interfaces.TipoTlfnDao;

public class TipoTelefTester {
	
	private TipoTlfnDao tipoTlfnDao;
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
					"Ciudadanos/CiudadanosEJB/TipoTlfBean!com.unipago.ciudadano.interfaces.TipoTlfnDao";
	        
	        tipoTlfnDao = (TipoTlfnDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Test
	public void test() {
		assertNotNull(tipoTlfnDao);
		
		Tipotlfn tipotlfn = new Tipotlfn();
		tipotlfn.setNombreTipo("Local");
		
		Tipotlfn result = tipoTlfnDao.crear(tipotlfn);
		assertNotEquals(result.getIdTipoTlfn(), 0);
		
		tipotlfn = new Tipotlfn();
		tipotlfn.setNombreTipo("Celular");
		
		result = tipoTlfnDao.crear(tipotlfn);
		assertNotEquals(result.getIdTipoTlfn(), 0);
	}

}
