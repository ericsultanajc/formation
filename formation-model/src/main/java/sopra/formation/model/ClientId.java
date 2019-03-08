package sopra.formation.model;

import java.io.Serializable;

public class ClientId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String siret;
	private String raisonSociale;

	public ClientId() {
		super();
	}

	public ClientId(String siret, String raisonSociale) {
		super();
		this.siret = siret;
		this.raisonSociale = raisonSociale;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

}
