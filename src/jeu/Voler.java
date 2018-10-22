package jeu;

public class Voler implements SeDeplacer {
	public boolean voler(Monstre monstre, Jeu jeu)
	{
		System.out.println("Le monstre s'envole vers la case.");
		return true;
	}
	public boolean vagabonder(Monstre monstre, Jeu jeu)
	{
		return false;
	}
	public boolean ramper(Monstre monstre, Jeu jeu)
	{
		return false;
	}
}
