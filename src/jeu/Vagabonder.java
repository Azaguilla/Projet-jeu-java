package jeu;

public class Vagabonder implements SeDeplacer {
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	public boolean vagabonder(Monstre monstre, Jeu jeu)
	{
		int numCase = monstre.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		int newNumCase = laCase.getNumCase()+1;
		Case newCase = jeu.recupererCase(newNumCase);
		newCase.ajoutMonstre(monstre);
		laCase.suppMonstre(monstre);
		System.out.println("Le monstre vagabonde vers la case "+newNumCase);
		return true;
	}
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		return false;
	}
}
