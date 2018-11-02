package Model;

public class Basilic extends Monstre implements Rampant, Ovipare 
{
	/**
	 * Monstre de l'esp�ce des Basilics
	 * @param nom Nom du Basilic
	 * @param sexe Sexe du Basilic
	 * @param poids Poids du Basilic
	 * @param taille Taille du Basilic
	 * @param age Age du Basilic
	 * @param sommeil Etat de sommeil du Basilic, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Basilic(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}
	
	/**
	 * Initialise au hasard les caracteristiques du b�b�
	 * Cr�e un nouveau monstre bebe
	 * @return Un nouvel (un objet) oeuf avec son temps d'incubation et le bebe (l'instanciation du monstre actuel) qu'il contient
	 */
	@Override
	public Oeuf pondreOeuf() 
	{
		//System.out.println("Un oeuf est en cours de pr�paration.");
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Monstre bebe = new Basilic("Basilic", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	/**
	 * M�thode de d�placement des monstres rampant
	 *  
	 * @param seDeplacer 
	 * @param jeu 
	 * 
	 * @return Si le monstre s'est bien d�plac�, true, sinon, false
	 */
	@Override
	public boolean ramper(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return seDeplacer.ramper(this, jeu);
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
		return this.ramper(seDeplacer, jeu);
	}

	//TODO inclure les sons apr�s un d�placement
	/**
	 * D�termine le son du monstre
	 * @return Le son et le nom du Basilic
	 */
	@Override
	public String son() 
	{
		return "\nLe Basilic "+this.getNom()+" siffle au fond du Marais.\n";
	}

	/**
	 * Le monstre entre en gestation d'un oeuf
	 * @param jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return Un message d'information pour indiquer au joueur qu'un oeuf est en cours d'incubation.
	 */
	@Override
	public String gestation(Jeu jeu) 
	{
		Oeuf oeuf = this.pondreOeuf();
		jeu.ajoutOeuf(oeuf);
		return "\nUn oeuf de "+this.getNom()+" est en cours d'incubation.\n";
	}

}
