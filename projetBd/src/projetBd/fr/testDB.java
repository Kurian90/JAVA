package projetBd.fr;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import projetBank.fr.banque.entities.IClient;
import projetBank.fr.banque.entities.ICompte;
import projetBank.fr.banque.entities.IOperation;

public class testDB
{

	public static void main(String[] args)
	{
		DBUtil util = new DBUtil();
		try
		{
			util.connexion();

			//authentification
			try
			{
			IClient clt = util.authentifier("df", "df");
			System.out.println(clt);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("Erreur d'authentification");
			}

			//r�cup�ration de la liste de client.
			List<IClient> listclient;
			try
			{
				listclient = util.recupererClient();
				System.out.println(listclient.toString());
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("Erreur � la r�cup�ration des Clients");
			}

			//R�cup�ration de la liste des comptes
			List<ICompte> listcomptes;
			try
			{
				listcomptes = util.recupererCompte();
				System.out.println(listcomptes.toString());
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("Erreur � la r�cup�ration des Comptes");
			}

			//R�cup�ration de la liste des op�rations
			List<IOperation> listoperation;
			try
			{
				listoperation = util.recupererOperation();
				System.out.println(listoperation.toString());
				listoperation=null;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("Erreur � la r�cup�ration des Operations");
			}

			//r�cup�ration d'un compte
			ICompte cmpt = null;
			try
			{
				cmpt = util.recupererCompteByID(3);
				if(cmpt != null)
				{
				System.out.println(cmpt.toString());
				}
				else
				{
					System.out.println("Compte non trouv�");
				}
			}
			catch (SQLException e)
			{
				System.err.println("Impossible de trouver le compte");
			}

			//Recherche d'op�ration sur un compte entre une date de d�but et  une date de fin , boolean == true => cr�dit ,null tous , faux == false
			try
			{
				Calendar cal1 = Calendar.getInstance();
				cal1.set(Calendar.YEAR, 2014);
				cal1.set(Calendar.MONTH, 12);
				cal1.set(Calendar.DAY_OF_MONTH, 15);
				Calendar cal2 = Calendar.getInstance();
				cal2.set(Calendar.YEAR, 2015);
				cal2.set(Calendar.MONTH, 12);
				cal2.set(Calendar.DAY_OF_MONTH, 15);

				listoperation = util.rechercherOperation(15,new Date(cal1.getTimeInMillis()), new Date(cal2.getTimeInMillis()), Boolean.TRUE);
				System.out.println(listoperation.toString());
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("Erreur � la recherche des operations du compte");
			}

			// Virements
			try
			{
				listoperation = util.faireVirement(13, 15, -500);
				if(listoperation != null)
				{
					System.out.println(listoperation.toString());
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("echec lors de l'op�ratiob");
			}

		}
		catch (ClassNotFoundException e)
		{
			System.err.println("Impossible de charger le driver");
		}
		catch (SQLException e)
		{
			System.err.println("Impossible d'�tablir la connexion");
		}
		finally
		{
			try
			{
				util.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("Impossible de fermer la connexion");
			}
		}

	}

}
