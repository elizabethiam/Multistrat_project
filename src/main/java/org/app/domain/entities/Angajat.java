package org.app.domain.entities;

import java.util.Date;


public class Angajat {

	private Integer idAngajat;
	private String numePrenume;
	private String cnp;
	private Date dataAngajare;
	private String departament; 
	private Rol rol;

	public enum Rol {
		ANALIST, TESTER, DEVELOPER, MANAGER, PRODUCT_OWNER;
	}

	public Angajat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Angajat(Integer idAngajat, String numePrenume, String cnp, Date dataAngajare, String departament, Rol rol) {
		super();
		this.idAngajat = idAngajat;
		this.numePrenume = numePrenume;
		this.cnp = cnp;
		this.dataAngajare = dataAngajare;
		this.departament = departament;
		this.rol = rol;
	}

	public Integer getIdAngajat() {
		return idAngajat;
	}

	public void setIdAngajat(Integer idAngajat) {
		this.idAngajat = idAngajat;
	}

	public String getNumePrenume() {
		return numePrenume;
	}

	public void setNumePrenume(String numePrenume) {
		this.numePrenume = numePrenume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Date getDataAngajare() {
		return dataAngajare;
	}

	public void setDataAngajare(Date dataAngajare) {
		this.dataAngajare = dataAngajare;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
}
