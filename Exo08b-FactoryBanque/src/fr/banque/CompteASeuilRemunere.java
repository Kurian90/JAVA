/**
 * Copyright : Ferret Renaud 2002 <br/>
 *
 * @version 1.0<br/>
 */
package fr.banque;

/**
 * Ceci est la classe Compte A seuil remunere. <br/>
 * On a choisit ici de prendre comme parent le CompteRemunere. Ce choix est base
 * sur le fait que c'est la classe qui a le plus de code. Ce qui nous fait le
 * moins de choses a recopier.
 */
class CompteASeuilRemunere extends CompteRemunere implements
ICompteASeuilRemunere {

	private double seuil;

	/**
	 * Constructeur. <br/>
	 * Le seuil par defaut est de 0
	 */
	public CompteASeuilRemunere() {
		this(-1, 0, 0, 0);
	}

	public CompteASeuilRemunere(int unNumero) {
		this(unNumero, 0d, 0d, 0d);
	}

	/**
	 * Constructeur de l'objet. <br>
	 *
	 * @param unNumero
	 *            le numero du compte
	 * @param unSoldeInitial
	 *            le solde initial du compte
	 * @param unTaux
	 *            un taux [0, 1[
	 * @param unSeuil
	 *            un seuil
	 */
	public CompteASeuilRemunere(int unNumero, double unSoldeInitial,
			double unTaux, double unSeuil) {
		super(unNumero, unSoldeInitial, unTaux);
		this.setSeuil(unSeuil);
	}

	@Override
	public double getSeuil() {
		return this.seuil;
	}

	@Override
	public void setSeuil(double unSeuil) {
		this.seuil = unSeuil;
	}

	@Override
	public String toString() {
		return super.toString() + " Seuil=" + this.getSeuil();
	}

	@Override
	public void retirer(double unMontant) {
		double simu = this.getSolde() - unMontant;
		if (simu <= this.getSeuil()) {
			// Pas bon, on ne fait rien, pour l'instant
		} else {
			super.retirer(unMontant);
		}
	}
}
