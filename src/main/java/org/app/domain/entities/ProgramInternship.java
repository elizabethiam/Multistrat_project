package org.app.domain.entities;

import java.util.Date;
import java.util.List;

public class ProgramInternship {

	private Integer idProgramInternship;
	private String numeInternship;
	private String descriereInternship;
	private Date dataInceput;
	private Date dataFinalizare;
	private Integer nrLocuri;
	private Angajat coordonator;
	private StatusInternship statusInternship;
	private List<Intern> interni;
	
	public enum StatusInternship {
		PROPUS, IN_EXECUTIE, ANULAT, FINALIZAT;
	}

	public ProgramInternship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgramInternship(Integer idProgramInternship, String numeInternship, String descriereInternship,
			Date dataInceput, Date dataFinalizare, Integer nrLocuri, Angajat coordonator,
			StatusInternship statusInternship, List<Intern> interni) {
		super();
		this.idProgramInternship = idProgramInternship;
		this.numeInternship = numeInternship;
		this.descriereInternship = descriereInternship;
		this.dataInceput = dataInceput;
		this.dataFinalizare = dataFinalizare;
		this.nrLocuri = nrLocuri;
		this.coordonator = coordonator;
		this.statusInternship = statusInternship;
		this.interni = interni;
	}

	public Integer getIdProgramInternship() {
		return idProgramInternship;
	}

	public void setIdProgramInternship(Integer idProgramInternship) {
		this.idProgramInternship = idProgramInternship;
	}

	public String getNumeInternship() {
		return numeInternship;
	}

	public void setNumeInternship(String numeInternship) {
		this.numeInternship = numeInternship;
	}

	public String getDescriereInternship() {
		return descriereInternship;
	}

	public void setDescriereInternship(String descriereInternship) {
		this.descriereInternship = descriereInternship;
	}

	public Date getDataInceput() {
		return dataInceput;
	}

	public void setDataInceput(Date dataInceput) {
		this.dataInceput = dataInceput;
	}

	public Date getDataFinalizare() {
		return dataFinalizare;
	}

	public void setDataFinalizare(Date dataFinalizare) {
		this.dataFinalizare = dataFinalizare;
	}

	public Integer getNrLocuri() {
		return nrLocuri;
	}

	public void setNrLocuri(Integer nrLocuri) {
		this.nrLocuri = nrLocuri;
	}

	public Angajat getCoordonator() {
		return coordonator;
	}

	public void setCoordonator(Angajat coordonator) {
		this.coordonator = coordonator;
	}

	public StatusInternship getStatusInternship() {
		return statusInternship;
	}

	public void setStatusInternship(StatusInternship statusInternship) {
		this.statusInternship = statusInternship;
	}

	public List<Intern> getInterni() {
		return interni;
	}

	public void setInterni(List<Intern> interni) {
		this.interni = interni;
	}

	
	
}

