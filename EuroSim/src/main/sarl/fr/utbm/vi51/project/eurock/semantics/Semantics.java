package fr.utbm.vi51.project.eurock.semantics;

public abstract class Semantics {

	String nom;

	
	public Semantics(String nom) {
		this.nom = nom;
	}


	public String getNom() {
		return nom;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNom();
	}

}
