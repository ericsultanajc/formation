package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name = "street", length = 100)
	private String rue;
	@Column(name = "zipcode", length = 10)
	private String codePostal;
	@Column(name = "city", length = 100)
	private String ville;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
