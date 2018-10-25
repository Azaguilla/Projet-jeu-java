package Model;

public class Gobelin extends Monstre implements Terrestre, Vivipare {
	private int tempsGestation = 0;
	private int dureeGestation = 2;
	
	
	public Gobelin(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
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

	public void vagabonder(SeDeplacer seDeplacer, Jeu jeu)
	{
		seDeplacer.vagabonder(this, jeu);
	}
	
	public Monstre naissance()
	{
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(15+Math.random()*5);
		
		return new Gobelin("Gobelin", sexe, poids, taille, 0, false);
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
		return "Le gobelin"+this.getNom()+" ricane dans les profondeurs.";
	}

}
