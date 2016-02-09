package com.unipago.ciudadano.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@Table(name="direccion")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idDireccion;

	@Column(nullable=false, length=255)
	private String calle;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="idCiudad", nullable=false)
	private Ciudad ciudad;

	//bi-directional many-to-one association to Ciudadano
	@ManyToOne
	@JoinColumn(name="IdCiudadano", nullable=false)
	private Ciudadano ciudadano;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="idEstado", nullable=false)
	private Estado estado;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="idPais", nullable=false)
	private Pais pais;

	public Direccion() {
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Ciudadano getCiudadano() {
		return this.ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}