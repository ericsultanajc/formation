package sopra.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SalleId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "name")
	private String nom;
	@Column(name = "place")
	private String lieu;

	public SalleId() {
		super();
	}

	public SalleId(String nom, String lieu) {
		super();
		this.nom = nom;
		this.lieu = lieu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

}
