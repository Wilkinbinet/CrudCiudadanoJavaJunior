
package com.unipago.ciudadano.ws;

import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.interfaces.CiudadanoDao;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Wilkin Binet
 */
@WebService(serviceName = "CiudadanosWS")
@Stateless()
public class CiudadanosWS {

    @EJB
    private CiudadanoDao ciudadanoDaoEJB;

    @WebMethod(operationName = "crear")
    public Ciudadano crear(@WebParam(name = "ciudadano") Ciudadano ciudadano) {
        return ciudadanoDaoEJB.crear(ciudadano);
    }

    @WebMethod(operationName = "editar")
    public Ciudadano editar(@WebParam(name = "ciudadano") Ciudadano ciudadano) {
        return ciudadanoDaoEJB.editar(ciudadano);
    }

    @WebMethod(operationName = "eliminar")
    @Oneway
    public void eliminar(@WebParam(name = "id") int id) {
        ciudadanoDaoEJB.eliminar(id);
    }

    @WebMethod(operationName = "obtenerCiudadano")
    public Ciudadano obtenerCiudadano(@WebParam(name = "id") int id) {
        return ciudadanoDaoEJB.obtenerCiudadano(id);
    }

    @WebMethod(operationName = "obtenerCiudadanosAll")
    public List<Ciudadano> obtenerCiudadanosAll() {
        return ciudadanoDaoEJB.obtenerCiudadanosAll();
    }
    
}
