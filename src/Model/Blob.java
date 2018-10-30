package Model;

public class Blob extends Monstre implements Rampant {

	public Blob(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	@Override
	public boolean ramper(SeDeplacer seDeplacer, Jeu jeu) {
		return seDeplacer.ramper(this, jeu);
	}

	@Override
	public String son() {
		return "Le Blob "+this.getNom()+" gargouille de manière écoeurante.";
	}
	
	public Blob seDiviser()
	{
		int sexe = this.getSexe();
		int taille = this.getTaille();
		int poids = this.getPoids();
		
		return new Blob("Blob", sexe, poids, taille, 0, false);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		return this.ramper(seDeplacer, jeu);
	}

	@Override
	public void gestation(Jeu jeu) {
		System.out.println("Un Blob s'est divisé !");
		Monstre monstre = this.seDiviser();		
		int numCase = this.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		boolean monstrePlace = false;
		while(monstrePlace == false)
		{
			if(laCase.ajoutMonstre(monstre))
			{
				System.out.println("Le monstre "+monstre.getNom()+" s'est placé à la case "+laCase.getNumCase());
				monstrePlace = true;
			}
			else
			{
				if(numCase == 19)
				{
					System.out.println("Un jeune monstre est mort car aucun terrain ne lui était favorable.");
					monstrePlace = true;
				}
				else
				{
					numCase = numCase +1;
					laCase = jeu.recupererCase(numCase);
				}
			}
		}
	}
}
