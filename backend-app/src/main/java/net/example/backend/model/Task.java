package net.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="taskuri")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_task;
	
	@Column(name="denumire_task")
	private String denumireTask;
	
	@Column(name="descriere_task")
	private String descriereTask;

	
	@ManyToOne
	@JoinColumn(name="id_intern")
	private Intern intern;
	
	

	public Task() {
		super();
	}
	

	public Task(long id_task, String denumireTask, String descriereTask) {
		super();
		this.id_task = id_task;
		this.denumireTask = denumireTask;
		this.descriereTask = descriereTask;
	}


	public Task(String denumireTask, String descriereTask, Intern intern) {
		super();
		this.denumireTask = denumireTask;
		this.descriereTask = descriereTask;
		this.intern = intern;
	}

	public long getId_task() {
		return id_task;
	}

	public void setId_task(long id_task) {
		this.id_task = id_task;
	}

	public String getDenumireTask() {
		return denumireTask;
	}

	public void setDenumireTask(String denumireTask) {
		this.denumireTask = denumireTask;
	}

	public String getDescriereTask() {
		return descriereTask;
	}

	public void setDescriereTask(String descriereTask) {
		this.descriereTask = descriereTask;
	}

	public Intern getIntern() {
		return intern;
	}

	public void setIntern(Intern intern) {
		this.intern = intern;
	}
	
	
}
