package net.example.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="angajati")
public class Angajat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_angajat;
	
	@Column(name="nume_angajat")
	private String numeAngajat;
	
	@Column(name="prenume_angajat")
	private String prenumeAngajat;
	
	@Column(name="cnp_angajat")
	private String cnpAngajat;
	
	@Column(name="email_angajat")
	private String emailAngajat;
	
	@Column(name="telefon_angajat")
	private String telefonAngajat;
	
	@Column(name="departament_angajat")
	private String departamentAngajat;
	
	@OneToOne(cascade =  CascadeType.ALL, mappedBy = "angajat")
	@JsonIgnore
	private User user;
	
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "angajat")
	@JsonIgnore
	private Set<Intern> intern;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "angajat")
	@JsonIgnore
	private Set<Internship> internship;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "angajat")
	@JsonIgnore
	private Set<Beneficiu> beneficiu;
	
	
	public Angajat() {
		super();
	}
	

	public Angajat(long id_angajat, String numeAngajat, String prenumeAngajat, String cnpAngajat) {
		super();
		this.id_angajat = id_angajat;
		this.numeAngajat = numeAngajat;
		this.prenumeAngajat = prenumeAngajat;
		this.cnpAngajat = cnpAngajat;
	}


	public Angajat(String numeAngajat, String prenumeAngajat, String cnpAngajat, String emailAngajat,
			String telefonAngajat, String departamentAngajat, User user, Set<Intern> intern, Set<Internship> internship,
			Set<Beneficiu> beneficiu) {
		super();
		
		this.numeAngajat = numeAngajat;
		this.prenumeAngajat = prenumeAngajat;
		this.cnpAngajat = cnpAngajat;
		this.emailAngajat = emailAngajat;
		this.telefonAngajat = telefonAngajat;
		this.departamentAngajat = departamentAngajat;
		this.user = user;
		this.intern = intern;
		this.internship = internship;
		this.beneficiu = beneficiu;
	}

	public long getId_angajat() {
		return id_angajat;
	}

	public void setId_angajat(long id_angajat) {
		this.id_angajat = id_angajat;
	}

	public String getNumeAngajat() {
		return numeAngajat;
	}

	public void setNumeAngajat(String numeAngajat) {
		this.numeAngajat = numeAngajat;
	}

	public String getPrenumeAngajat() {
		return prenumeAngajat;
	}

	public void setPrenumeAngajat(String prenumeAngajat) {
		this.prenumeAngajat = prenumeAngajat;
	}

	public String getCnpAngajat() {
		return cnpAngajat;
	}

	public void setCnpAngajat(String cnpAngajat) {
		this.cnpAngajat = cnpAngajat;
	}

	public String getEmailAngajat() {
		return emailAngajat;
	}

	public void setEmailAngajat(String emailAngajat) {
		this.emailAngajat = emailAngajat;
	}

	public String getTelefonAngajat() {
		return telefonAngajat;
	}

	public void setTelefonAngajat(String telefonAngajat) {
		this.telefonAngajat = telefonAngajat;
	}

	public String getDepartamentAngajat() {
		return departamentAngajat;
	}

	public void setDepartamentAngajat(String departamentAngajat) {
		this.departamentAngajat = departamentAngajat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Intern> getIntern() {
		return intern;
	}

	public void setIntern(Set<Intern> intern) {
		this.intern = intern;
	}

	public Set<Internship> getInternship() {
		return internship;
	}

	

	public void setInternship(Set<Internship> internship) {
		this.internship = internship;
	}

	public Set<Beneficiu> getBeneficiu() {
		return beneficiu;
	}

	public void setBeneficiu(Set<Beneficiu> beneficiu) {
		this.beneficiu = beneficiu;
	}
	
	
	

}
