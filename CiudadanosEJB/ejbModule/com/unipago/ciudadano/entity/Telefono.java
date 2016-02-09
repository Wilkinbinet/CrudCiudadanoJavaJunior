package com.unipago.ciudadano.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefono database table.
 * 
 */
@Entity
@Table(name="telefono")
@NamedQuery(name="Telefono.findAll", query="SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int numero;

	//bi-directional many-to-one association to Ciudadano
	@ManyToOne
	@JoinColumn(name="idCiudadano", nullable=false)
	private Ciudadano ciudadano;

	//bi-directional many-to-one association to Tipotlfn
	@ManyToOne
	@JoinColumn(name="idTipo", nullable=false)
	private Tipotlfn tipotlfn;

	public Telefono() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Ciudadano getCiudadano() {
		return this.ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Tipotlfn getTipotlfn() {
		return this.tipotlfn;
	}

	public void setTipotlfn(Tipotlfn tipotlfn) {
		this.tipotlfn = tipotlfn;
	}

}