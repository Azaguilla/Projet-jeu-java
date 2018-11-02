package Model.ModelMonstre;

import Model.ModelJeu.Jeu;

public class Griffon extends Monstre implements Volant, Ovipare 
{
	/**
	 * Monstre de l'esp�ce des Griffons
	 * @param nom Nom du Griffon
	 * @param sexe Sexe du Griffon
	 * @param poids Poids du Griffon
	 * @param taille Taille du Griffon
	 * @param age Age du Griffon
	 * @param sommeil Etat de sommeil du Griffon, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Griffon(String nom, int sexe, int poids, int taille, double age, boolean sommeil) 
	{
		super(nom, sexe, poids, taille, age, sommeil);
	}

	/**
	 * Initialise au hasard les caracteristiques du b�b�
	 * Cr�e un nouveau monstre bebe
	 * @return Un nouvel oeuf avec son temps d'incubation et le bebe qu'in contient
	 */
	@Override
	public Oeuf pondreOeuf() 
	{
		//System.out.println("Un oeuf est en cours de pr�paration.");
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Griffon bebe = new Griffon("Griffon", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	/**
	 * M�thode de d�placement des monstres volant
	 *  
	 * @param seDeplacer 
	 * @param jeu 
	 * 
	 * @return Si le monstre s'est bien d�plac�, true, sinon, false
	 */
	@Override
	public boolean voler(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return seDeplacer.voler(this, jeu);
	}
	
	/**
	 * M�thode commune � tous les monstres. Permet � celui-ci de se d�placer
	 * 
	 * @param seDeplacer 
	 * @param jeu 
	 * 
	 * @return Si le monstre s'est bien d�plac�, true, sinon, false
	 * 
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return this.voler(seDeplacer, jeu);
	}

	/**
	 * D�termine le son du monstre
	 * @return Le son et le nom du Griffon
	 */
	@Override
	public String son()
	{
		return "Le Griffon "+this.getNom()+" glatit dans le ciel.";
	}

	/**
	 * Le monstre entre en gestation d'un oeuf
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return Un message d'information pour indiquer au joueur qu'un oeuf est en cours d'incubation.
	 */
	public String gestation(Jeu jeu) 
	{
		Oeuf oeuf = this.pondreOeuf();
		jeu.ajoutOeuf(oeuf);
		return "Un oeuf de "+this.getNom()+" est en cours d'incubation.";
	}

}
