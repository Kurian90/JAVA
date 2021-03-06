package projetBank.fr.banque.entities;

import projetBank.fr.banque.BanqueException;

public class Compte implements ICompte, Comparable<ICompte>
{

	private Long numero;
	private TypeCompte type;
	private String libelle;
	private Double solde;

	public Compte(Long num)
	{
		this(num, "", new Double(100));
	}

	public Compte(Long num, String type)
	{
		this(num, type, new Double(100));
	}

	public Compte(Long num, String label, Double solde)
	{
		this.setLibelle(label);
		this.setSolde(solde);
		this.numero = num;
	}

	@Override
	public void ajouter(Double unMontant)
	{
		this.setSolde(Double.valueOf(this.getSolde().doubleValue() + unMontant.doubleValue()));
	}

	@Override
	public void retirer(Double unMontant) throws BanqueException
	{

		this.setSolde(Double.valueOf(this.getSolde().doubleValue() - unMontant.doubleValue()));
	}

	@Override
	public int compareTo(ICompte o)
	{
		if (this.getNumero().longValue() < o.getNumero().longValue())
		{
			return -1;
		}
		else if (this.getNumero().longValue() > o.getNumero().longValue())
		{
			return 1;
		}
		return 0;
	}

	@Override
	public Long getNumero()
	{
		return this.numero;
	}

	@Override
	public void setNumero(Long id)
	{
		this.numero = id;
	}

	@Override
	public TypeCompte getType()
	{
		return this.type;
	}

	@Override
	public Double getSolde()
	{
		return this.solde;
	}

	private void setSolde(Double solde)
	{
		this.solde = solde;
	}

	@Override
	public String getLibelle()
	{
		return this.libelle;
	}

	@Override
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getName());
		builder.append(" [");
		builder.append("Numero compte = ");
		builder.append(this.getNumero());
		if (this.type != null)
		{
			builder.append(", type=");
			builder.append(this.type);
		}
		builder.append(", solde=");
		builder.append(this.solde);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (obj == this)
		{
			return true;
		}
		if (obj instanceof Compte)
		{
			Compte cTmp = (Compte) obj;
			return cTmp.getNumero() == this.getNumero();
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		String b = this.getClass().getName() + "_" + this.toString();
		return b.hashCode();
	}

}
