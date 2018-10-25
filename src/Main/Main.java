package Main;

import Controller.Controller;
import View.View;
import Model.Model;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		
		Controller controller = new Controller(view, model);
		controller.debutJeu();
	}

}
