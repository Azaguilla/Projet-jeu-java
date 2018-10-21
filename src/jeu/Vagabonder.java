package jeu;

public class Vagabonder {
	public boolean seDeplacer(Volant monstre)
	{
		return false;
	}
	public boolean seDeplacer(Terrestre monstre)
	{

		System.out.println("Le monstre vagabonde vers la case.");
		return true;
	}
	public boolean seDeplacer(Rampant monstre)
	{
		return false;
	}
}
