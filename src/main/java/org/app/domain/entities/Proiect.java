package org.app.domain.entities;

import java.util.Date;
import java.util.List;


public class Proiect {

	private Integer idProiect;
	private String denumireProiect;
	private Date dataInceput;
	private Date dataRealese;
	private List<Cerinta> cerinte;
	private StareProiect stareProiect;
	private Angajat responasbilProiect;
	private Echipa echipa;
	private Cerinta cerintaCurenta;
	
	public enum StareProiect {
		PROPUS, IN_EXECUTIE, ABANDONAT, FINALIZAT;
	}

	public Proiect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proiect(Integer idProiect, String denumireProiect, Date dataInceput) {
		super();
		this.idProiect = idProiect;
		this.denumireProiect = denumireProiect;
		this.dataInceput = dataInceput;
	}

	public Integer getIdProiect() {
		return idProiect;
	}

	public void setIdProiect(Integer idProiect) {
		this.idProiect = idProiect;
	}

	public String getDenumireProiect() {
		return denumireProiect;
	}

	public void setDenumireProiect(String denumireProiect) {
		this.denumireProiect = denumireProiect;
	}

	public Date getDataInceput() {
		return dataInceput;
	}

	public void setDataInceput(Date dataInceput) {
		this.dataInceput = dataInceput;
	}

	public Date getDataRealese() {
		return dataRealese;
	}

	public void setDataRealese(Date dataRealese) {
		this.dataRealese = dataRealese;
	}

	public List<Cerinta> getCerinte() {
		return cerinte;
	}

	public void setCerinte(List<Cerinta> cerinte) {
		this.cerinte = cerinte;
	}

	public StareProiect getStareProiect() {
		return stareProiect;
	}

	public void setStareProiect(StareProiect stareProiect) {
		this.stareProiect = stareProiect;
	}

	public Angajat getResponasbilProiect() {
		return responasbilProiect;
	}

	public void setResponasbilProiect(Angajat responasbilProiect) {
		this.responasbilProiect = responasbilProiect;
	}

	public Echipa getEchipa() {
		return echipa;
	}

	public void setEchipa(Echipa echipa) {
		this.echipa = echipa;
	}

	public Cerinta getCerintaCurenta() {
		return cerintaCurenta;
	}

	public void setCerintaCurenta(Cerinta cerintaCurenta) {
		this.cerintaCurenta = cerintaCurenta;
	}

	@Override
	public String toString() {
		return "\nProiect [idProiect=" + idProiect + ", denumireProiect=" + denumireProiect + ", dataInceput="
				+ dataInceput + ", cerinte=" + cerinte + "]";
	}

	
	
	
}
