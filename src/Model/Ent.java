package Model;

import java.util.Random;

public class Ent extends Monstre implements Vivipare {
	private Random rand = new Random();
	
	public Ent(String nom, int sexe, int poids, int taille, double age, boolean sommeil) {
		super(nom, sexe, poids, taille, age, sommeil);
	}

	@Override
	public Monstre naissance() {
		int sexe = (int) Math.round(Math.random());
		int taille = (int) Math.round(Math.random()*2);
		int poids = (int) Math.round(30+Math.random()*10);
		
		return new Ent("Ent", sexe, poids, taille, 0, false);
	}
	
	public boolean seDeplacer(SeDeplacer seDeplacer, Jeu jeu) {
		int numCase = this.getNumCaseActuelle();
		Case laCase = jeu.recupererCase(numCase);
		int n = rand.nextInt(2);
		int newNumCase = laCase.getNumCase();
		switch (n)
		{
			/*case 0 = recule*/
			case 0: newNumCase = laCase.getNumCase()-1;
			System.out.println("Le monstre "+this.getNom()+" recule d'une case.");
					break;
			/*case 2 = avance*/
			case 1: newNumCase = laCase.getNumCase()+1;
					break;
		}
		Case newCase = jeu.recupererCase(newNumCase);
		//On empêche le monstre de sortir du plateau
		int nbCase = jeu.getCases().size();
		if(newCase.getNumCase() == -1 || newCase.getNumCase() == nbCase)
		{
			System.out.println("Le monstre "+this.getNom()+"  a tenté de sortir des frontières. Heureusement, les gardes de Dar Elnor l'en ont empêché. Le monstre reste sur sa case.");
			return false;
		}
		else
		{
			if (newCase.ajoutMonstre(this))
			{
				laCase.SuppMonstre(this);
				System.out.println("Le monstre "+this.getNom()+"  se traîne vers la case "+newNumCase);
				return true;
			}
			return false;
		}
	}

	@Override
	public String son() {
		return "Les branches de l'Ent "+this.getNom()+" craquent sous la forêt profonde.";
	}

	@Override
	public void gestation() {
		// non concerné
		
	}

}
