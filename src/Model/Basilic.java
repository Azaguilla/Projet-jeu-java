package Model;

public class Basilic extends Monstre implements Rampant, Ovipare 
{
	/**
	 * Monstre de l'esp�ce des Basilics
	 * @param String nom Nom du Basilic
	 * @param int sexe Sexe du Basilic
	 * @param int poids Poids du Basilic
	 * @param int taille Taille du Basilic
	 * @param double age Age du Basilic
	 * @param boolean sommeil Etat de sommeil du Basilic, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Basilic(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}
	
	/**
	 * Initialise au hasard les caracteristiques du b�b�
	 * Cr�e un nouveau monstre bebe
	 * @return Oeuf Un nouvel oeuf avec son temps d'incubation et le bebe qu'in contient
	 */
	@Override
	public Oeuf pondreOeuf() 
	{
		System.out.println("Un oeuf est en cours de pr�paration.");
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		Monstre bebe = new Basilic("Basilic", sexe, poids, taille, 0, false);
		
		return new Oeuf(2, bebe);
	}

	//TODO javadoc
	/**
	 * 
	 * 
	 */
	@Override
	public boolean ramper(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return seDeplacer.ramper(this, jeu);
	}
	
	//TODO javadoc
	/**
	 * 
	 * 
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return this.ramper(seDeplacer, jeu);
	}

	//TODO inclure les sons apr�s un d�placement
	/**
	 * D�termine le son du monstre
	 * @return String Le son et le nom du Basilic
	 */
	@Override
	public String son() 
	{
		return "Le Basilic "+this.getNom()+" siffle au fond du Marais.";
	}

	//TODO v�rifier doc
	/**
	 * Le monstre entre en gestation d'un oeuf
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 * @return String
	 */
	@Override
	public String gestation(Jeu jeu) 
	{
		Oeuf oeuf = this.pondreOeuf();
		jeu.ajoutOeuf(oeuf);
		return "Un oeuf de "+this.getNom()+" est en cours d'incubation.";
	}

}
