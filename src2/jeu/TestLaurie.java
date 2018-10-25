package jeu;

import java.util.Scanner;

public class TestLaurie {
	public static void main(String[] args) {
		Personnage pers = Magicien.getInstance("Aza", "F", "Mage");
		Basilic bas = new Basilic("Basilic", 0, 0, 0, 0, 0, 0, false);
		
		Oeuf oeuf = bas.pondreOeuf();
		
		if(oeuf.getTempsIncub() == 0)
		{
			Basilic bas2  = (Basilic) oeuf.eclore();
		}
		
		System.out.println(bas);
		Jeu jeu = new Jeu("Partie1", pers);
		Plaine plaine = new Plaine(0, 1, 0);
		Marais marais = new Marais(0, 1, 0, 0);
		
		Monstre gob = new Gobelin("Gobelin", 0, 0, 0, 0, 0, 0, false);
		plaine.ajoutMonstre(bas);
		System.out.println(plaine.getMonstres());
		gob.gestation();
		gob.gestation();
		gob.gestation();
		gob.gestation();
		System.out.println(gob);
		
		jeu.ajoutCase(plaine);
		jeu.ajoutCase(marais);
		gob.grandir();
		System.out.println(gob.getTaille());
		jeu.AfficheInfoJeu();
	}

}
