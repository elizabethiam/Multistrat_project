package net.example.backend.model;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="internships")
public class Internship {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_internship;
	
	@Column(name="denumire_internship")
	private String denumireInternship;
	
	@Column(name="descriere_internship")
	private String descriereInternship;
	
	@Column(name="data_inceput_internship")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataInceputInternship;
	
	@Column(name="data_sfarsit_internship")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataSfarsitInternship;
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "internship")
	@JsonIgnore
	private Set<Intern> intern;
	
	@ManyToOne
	@JoinColumn(name="id_angajat", nullable= false)
	private Angajat angajat;
	
	

	public Internship() {
		super();
	}

	

	public Internship(long id_internship, String denumireInternship, String descriereInternship) {
		super();
		this.id_internship = id_internship;
		this.denumireInternship = denumireInternship;
		this.descriereInternship = descriereInternship;
	}



	public Internship(long id_internship, String denumireInternship, String descriereInternship,
			Date dataInceputInternship, Date dataSfarsitInternship, Set<Intern> intern, Angajat angajat) {
		super();
		this.id_internship = id_internship;
		this.denumireInternship = denumireInternship;
		this.descriereInternship = descriereInternship;
		this.dataInceputInternship = dataInceputInternship;
		this.dataSfarsitInternship = dataSfarsitInternship;
		this.intern = intern;
		this.angajat = angajat;
	}



	public long getId_internship() {
		return id_internship;
	}

	public void setId_internship(long id_internship) {
		this.id_internship = id_internship;
	}

	public String getDenumireInternship() {
		return denumireInternship;
	}

	public void setDenumireInternship(String denumireInternship) {
		this.denumireInternship = denumireInternship;
	}

	public String getDescriereInternship() {
		return descriereInternship;
	}

	public void setDescriereInternship(String descriereInternship) {
		this.descriereInternship = descriereInternship;
	}

	public Date getDataInceputInternship() {
		return dataInceputInternship;
	}

	public void setDataInceputInternship(Date dataInceputInternship) {
		this.dataInceputInternship = dataInceputInternship;
	}

	public Date getDataSfarsitInternship() {
		return dataSfarsitInternship;
	}

	public void setDataSfarsitInternship(Date dataSfarsitInternship) {
		this.dataSfarsitInternship = dataSfarsitInternship;
	}

	public Set<Intern> getIntern() {
		return intern;
	}

	public void setIntern(Set<Intern> intern) {
		this.intern = intern;
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	
}
