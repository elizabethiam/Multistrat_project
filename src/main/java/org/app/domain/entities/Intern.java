package org.app.domain.entities;

public class Intern {

	private Integer idIntern;
	private String numePrenume;
	private String cnp;
	private String email;
	private String telefon;
	private Echipa echipa;
	private ProgramInternship programInternship;
	
	public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Intern(Integer idIntern, String numePrenume, Echipa echipa) {
		super();
		this.idIntern = idIntern;
		this.numePrenume = numePrenume;
		this.echipa = echipa;
	}

	public Integer getIdIntern() {
		return idIntern;
	}
	
	public void setIdIntern(Integer idIntern) {
		this.idIntern = idIntern;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public Echipa getEchipa() {
		return echipa;
	}
	
	public void setEchipa(Echipa echipa) {
		this.echipa = echipa;
	}
	
	public ProgramInternship getProgramInternship() {
		return programInternship;
	}
	
	public void setProgramInternship(ProgramInternship programInternship) {
		this.programInternship = programInternship;
	}


	@Override
	public String toString() {
		return "\n\t\t\tIntern [idIntern=" + idIntern + ", numePrenume=" + numePrenume + ", echipa=" + echipa.getDepartament() + "]";
	}

	

}
