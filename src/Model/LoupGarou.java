/**
 * 
 */
package Model;

/**
 * @author Laurie
 *
 */
public class LoupGarou extends Monstre implements Terrestre, Vivipare {
	private int tempsGestation = 0;
	private int dureeGestation = 3;
	
	public LoupGarou(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	public int getTempsGestation() {
		return tempsGestation;
	}

	public void setTempsGestation(int tempsGestation) {
		this.tempsGestation = tempsGestation;
	}

	public int getDureeGestation() {
		return dureeGestation;
	}

	public void setDureeGestation(int dureeGestation) {
		this.dureeGestation = dureeGestation;
	}
	
	public boolean vagabonder(SeDeplacer seDeplacer, Jeu jeu)
	{
		return seDeplacer.vagabonder(this, jeu);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.vagabonder(seDeplacer, jeu);
	}
	
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		return new LoupGarou("Loup Garou", sexe, poids, taille, 0, false);
	}
	
	public void gestation()
	{
		if(this.tempsGestation == this.dureeGestation)
		{
			this.naissance();
			this.tempsGestation = 0;
			this.setEnGestation(false);
		}
		else
		{
			this.tempsGestation++;
			this.setEnGestation(true);
		}
	}
	
	public String son()
	{
		return "Le Loup Garou "+this.getNom()+" hurle à la Lune.";
	}

}
