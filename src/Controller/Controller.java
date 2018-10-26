package Controller;

import java.util.ArrayList;

import Model.Case;
import Model.Jeu;
import Model.Model;
import Model.Monstre;
import Model.Personnage;
import View.View;

public class Controller {
	private View vue;
	private Model model;
	private Jeu jeu;
	
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
		this.jeu = this.model.creerJeu(cases, monstres, personnage);
		
		this.vue.AfficheInfoJeu(this.jeu);
		int choix = this.vue.AfficherMenu("Bienvenue dans le Royaume de Dar Elnor, " + personnage.getNom() + ".\n", personnage);
		actions(choix);
	}
	
	public void actions(int action)
	{
		int choix;
		switch (action)
		{
			case 0: 
				this.seDeplacer();
				break;
			case 1: 
				this.manger();
				break;
			case 2: 
				this.attaquer();
				break;
			case 3: 
				this.lancerSort();
				break;
			case 4: 
				this.nettoyerCase();
				break;
			case 5: 
				this.examinerCase();
				break;
			case 6: 
				this.afficheInfosCaseActuelle();
				break;
			case 7:
				this.afficheInfoJeu();
				break;
			case 8:
				this.passerTour();
				break;
			default:
				System.out.println("Veuillez recommencer");
				choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
				break;
		}
	}
	
	public void seDeplacer()
	{
		this.jeu.consequenceAction();
		String choixDeplacement = this.vue.choixDeplacement();
		this.model.deplacerPersonnage(this.jeu.getJoueur(), choixDeplacement, this.jeu);
		int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
		actions(choix);
	}
	
	public void manger()
	{
		this.jeu.consequenceAction();
		this.model.manger(this.jeu.getJoueur());
		int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
		actions(choix);
	}
	
	public void attaquer()
	{
			ArrayList<Monstre> monstres = this.model.recupererMonstre(this.jeu.getJoueur(), this.jeu);
			int numMonstreAttaque = this.vue.afficherChoixMonstre(monstres);
			if(numMonstreAttaque == 10)
			{
				int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
			}
			else
			{
				if(numMonstreAttaque > monstres.size()-1 || numMonstreAttaque < 0)
				{
					System.out.println("\n\nSaisie incorrecte, veuillez recommencer.\n");
					actions(2);
				}
				else
				{
					this.jeu.consequenceAction();
					Monstre monstreAttaque = monstres.get(numMonstreAttaque);
					this.model.attaquerMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);
					int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
					actions(choix);
				}
			}
	}
	
	public void lancerSort()
	{
		ArrayList<Monstre> monstres = this.model.recupererMonstre(this.jeu.getJoueur(), this.jeu);
		int numMonstreAttaque = this.vue.afficherChoixMonstre(monstres);
		if(numMonstreAttaque == 10)
		{
			int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
			actions(choix);
		}
		else
		{
			if(numMonstreAttaque > monstres.size()-1 || numMonstreAttaque < 0)
			{
				System.out.println("\n\nSaisie incorrecte, veuillez recommencer.\n");
				actions(2);
			}
			else
			{
				this.jeu.consequenceAction();
				Monstre monstreAttaque = monstres.get(numMonstreAttaque);
				this.model.lancerSortSurMonstre(this.jeu.getJoueur(), jeu, monstreAttaque);
				int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
				actions(choix);
			}
		}
	}
	
	public void nettoyerCase()
	{
		this.jeu.consequenceAction();
		Personnage personnage = this.jeu.getJoueur();
		Case laCase = this.jeu.recupererCase(personnage.getPosition());
		this.jeu.getJoueur().nettoyer(laCase);
		int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
		actions(choix);
	}
	
	public void examinerCase()
	{
		this.jeu.consequenceAction();
		//TODO
		int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
		actions(choix);
	}
	
	public void afficheInfosCaseActuelle()
	{
		Personnage personnage = this.jeu.getJoueur();
		Case laCase = this.jeu.recupererCase(personnage.getPosition());
		this.jeu.getJoueur().examinerCase(laCase);
		int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
		actions(choix);
	}
	
	public void afficheInfoJeu()
	{
		String infos = this.jeu.infosJeu();
		int choix = this.vue.AfficherMenu(infos, this.jeu.getJoueur());
		actions(choix);
	}
	
	public void passerTour()
	{
		this.jeu.ChangerTour();
		int choix = this.vue.AfficherMenu("\n", this.jeu.getJoueur());
		actions(choix);
	}
}
