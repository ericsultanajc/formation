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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((raisonSociale == null) ? 0 : raisonSociale.hashCode());
		result = prime * result + ((siret == null) ? 0 : siret.hashCode());
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
		ClientId other = (ClientId) obj;
		if (raisonSociale == null) {
			if (other.raisonSociale != null)
				return false;
		} else if (!raisonSociale.equals(other.raisonSociale))
			return false;
		if (siret == null) {
			if (other.siret != null)
				return false;
		} else if (!siret.equals(other.siret))
			return false;
		return true;
	}

}
