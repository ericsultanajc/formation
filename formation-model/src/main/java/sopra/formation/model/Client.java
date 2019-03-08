package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "customer")
@IdClass(ClientId.class)
public class Client {
	@Id
	private String siret;
	@Id
	@Column(name = "company_name")
	private String raisonSociale;
	@Version
	private int version;
	@Column(name = "legal_status", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private StatutJuridique statutJuridique;
	@Column(name = "create_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreation = new Date();
	@OneToMany(mappedBy = "client")
	private List<Formation> formations = new ArrayList<Formation>();

	public Client() {
		super();
	}

	public Client(String siret, String raisonSociale, StatutJuridique statutJuridique) {
		super();
		this.siret = siret;
		this.raisonSociale = raisonSociale;
		this.statutJuridique = statutJuridique;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	public StatutJuridique getStatutJuridique() {
		return statutJuridique;
	}

	public void setStatutJuridique(StatutJuridique statutJuridique) {
		this.statutJuridique = statutJuridique;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

}
