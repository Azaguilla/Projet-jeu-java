package jeu;

public interface SeDeplacer {
	public boolean seDeplacer(Terrestre monstre);
	public boolean seDeplacer(Rampant monstre);
	public boolean seDeplacer(Volant monstre);
}
