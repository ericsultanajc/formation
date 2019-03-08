package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Eleve extends Personne {
	private int age;
	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	private Date dtNaissance;
	@OneToMany(mappedBy = "eleve")
	private List<EleveFormateur> formateurs = new ArrayList<EleveFormateur>();
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "computer_id")
	private Ordinateur ordinateur;

	public Eleve() {
		super();
	}

	public Eleve(String nom, String prenom, int age) {
		super(nom, prenom);
		this.age = age;
	}

	public Eleve(Long id, String nom, String prenom, int age) {
		super(id, nom, prenom);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public List<EleveFormateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<EleveFormateur> formateurs) {
		this.formateurs = formateurs;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

}
