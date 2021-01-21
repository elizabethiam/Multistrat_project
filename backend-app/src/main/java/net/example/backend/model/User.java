package net.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="useri")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_user;
	
	@Column(name="username")
	private String username;
	
	@Column(name="parola")
	private String parola;
	
	@OneToOne
	@JoinColumn(name="id_angajat", nullable=false)
	private Angajat angajat;

	
	public User() {
		super();
	}

	public User(String username, String parola, Angajat angajat) {
		super();
		this.username = username;
		this.parola = parola;
		this.angajat = angajat;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	


	
}
