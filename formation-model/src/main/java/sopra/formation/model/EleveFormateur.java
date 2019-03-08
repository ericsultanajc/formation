package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "student_teacher")
public class EleveFormateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Eleve eleve;
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Formateur formateur;
	@Column(name = "grade")
	private int note;

	public EleveFormateur() {
		super();
	}

	public EleveFormateur(Eleve eleve, Formateur formateur) {
		super();
		this.eleve = eleve;
		this.formateur = formateur;
	}

	public EleveFormateur(Eleve eleve, Formateur formateur, int note) {
		super();
		this.eleve = eleve;
		this.formateur = formateur;
		this.note = note;
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

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

}
