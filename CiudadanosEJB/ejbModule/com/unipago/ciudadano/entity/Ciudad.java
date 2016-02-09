package com.unipago.ciudadano.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@Table(name="ciudad")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idCiudad;

	@Column(nullable=false, length=20)
	private String nombre;
	
	@OneToMany(mappedBy="ciudad",cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Estado> estados = new ArrayList<Estado>();
	

	//bi-directional many-to-one association to Direccion
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true,mappedBy="ciudad", fetch=FetchType.EAGER)
	private List<Direccion> direccions=new ArrayList<>();

	public Ciudad() {
	}

	public int getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCiudad(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCiudad(null);

		return direccion;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	

}