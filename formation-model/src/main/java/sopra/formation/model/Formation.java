package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "training")
public class Formation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "title", length = 100)
	private String intitule;
	@Column(name = "promotion", length = 100)
	private String promotion;
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date dtDebut;
	@OneToMany(mappedBy = "formation")
	private List<Personne> personnes = new ArrayList<Personne>();
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "room_name", referencedColumnName = "name"),
			@JoinColumn(name = "room_place", referencedColumnName = "place") })
	private Salle salle;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "customer_siret", referencedColumnName = "siret"),
			@JoinColumn(name = "customer_company_name", referencedColumnName = "company_name") })
	private Client client;

	public Formation() {
		super();
	}

	public Formation(String intitule, String promotion, Date dtDebut) {
		super();
		this.intitule = intitule;
		this.promotion = promotion;
		this.dtDebut = dtDebut;
	}

	public Formation(Long id, String intitule, String promotion, Date dtDebut) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.promotion = promotion;
		this.dtDebut = dtDebut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
