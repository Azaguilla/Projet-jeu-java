package Model;

public class Blob extends Monstre implements Rampant 
{
	/**
	 * Monstre de l'esp�ce des Blob
	 * @param String nom Nom du Blob
	 * @param int sexe Sexe du Blob
	 * @param int poids Poids du Blob
	 * @param int taille Taille du Blob
	 * @param double age Age du Blob
	 * @param boolean sommeil Etat de sommeil du Blob, vrai(true) s'il est endormis,  faux(false) s'il est r�veill�
	 */
	public Blob(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}


	/**
	 * M�thode commune � tous les monstres. Permet � celui-ci de se d�placer
	 * 
	 * @param SeDeplacer seDeplacer 
	 * @oaram Jeu jeu 
	 * 
	 * @return boolean si le monstre s'est bien d�plac�, true, sinon, false
	 */
	@Override
	public boolean ramper(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return seDeplacer.ramper(this, jeu);
	}

	/**
	 * D�termine le son du monstre
	 * @return String Le son et le nom du Blob
	 */
	@Override
	public String son() 
	{
		return "Le Blob "+this.getNom()+" gargouille de mani�re �coeurante.";
	}
	
	/**
	 * Cr�e un nouveau Blob identique
	 * @return Monstre Blob Un nouveau Blob
	 */
	public Blob seDiviser()
	{
		int sexe = this.getSexe();
		int taille = this.getTaille();
		int poids = this.getPoids();
		
		return new Blob("Blob", sexe, poids, taille, 0, false);
	}
	
	/**
	 * M�thode commune � tous les monstres. Permet � celui-ci de se d�placer
	 * 
	 * @param SeDeplacer seDeplacer 
	 * @oaram Jeu jeu 
	 * 
	 * @return boolean si le monstre s'est bien d�plac�, true, sinon, false
	 */
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) 
	{
		return this.ramper(seDeplacer, jeu);
	}

	
	/**
	 * Le monstre entre en gestation et cr�e un nouveau monstre identique
	 * Si le monstre peut etre plac� dans son terrain le monstre est plac�
	 * Sinon il meurt
	 * @param Jeu jeu Les informations concernant l'anvanc�e du jeu, les monstres, les cases...
	 */
	@Override
	public String gestation(Jeu jeu) 
	{
		//System.out.println("sysoUn Blob s'est divis� !");
		String message ="";
		Monstre monstre = this.seDiviser();		
		int numCase = this.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		boolean monstrePlace = false;
		while(monstrePlace == false)
		{
			if(laCase.ajoutMonstre(monstre))
			{
				//System.out.println("sysoLe monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase());
				message = "\nUn Blob s'est divis� ! Le monstre "+monstre.getNom()+" s'est plac� � la case "+laCase.getNumCase()+"\n";
				monstrePlace = true;
			}
			else
			{
				if(numCase == 19)
				{
					//System.out.println("sysoUn jeune monstre est mort car aucun terrain ne lui �tait favorable.");
					message = "\nUn jeune monstre est mort car aucun terrain ne lui �tait favorable.\n";
					monstrePlace = true;
				}
				else
				{
					numCase = numCase +1;
					laCase = jeu.recupererCase(numCase);
				}
			}
		}
		return message;
	}
}
