package com.unipago.ciudadano.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the tipotlfn database table.
 * 
 */
@Entity
@Table(name="tipotlfn")
@NamedQuery(name="Tipotlfn.findAll", query="SELECT t FROM Tipotlfn t")
public class Tipotlfn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTipoTlfn;

	@Column(length=10)
	private String nombreTipo;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="tipotlfn", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Telefono> telefonos = new ArrayList<Telefono>();

	public Tipotlfn() {
	}

	public int getIdTipoTlfn() {
		return this.idTipoTlfn;
	}

	public void setIdTipoTlfn(int idTipoTlfn) {
		this.idTipoTlfn = idTipoTlfn;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setTipotlfn(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setTipotlfn(null);

		return telefono;
	}

}