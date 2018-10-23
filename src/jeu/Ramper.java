package jeu;

public class Ramper implements SeDeplacer {
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	public boolean vagabonder(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		int numCase = monstre.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		int newNumCase = laCase.getNumCase()+1;
		Case newCase = jeu.recupererCase(newNumCase);
		newCase.ajoutMonstre(monstre);
		laCase.SuppMonstre(monstre);
		System.out.println("Le monstre nage vers la case.");
		return true;
	}
}
