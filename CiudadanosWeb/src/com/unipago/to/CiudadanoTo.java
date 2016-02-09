package com.unipago.to;

import java.util.Date;

public class CiudadanoTo {
	
		public CiudadanoTo() {
		}

		private int idCiudadano;

		private String apellido;

		private Date fechaNacimiento;

		private String nombre;
		
		private String sexo;

		private String correoelectronico;

		private String calle;
		
		private int telefonos;
		
		private String Pais;
		
		private String Estado;
		
		private String Ciudad;

		public int getIdCiudadano() {
			return idCiudadano;
		}

		public void setIdCiudadano(int idCiudadano) {
			this.idCiudadano = idCiudadano;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public String getCorreoelectronico() {
			return correoelectronico;
		}

		public void setCorreoelectronico(String correoelectronico) {
			this.correoelectronico = correoelectronico;
		}

		public String getCalle() {
			return calle;
		}

		public void setCalle(String calle) {
			this.calle = calle;
		}

		

		public int getTelefonos() {
			return telefonos;
		}

		public void setTelefonos(int telefonos) {
			this.telefonos = telefonos;
		}

		public String getPais() {
			return Pais;
		}

		public void setPais(String pais) {
			Pais = pais;
		}

		public String getEstado() {
			return Estado;
		}

		public void setEstado(String estado) {
			Estado = estado;
		}

		public String getCiudad() {
			return Ciudad;
		}

		public void setCiudad(String ciudad) {
			Ciudad = ciudad;
		}
		

}
