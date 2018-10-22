package jeu;

import java.util.Scanner;

public class TestLaurie {
	public static void main(String[] args) {
		Basilic bas = new Basilic("Basilic", 0, 0, 0, 0, 0, 0, false);
		
		Oeuf oeuf = bas.pondreOeuf();
		
		if(oeuf.getTempsIncub() == 0)
		{
			Basilic bas2  = (Basilic) oeuf.eclore();
		}
		
		System.out.println(bas);
	}

}
