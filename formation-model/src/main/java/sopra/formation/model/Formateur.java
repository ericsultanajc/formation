package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "teacher")
public class Formateur extends Personne {
	private int exp;
	@OneToMany(mappedBy = "formateur")
	private List<EleveFormateur> eleves = new ArrayList<EleveFormateur>();
	@ManyToMany
	@JoinTable(name = "teacher_subject", uniqueConstraints = @UniqueConstraint(columnNames = { "teacher_id",
			"subject_id" }), joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private List<Matiere> matieres = new ArrayList<Matiere>();

	public Formateur() {
		super();
	}

	public Formateur(String nom, String prenom, int exp) {
		super(nom, prenom);
		this.exp = exp;
	}

	public Formateur(Long id, String nom, String prenom, int exp) {
		super(id, nom, prenom);
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public List<EleveFormateur> getEleves() {
		return eleves;
	}

	public void setEleves(List<EleveFormateur> eleves) {
		this.eleves = eleves;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public void addMatiere(Matiere matiere) {
		this.matieres.add(matiere);
	}

	public void removeMatiere(Matiere matiere) {
		this.matieres.remove(matiere);
	}

	@Override
	public String toString() {
		return "Formateur [exp=" + exp + ", toString()=" + super.toString() + "]";
	}

}
