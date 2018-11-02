package Model.ModelMonstre;

import Model.ModelJeu.Jeu;

public interface SeDeplacer {
	public boolean vagabonder(Monstre monstre, Jeu jeu);
	public boolean ramper(Monstre monstre, Jeu jeu);
	public boolean voler(Monstre monstre, Jeu jeu);
}
