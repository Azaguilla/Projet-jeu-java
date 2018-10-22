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
		System.out.println("Le monstre nage vers la case.");
		return true;
	}
}
