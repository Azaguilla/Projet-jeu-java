package Model;

import java.util.Random;

public class Vagabonder implements SeDeplacer 
{
	private Random rand = new Random();
	
	/**
	 * Le deplacement en volant
	 * @param monstre Le monstre qui se déplace
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return faux(false)
	 */
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	
	/**
	 * Le déplacement en vagabondant
	 * Le monstre avance ou recule au hasard
	 * Si le monstre a pu être ajouté sur la nouvelle case, il est supprimé de l'ancienne
	 * Sinon il reste sur la même case
	 * @param monstre Le monstre qui se déplace
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return vrai(true) s'il a pu se déplacer sur une autre case, faux(false) sinon
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
		//On empêche le monstre de sortir du plateau
		int nbCase = jeu.getCases().size();
		if(newNumCase == -1 || newNumCase == nbCase)
		{
			System.out.println("Le monstre a tenté de sortir des frontières. Heureusement, les gardes de Dar Elnor l'en ont empêché. Le monstre reste sur sa case.");
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
	 * Le déplacement en rampant
	 * @param monstre Le monstre qui se déplace
	 * @param jeu Les informations concernant l'anvancée du jeu, les monstres, les cases...
	 * @return faux(false)
	 */
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		return false;
	}
}
