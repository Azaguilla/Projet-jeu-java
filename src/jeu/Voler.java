package jeu;

public class Voler implements SeDeplacer {
	public boolean seDeplacer(Volant monstre)
	{
		System.out.println("Le monstre s'envole vers la case.");
		return true;
	}
	public boolean seDeplacer(Terrestre monstre)
	{
		return false;
	}
	public boolean seDeplacer(Rampant monstre)
	{
		return false;
	}
}
