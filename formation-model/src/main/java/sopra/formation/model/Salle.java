package sopra.formation.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views.ViewCommon;
import sopra.formation.model.Views.ViewSalleWithFormation;

@Entity
@Table(name = "room")
public class Salle {
	@EmbeddedId
	@JsonView(ViewCommon.class)
	private SalleId id;
	@Version
	@JsonView(ViewCommon.class)
	private int version;
	@JsonView(ViewCommon.class)
	private int capacite;
	@OneToOne(mappedBy = "salle", fetch = FetchType.LAZY)
	@JsonView(ViewSalleWithFormation.class)
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
