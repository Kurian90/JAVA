package projetBank.fr.banque;

public class CompteASeuil extends Compte {

	private double seuil;

	public CompteASeuil(long num,TypeCompte type){
		super(num,type);
	}
	/**
	 * @param type
	 * @param seuil
	 */
	public CompteASeuil(long num,TypeCompte type, double seuil) {
		super(num,type,0);
		this.seuil = seuil;
	}

	/**
	 * @param type
	 * @param solde
	 * @param seuil
	 */
	public CompteASeuil(long num,TypeCompte type, double solde, double seuil) {
		super(num,type, solde);
		this.seuil = seuil;
	}

	public double getSeuil() {
		return this.seuil;
	}
	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.delete(builder.length()-1, builder.length());
		builder.append(", Seuil :");
		builder.append(this.getSeuil());
		builder.append(']');
		return builder.toString();
	}
	@Override
	public void retirer(double uneValeur) {
		if(uneValeur <= this.seuil)
		{
			super.retirer(uneValeur);
		}
		else
		{
			System.err.println("Limite de retrait :" + this.seuil);
		}
	}
}
