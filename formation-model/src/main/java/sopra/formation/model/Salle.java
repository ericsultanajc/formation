package sopra.formation.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "room")
public class Salle {
	@EmbeddedId
	private SalleId id;
	@Version
	private int version;
	private int capacite;
	@OneToOne(mappedBy = "salle", fetch=FetchType.LAZY)
	private Formation formation;

	public Salle() {
		super();
	}

	public Salle(String nom, String lieu, int capacite) {
		super();
		this.id = new SalleId(nom, lieu);
		this.capacite = capacite;
	}

	public SalleId getId() {
		return id;
	}

	public void setId(SalleId id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

}
