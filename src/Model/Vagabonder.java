package Model;

import java.util.Random;

public class Vagabonder implements SeDeplacer {
	private Random rand = new Random();
	
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		return false;
	}
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
		Case newCase = jeu.recupererCase(newNumCase);
		
		//On emp�che le monstre de sortir du plateau
		int nbCase = jeu.getCases().size();
		if(newCase.getNumCase() == -1 || newCase.getNumCase() == nbCase)
		{
			System.out.println("Le monstre a tent� de sortir des fronti�res. Heureusement, les gardes de Dar Elnor l'en ont emp�ch�. Le monstre reste sur sa case.");
			return false;
		}
		else
		{
			if (newCase.ajoutMonstre(monstre))
			{
				laCase.SuppMonstre(monstre);
				System.out.println("Le monstre "+monstre.getNom()+"  vagabonde vers la case "+newNumCase);
				return true;
			}
			return false;
		}
	}
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		return false;
	}
}
