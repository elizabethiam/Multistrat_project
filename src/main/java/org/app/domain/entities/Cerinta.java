package org.app.domain.entities;

import java.util.List;

public class Cerinta {

	private Integer idCerinta;
	private String denumireCerinta;

	private List<Task> taskuri;
	private Proiect proiect;
	
	public Cerinta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cerinta(Integer idCerinta, String denumireCerinta, Proiect proiect) {
		super();
		this.idCerinta = idCerinta;
		this.denumireCerinta = denumireCerinta;
		this.proiect = proiect;
	}
	
	public Cerinta(Integer idCerinta, String denumireCerinta, List<Task> taskuri, Proiect proiect) {
		super();
		this.idCerinta = idCerinta;
		this.denumireCerinta = denumireCerinta;
		this.taskuri = taskuri;
		this.proiect = proiect;
	}

	public Integer getIdCerinta() {
		return idCerinta;
	}
	
	public void setIdCerinta(Integer idCerinta) {
		this.idCerinta = idCerinta;
	}
	
	public String getDenumireCerinta() {
		return denumireCerinta;
	}
	
	public void setDenumireCerinta(String denumireCerinta) {
		this.denumireCerinta = denumireCerinta;
	}
	
	public List<Task> getTaskuri() {
		return taskuri;
	}
	
	public void setTaskuri(List<Task> taskuri) {
		this.taskuri = taskuri;
	}
	
	public Proiect getProiect() {
		return proiect;
	}
	
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCerinta == null) ? 0 : idCerinta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerinta other = (Cerinta) obj;
		if (idCerinta == null) {
			if (other.idCerinta != null)
				return false;
		} else if (!idCerinta.equals(other.idCerinta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n\tCerinta [idCerinta=" + idCerinta + ", denumireCerinta=" + denumireCerinta + ", \ttaskuri=" + taskuri
				+ "]";
	}

	
}
