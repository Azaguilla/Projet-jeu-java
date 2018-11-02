package Model;

import java.util.Random;

public class Vagabonder implements SeDeplacer 
{
	private Random rand = new Random();
	
	/**
	 * Le deplacement en volant
	 * @param monstre Le monstre qui se d�place
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return faux(false)
	 */
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	
	/**
	 * Le d�placement en vagabondant
	 * Le monstre avance ou recule au hasard
	 * Si le monstre a pu �tre ajout� sur la nouvelle case, il est supprim� de l'ancienne
	 * Sinon il reste sur la m�me case
	 * @param monstre Le monstre qui se d�place
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return vrai(true) s'il a pu se d�placer sur une autre case, faux(false) sinon
	 */
	public boolean vagabonder(Monstre monstre, Jeu jeu)
	{
		int numCase = monstre.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		int n = rand.nextInt(2);
		int newNumCase = laCase.getNumCase();
		switch (n)
		{
			/*case 0 = recule*/
			case 0: newNumCase = laCase.getNumCase()-1;
			System.out.println("Le monstre "+monstre.getNom()+" recule d'une case.");
					break;
			/*case 2 = avance*/
			case 1: newNumCase = laCase.getNumCase()+1;
					break;
		}
		//On emp�che le monstre de sortir du plateau
		int nbCase = jeu.getCases().size();
		if(newNumCase == -1 || newNumCase == nbCase)
		{
			System.out.println("Le monstre a tent� de sortir des fronti�res. Heureusement, les gardes de Dar Elnor l'en ont emp�ch�. Le monstre reste sur sa case.");
			return false;
		}
		else
		{
			Case newCase = jeu.recupererCase(newNumCase);
			if (newCase.ajoutMonstre(monstre))
			{
				laCase.SuppMonstre(monstre);
				System.out.println("Le monstre "+monstre.getNom()+"  vagabonde vers la case "+newNumCase);
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Le d�placement en rampant
	 * @param monstre Le monstre qui se d�place
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return faux(false)
	 */
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		return false;
	}
}
