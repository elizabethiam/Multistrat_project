package net.example.backend.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="interni")
public class Intern {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_intern;
	
	@Column(name="nume_intern")
	private String numeIntern;
	
	@Column(name="prenume_intern")
	private String prenumeIntern;
	
	@Column(name="cnp_intern")
	private String cnpIntern;
	
	@Column(name="email_intern")
	private String emailIntern;
	
	@Column(name="telefon_intern")
	private String telefonIntern;
	
	
	@ManyToOne
	@JoinColumn(name="id_angajat", nullable= false)
	private Angajat angajat;
	
	
	@ManyToOne
	@JoinColumn(name="id_internship", nullable= false)
	private Internship internship;
	
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "intern")
	@JsonIgnore
	private Set<Beneficiu> beneficiu;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "intern")
	@JsonIgnore
	private Set<Task> task;

	
	public Intern() {
		super();
	}
	

	public Intern(long id_intern, String numeIntern, String prenumeIntern, String cnpIntern) {
		super();
		this.id_intern = id_intern;
		this.numeIntern = numeIntern;
		this.prenumeIntern = prenumeIntern;
		this.cnpIntern=cnpIntern;
	}


	public Intern(String numeIntern, String prenumeIntern, String cnpIntern, String emailIntern, String telefonIntern,
			Angajat angajat, Internship internship, Set<Beneficiu> beneficiu, Set<Task> task) {
		super();
		this.numeIntern = numeIntern;
		this.prenumeIntern = prenumeIntern;
		this.cnpIntern = cnpIntern;
		this.emailIntern = emailIntern;
		this.telefonIntern = telefonIntern;
		this.angajat = angajat;
		this.internship = internship;
		this.beneficiu = beneficiu;
		this.task = task;
	}

	public long getId_intern() {
		return id_intern;
	}

	public void setId_intern(long id_intern) {
		this.id_intern = id_intern;
	}

	public String getNumeIntern() {
		return numeIntern;
	}

	public void setNumeIntern(String numeIntern) {
		this.numeIntern = numeIntern;
	}

	public String getPrenumeIntern() {
		return prenumeIntern;
	}

	public void setPrenumeIntern(String prenumeIntern) {
		this.prenumeIntern = prenumeIntern;
	}

	public String getCnpIntern() {
		return cnpIntern;
	}

	public void setCnpIntern(String cnpIntern) {
		this.cnpIntern = cnpIntern;
	}

	public String getEmailIntern() {
		return emailIntern;
	}

	public void setEmailIntern(String emailIntern) {
		this.emailIntern = emailIntern;
	}

	public String getTelefonIntern() {
		return telefonIntern;
	}

	public void setTelefonIntern(String telefonIntern) {
		this.telefonIntern = telefonIntern;
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public Set<Beneficiu> getBeneficiu() {
		return beneficiu;
	}

	public void setBeneficiu(Set<Beneficiu> beneficiu) {
		this.beneficiu = beneficiu;
	}

	public Set<Task> getTask() {
		return task;
	}

	public void setTask(Set<Task> task) {
		this.task = task;
	}

	
	
	
	
	
}
