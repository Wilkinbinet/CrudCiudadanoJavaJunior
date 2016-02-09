package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Correoelectronico;
import com.unipago.ciudadano.interfaces.CorreoElectronicoDao;


public class CorreoElectronicoTester {
	
	private CorreoElectronicoDao correoElectronicoDao;
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
					"Ciudadanos/CiudadanosEJB/CorreoElectronicoBean!com.unipago.ciudadano.interfaces.CorreoElectronicoDao";
	        
	        correoElectronicoDao = (CorreoElectronicoDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Test
	public void test() {
		assertNotNull(correoElectronicoDao);
		
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setIdCiudadano(1);
		Correoelectronico correoElectronico = new Correoelectronico();
		correoElectronico.setCiudadano(ciudadano);
		correoElectronico.setDireccion("Wilzander1@hotmail.com");
		
		Correoelectronico result = correoElectronicoDao.crear(correoElectronico);
		assertNotEquals(result.getIdCorreo(), 0);
		
	}

}
