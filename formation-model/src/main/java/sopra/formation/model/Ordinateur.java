package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "computer")
public class Ordinateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 10, unique = true)
	private String code;
	@Column(name = "brand", length = 100)
	private String marque;
	private int ram;
	private boolean ssd;
	@OneToOne(mappedBy = "ordinateur", fetch=FetchType.LAZY)
	private Eleve eleve;

	public Ordinateur() {
		super();
	}

	public Ordinateur(String code, String marque, int ram, boolean ssd) {
		super();
		this.code = code;
		this.marque = marque;
		this.ram = ram;
		this.ssd = ssd;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public boolean isSsd() {
		return ssd;
	}

	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	@Override
	public String toString() {
		return "Ordinateur [code=" + code + ", marque=" + marque + ", ram=" + ram + ", ssd=" + ssd + "]";
	}

}
