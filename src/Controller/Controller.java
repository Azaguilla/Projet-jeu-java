package Controller;

import Model.Case;
import Model.Jeu;
import Model.Model;
import Model.Monstre;
import Model.Personnage;
import View.View;

public class Controller {
	private View vue;
	private Model model;
	
	public Controller(View vue, Model model) {
		super();
		this.vue = vue;
		this.model = model;
	}
	
	public void debutJeu()
	{
		int classe = this.vue.AfficherDemandeClasse();
		String nom = this.vue.AfficherDemandePersonnage();
		String sexe = this.vue.AfficherDemandeSexe();
		
		Personnage personnage = this.model.creerPersonnage(classe, sexe, nom);
		
		
		this.initialisation(personnage);
	}
	
	public void initialisation(Personnage personnage)
	{
		Monstre[] monstres = this.model.creerMonstres();
		Case[] cases = this.model.creerCases(monstres);
		Jeu jeu = this.model.creerJeu(cases, monstres, personnage);
		
		this.vue.AfficheInfoJeu(jeu);
		this.vue.AfficherMenu("Bienvenue dans le Royaume de Dar Elnor, " + personnage.getNom() + ".\n", personnage);
		
	}
}
