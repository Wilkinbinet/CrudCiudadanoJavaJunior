package com.unipago.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.unipago.ciudadano.entity.Ciudad;
import com.unipago.ciudadano.entity.Ciudadano;
import com.unipago.ciudadano.entity.Correoelectronico;
import com.unipago.ciudadano.entity.Direccion;
import com.unipago.ciudadano.entity.Estado;
import com.unipago.ciudadano.entity.Pais;
import com.unipago.ciudadano.entity.Telefono;
import com.unipago.ciudadano.entity.Tipotlfn;
import com.unipago.ciudadano.interfaces.CiudadDao;
import com.unipago.ciudadano.interfaces.CiudadanoDao;
import com.unipago.ciudadano.interfaces.CorreoElectronicoDao;
import com.unipago.ciudadano.interfaces.DireccionDao;
import com.unipago.ciudadano.interfaces.EstadoDao;
import com.unipago.ciudadano.interfaces.PaisDao;
import com.unipago.ciudadano.interfaces.TelefonoDao;
import com.unipago.to.CiudadanoTo;

@ManagedBean
@Named("ciudadano")
@ViewScoped
public class CiudadanoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private CiudadanoDao ciudadanoDao;
	@EJB
	private DireccionDao direccionDao;
	@EJB
	private  CorreoElectronicoDao correoElectronicoDao;
	@EJB
	private EstadoDao estadoDao;
	@EJB
	private PaisDao paisDao;
	@EJB
	private CiudadDao ciudadDao;
	@EJB
	private TelefonoDao telefonoDao;
	private Boolean mostrarTable;
	private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
	private List<CiudadanoTo> listCiudadano = new ArrayList<CiudadanoTo>();
	private Direccion direccion= new Direccion();
	private Pais pais= new Pais();
	private Ciudad ciudad = new Ciudad();
	private Estado estado = new Estado();
	private Correoelectronico correoelectronico= new Correoelectronico();
	private Telefono telefonoCelular =new Telefono();
	private Telefono telefonoLocal =new Telefono();
	private Ciudadano ciudadano = new Ciudadano();
	private CiudadanoTo ciudadanoTo = new CiudadanoTo();
	
	
	public CiudadanoBean() {
	}
	
	public void crearCiudadano(){
		
		Ciudadano ciudadanoCreado= ciudadanoDao.crear(ciudadano);
		
		direccion.setCiudad(ciudad);
		direccion.setEstado(estado);
		direccion.setPais(pais);
		direccion.setCiudadano(ciudadanoCreado);
		
		direccionDao.crear(direccion);
		
		Tipotlfn tipotlfn = new Tipotlfn();
		tipotlfn.setIdTipoTlfn(1);
		telefonoLocal.setTipotlfn(tipotlfn);
		telefonoLocal.setCiudadano(ciudadanoCreado);
		telefonoDao.crear(telefonoLocal);
		
		correoelectronico.setCiudadano(ciudadanoCreado);
		correoElectronicoDao.crear(correoelectronico);
		
		
		
	}
	
	
	
	public List<CiudadanoTo> listarCiudadano(){
		this.mostrarTable= true;
		List<Object[]> listaCiu = ciudadanoDao.obtenerCiudadanosTodos();
		for (Object[] datos : listaCiu) {
			ciudadanoTo.setIdCiudadano((Integer)datos[0]);
			ciudadanoTo.setNombre(datos[1].toString());
			ciudadanoTo.setApellido(datos[2].toString());
			ciudadanoTo.setSexo(datos[3].toString());
			ciudadanoTo.setFechaNacimiento((Date)datos[10]);
			ciudadanoTo.setCorreoelectronico(datos[4].toString());
			ciudadanoTo.setPais(datos[5].toString());
			ciudadanoTo.setEstado(datos[6].toString());
			ciudadanoTo.setCiudad(datos[7].toString());
			ciudadanoTo.setCalle(datos[8].toString());
			ciudadanoTo.setTelefonos((Integer)datos[9]);
			
			listCiudadano.add(ciudadanoTo);
        	
        }
		return this.listCiudadano;
		
	}
	
	public void onRowEdit(RowEditEvent event) {
		
		ciudadano.setIdCiudadano(((CiudadanoTo) event.getObject()).getIdCiudadano());
		ciudadano.setApellido(((CiudadanoTo) event.getObject()).getApellido());
		ciudadano.setNombre(((CiudadanoTo) event.getObject()).getNombre());
		ciudadano.setFechaNacimiento(((CiudadanoTo) event.getObject()).getFechaNacimiento());
		ciudadano.setSexo(((CiudadanoTo) event.getObject()).getSexo());
		
		Ciudadano ciudadanoEditado = ciudadanoDao.editar(ciudadano);
		
		ciudad.setIdCiudad(Integer.parseInt(((CiudadanoTo) event.getObject()).getCiudad()));
		estado.setIdEstado(Integer.parseInt(((CiudadanoTo) event.getObject()).getEstado()));
		pais.setIdPais(Integer.parseInt(((CiudadanoTo) event.getObject()).getPais()));
		
		direccion.setCiudad(ciudad);
		direccion.setEstado(estado);
		direccion.setPais(pais);
		direccion.setCalle(((CiudadanoTo) event.getObject()).getCalle());
		direccion.setCiudadano(ciudadanoEditado);
		
		direccionDao.editar(direccion);
		
		Tipotlfn tipotlfn = new Tipotlfn();
		tipotlfn.setIdTipoTlfn(1);
		telefonoLocal.setTipotlfn(tipotlfn);
		telefonoLocal.setNumero(((CiudadanoTo) event.getObject()).getTelefonos());
		telefonoLocal.setCiudadano(ciudadanoEditado);
		telefonoDao.editar(telefonoLocal);
		
		correoelectronico.setCiudadano(ciudadanoEditado);
		correoelectronico.setDireccion(((CiudadanoTo) event.getObject()).getCorreoelectronico());
		correoElectronicoDao.editar(correoelectronico);
		
        FacesMessage msg = new FacesMessage("La fila seleccionada fue editada el nombre y apellido son los siguiente: " + ciudadano.getNombre() + " "+ciudadano.getApellido(), "");
        int id = ((CiudadanoTo) event.getObject()).getIdCiudadano();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public CiudadanoDao getCiudadanoDao() {
		return ciudadanoDao;
	}

	public void setCiudadanoDao(CiudadanoDao ciudadanoDao) {
		this.ciudadanoDao = ciudadanoDao;
	}

	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public Boolean getMostrarTable() {
		return mostrarTable;
	}

	public void setMostrarTable(Boolean mostrarTable) {
		this.mostrarTable = mostrarTable;
	}
	
	

	public List<CiudadanoTo> getListCiudadano() {
		return listCiudadano;
	}

	public void setListCiudadano(List<CiudadanoTo> listCiudadano) {
		this.listCiudadano = listCiudadano;
	}

	public CiudadanoTo getCiudadanoTo() {
		return ciudadanoTo;
	}

	public void setCiudadanoTo(CiudadanoTo ciudadanoTo) {
		this.ciudadanoTo = ciudadanoTo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Correoelectronico getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(Correoelectronico correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	

	public Telefono getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(Telefono telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public Telefono getTelefonoLocal() {
		return telefonoLocal;
	}

	public void setTelefonoLocal(Telefono telefonoLocal) {
		this.telefonoLocal = telefonoLocal;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	
	
	
}
