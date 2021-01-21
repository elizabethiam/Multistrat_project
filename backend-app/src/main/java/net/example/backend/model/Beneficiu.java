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
@Table(name="beneficii")
public class Beneficiu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_beneficiu;
	
	@Column(name="denumire_beneficiu")
	private String denumireBeneficiu;
	
	@Column(name="descriere_beneficiu")
	private String descriereBeneficiu;

	
	@ManyToOne
	@JoinColumn(name="id_angajat", nullable= false)
	private Angajat angajat;
	
	@ManyToOne
	@JoinColumn(name="id_intern", nullable= false)
	private Intern intern;

	
	
	public Beneficiu() {
		super();
	}

	public Beneficiu(long id_beneficiu, String denumireBeneficiu, String descriereBeneficiu) {
		super();
		this.id_beneficiu = id_beneficiu;
		this.denumireBeneficiu = denumireBeneficiu;
		this.descriereBeneficiu = descriereBeneficiu;
	}

	public Beneficiu(String denumireBeneficiu, String descriereBeneficiu, Angajat angajat, Intern intern) {
		super();
		this.denumireBeneficiu = denumireBeneficiu;
		this.descriereBeneficiu = descriereBeneficiu;
		this.angajat = angajat;
		this.intern = intern;
	}

	public long getId_beneficiu() {
		return id_beneficiu;
	}

	public void setId_beneficiu(long id_beneficiu) {
		this.id_beneficiu = id_beneficiu;
	}

	public String getDenumireBeneficiu() {
		return denumireBeneficiu;
	}

	public void setDenumireBeneficiu(String denumireBeneficiu) {
		this.denumireBeneficiu = denumireBeneficiu;
	}

	public String getDescriereBeneficiu() {
		return descriereBeneficiu;
	}

	public void setDescriereBeneficiu(String descriereBeneficiu) {
		this.descriereBeneficiu = descriereBeneficiu;
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Intern getIntern() {
		return intern;
	}

	public void setIntern(Intern intern) {
		this.intern = intern;
	}
	
	

}
