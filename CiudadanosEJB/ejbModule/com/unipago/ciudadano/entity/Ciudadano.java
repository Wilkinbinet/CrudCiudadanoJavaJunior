package com.unipago.ciudadano.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ciudadano database table.
 * 
 */
@Entity
@Table(name="ciudadano")
@NamedQuery(name=Ciudadano.FINDALL, query="SELECT c FROM Ciudadano c")
@NamedNativeQuery(name=Ciudadano.FINDTODOS, query="SELECT c.NOMBRE, c.APELLIDO, c.SEXO , ce.DIRECCION, p.NOMBRE as pais, e.NOMBRE as estado, ci.NOMBRE as ciudad, d.CALLE FROM ciudadano c INNER JOIN direccion d ON c.IDCIUDADANO=d.IdCiudadano INNER JOIN correoelectronico ce on c.IDCIUDADANO=ce.idCiudadano INNER JOIN paises p on d.idPais= p.IDPAIS INNER JOIN estados e on e.IDESTADO = d.idEstado INNER JOIN ciudad ci on d.idCiudad = e.idCiudad")

public class Ciudadano implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FINDALL = "Ciudadano.findAll";
	public static final String FINDTODOS = "Ciudadano.findTodos";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idCiudadano;

	@Column(nullable=false, length=55)
	private String apellido;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechaNacimiento;

	@Column(nullable=false, length=55)
	private String nombre;
	
	@Column(nullable=false, length=55)
	private String sexo;

	//bi-directional many-to-one association to Correoelectronico
	@OneToMany(mappedBy="ciudadano", fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Correoelectronico> correoelectronicos= new ArrayList<Correoelectronico>();

	//bi-directional many-to-one association to Direccion
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="ciudadano", fetch=FetchType.EAGER)
	private List<Direccion> direccions = new ArrayList<Direccion>();
	

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="ciudadano", fetch=FetchType.EAGER,cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Telefono> telefonos= new ArrayList<Telefono>();

	public Ciudadano() {
	}

	public int getIdCiudadano() {
		return this.idCiudadano;
	}

	public void setIdCiudadano(int idCiudadano) {
		this.idCiudadano = idCiudadano;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Correoelectronico> getCorreoelectronicos() {
		return this.correoelectronicos;
	}

	public void setCorreoelectronicos(List<Correoelectronico> correoelectronicos) {
		this.correoelectronicos = correoelectronicos;
	}

	public Correoelectronico addCorreoelectronico(Correoelectronico correoelectronico) {
		getCorreoelectronicos().add(correoelectronico);
		correoelectronico.setCiudadano(this);

		return correoelectronico;
	}

	public Correoelectronico removeCorreoelectronico(Correoelectronico correoelectronico) {
		getCorreoelectronicos().remove(correoelectronico);
		correoelectronico.setCiudadano(null);

		return correoelectronico;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCiudadano(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCiudadano(null);

		return direccion;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setCiudadano(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setCiudadano(null);

		return telefono;
	}

}