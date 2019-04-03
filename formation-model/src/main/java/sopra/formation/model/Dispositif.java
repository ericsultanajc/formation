package sopra.formation.model;

public enum Dispositif {
	CPRO("Contrat de Professionnalisation"), POEI("Préparation Opérationnelle à l'Emploi Individuelle"),
	POEC("Préparation Opérationnelle à l'Emploi Collective");

	private final String label;

	private Dispositif(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
