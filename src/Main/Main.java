package Main;

import Controller.Controller;
import View.View;
import Model.Model;

public class Main {

	/**
	 * M�thode d'entr� de l'application.
	 * Initialisation du controller en lui passant une vue et un mod�le
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		
		Controller controller = new Controller(view, model);
		controller.debutJeu();
	}

}
