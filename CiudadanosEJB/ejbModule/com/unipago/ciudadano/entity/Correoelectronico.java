package com.unipago.ciudadano.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the correoelectronico database table.
 * 
 */
@Entity
@Table(name="correoelectronico")
@NamedQuery(name="Correoelectronico.findAll", query="SELECT c FROM Correoelectronico c")
public class Correoelectronico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idCorreo;

	@Column(nullable=false, length=255)
	private String direccion;

	//bi-directional many-to-one association to Ciudadano
	@ManyToOne
	@JoinColumn(name="idCiudadano", nullable=false)
	private Ciudadano ciudadano;

	public Correoelectronico() {
	}

	public int getIdCorreo() {
		return this.idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ciudadano getCiudadano() {
		return this.ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

}