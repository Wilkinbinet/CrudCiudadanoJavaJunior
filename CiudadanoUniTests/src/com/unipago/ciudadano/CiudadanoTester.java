package com.unipago.ciudadano;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.SingleSelectionModel;

import org.junit.Before;
import org.junit.Test;

import com.unipago.ciudadano.entity.Ciudad;
import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Correoelectronico;
import com.unipago.ciudadano.entity.Direccion;
import com.unipago.ciudadano.entity.Estado;
import com.unipago.ciudadano.entity.Pais;
import com.unipago.ciudadano.entity.Telefono;
import com.unipago.ciudadano.entity.Tipotlfn;
import com.unipago.ciudadano.interfaces.CiudadanoDao;

public class CiudadanoTester {
	
	private CiudadanoDao ciudadanoDao;

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
					"Ciudadanos/CiudadanosEJB/CiudadanoBean!com.unipago.ciudadano.interfaces.CiudadanoDao";
	        
	        ciudadanoDao = (CiudadanoDao) context.lookup(lookupName);
	        
		} catch (Exception ex) {
			throw ex;
		}
	
	}

	@Test
	public void test() {
		assertNotNull(ciudadanoDao);
		
		// Crear
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Alexander");
		ciudadano.setApellido("Binet");
		ciudadano.setSexo("Masculino");
		
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.set(Calendar.DAY_OF_MONTH, 1);
		fechaNac.set(Calendar.MONTH, 1);
		fechaNac.set(Calendar.YEAR, 1975);
		ciudadano.setFechaNacimiento(fechaNac.getTime());
		
		Ciudadano result = ciudadanoDao.crear(ciudadano);
		assertNotEquals(result.getIdCiudadano(), 0);
		
		

	}

}
