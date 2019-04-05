package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject")
@NamedQueries({ @NamedQuery(name = "Matiere.findAllByNom", query = "select m from Matiere m where m.nom = :leNom"),
		@NamedQuery(name = "Matiere.findAllByDuree", query = "select m from Matiere m where m.duree = :laDuree") })
public class Matiere {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "name", length = 100)
	@NotEmpty(message="Le nom est obligatoire")
	private String nom;
	@Column(name = "duration")
	private int duree;
	@ManyToMany(mappedBy = "matieres")
	@JsonIgnore
	private List<Formateur> formateurs = new ArrayList<Formateur>();

	public Matiere() {
		super();
	}

	public Matiere(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}

	public Matiere(Long id, String nom, int duree) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public void addFormateur(Formateur formateur) {
		this.formateurs.add(formateur);
	}

	public void removeFormateur(Formateur formateur) {
		this.formateurs.remove(formateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", duree=" + duree + ", formateurs=" + formateurs + "]";
	}

}
