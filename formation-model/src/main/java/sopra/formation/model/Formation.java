package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views.ViewCommon;
import sopra.formation.model.Views.ViewFormation;
import sopra.formation.model.Views.ViewFormationWithClient;

@Entity
@Table(name = "training")
public class Formation {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(name = "plan", length = 5)
	@JsonView(ViewCommon.class)
	private Dispositif dispositif;
	@Column(name = "title", length = 100)
	@NotEmpty(message = "L'intitule est obligatoire")
	@Size(min = 3, max=100, message="L'intitule doit comprendre au minimum 3 caractères (100 max)")
	@JsonView(ViewCommon.class)
	private String intitule;
	@Column(name = "promotion", length = 100)
	@JsonView(ViewCommon.class)
	private String promotion;
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	@JsonView(ViewCommon.class)
	private Date dtDebut;
	@OneToMany(mappedBy = "formation")
	private List<Personne> personnes = new ArrayList<Personne>();
	@OneToOne
	@JoinColumns({ @JoinColumn(name = "room_name", referencedColumnName = "name"),
			@JoinColumn(name = "room_place", referencedColumnName = "place") })
	@JsonView(ViewFormation.class)
	private Salle salle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "customer_siret", referencedColumnName = "siret"),
			@JoinColumn(name = "customer_company_name", referencedColumnName = "company_name") })
	@JsonView(ViewFormationWithClient.class)
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

	public Dispositif getDispositif() {
		return dispositif;
	}

	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
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
