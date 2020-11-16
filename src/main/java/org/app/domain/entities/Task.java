package org.app.domain.entities;


public class Task {

	private Integer idTask;
	private String denumireTask;
	private String descriere;
	private Intern responsabilTask;
	private Integer timpEstimat;
	private StatusTask status;
	private Cerinta cerinta;
	
	public enum StatusTask {
		IN_CURS, BLOCAT, SUSPENDAT, FINALIZAT;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Integer idTask, String denumireTask, Intern responsabilTask, Integer timpEstimat,Cerinta cerinta) {
		super();
		this.idTask = idTask;
		this.denumireTask = denumireTask;
		this.responsabilTask = responsabilTask;
		this.timpEstimat = timpEstimat;
		this.cerinta = cerinta;
	}

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public String getDenumireTask() {
		return denumireTask;
	}

	public void setDenumireTask(String denumireTask) {
		this.denumireTask = denumireTask;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public Intern getResponsabilTask() {
		return responsabilTask;
	}

	public void setResponsabilTask(Intern responsabilTask) {
		this.responsabilTask = responsabilTask;
	}

	public Integer getTimpEstimat() {
		return timpEstimat;
	}

	public void setTimpEstimat(Integer timpEstimat) {
		this.timpEstimat = timpEstimat;
	}

	public StatusTask getStatus() {
		return status;
	}

	public void setStatus(StatusTask status) {
		this.status = status;
	}

	public Cerinta getCerinta() {
		return cerinta;
	}

	public void setCerinta(Cerinta cerinta) {
		this.cerinta = cerinta;
	}

	@Override
	public String toString() {
		return "\n\t\tTask [idTask=" + idTask + ", denumireTask=" + denumireTask + ", descriere=" + descriere
				 + ", timpEstimat=" + timpEstimat + ", status=" + status + ", responsabilTask=" + responsabilTask + "]";
	}

	
	
}
