package jeu;

public class Ramper implements SeDeplacer {
	public boolean seDeplacer(Volant monstre)
	{
		return false;
	}
	public boolean seDeplacer(Terrestre monstre)
	{
		return false;
	}
	public boolean seDeplacer(Rampant monstre)
	{
		System.out.println("Le monstre nage vers la case.");
		return true;
	}
}
