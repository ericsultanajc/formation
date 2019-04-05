package sopra.formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views.ViewCommon;

@Embeddable
public class SalleId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "name")
	@JsonView(ViewCommon.class)
	private String nom;
	@Column(name = "place")
	@JsonView(ViewCommon.class)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		SalleId other = (SalleId) obj;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
