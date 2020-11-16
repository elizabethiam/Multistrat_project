package org.app.domain.entities;

import java.util.List;


public class Echipa {

	private Integer idEchipa;
	private String departament;
	private List<Angajat> angajati;
	private List<Intern> interni;
	private Angajat liderEchipa;
	
	public Echipa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Echipa(Integer idEchipa, String departament) {
		super();
		this.idEchipa = idEchipa;
		this.departament = departament;
	}
	
	public Integer getIdEchipa() {
		return idEchipa;
	}
	
	public void setIdEchipa(Integer idEchipa) {
		this.idEchipa = idEchipa;
	}
	
	public String getDepartament() {
		return departament;
	}
	
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	
	public List<Angajat> getAngajati() {
		return angajati;
	}
	
	public void setAngajati(List<Angajat> angajati) {
		this.angajati = angajati;
	}
	
	public List<Intern> getInterni() {
		return interni;
	}
	
	public void setInterni(List<Intern> interni) {
		this.interni = interni;
	}
	
	public Angajat getLiderEchipa() {
		return liderEchipa;
	}
	
	public void setLiderEchipa(Angajat liderEchipa) {
		this.liderEchipa = liderEchipa;
	}
	
}
