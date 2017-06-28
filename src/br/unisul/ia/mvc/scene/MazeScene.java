package br.unisul.ia.mvc.scene;

import br.unisul.ia.mvc.controller.Controller;
import br.unisul.ia.mvc.controller.MazeSceneController;

public class MazeScene extends Scene{

	private MazeSceneController controller;
	
	@Override
	public void setController(Controller controller) {
		if (controller.getClass().equals(MazeSceneController.class))
			this.controller = (MazeSceneController)controller;
		else
			throw new RuntimeException("[FATAL-ERROR] MainScene doesn't allow a controller of different type of <MainSceneController>.");
	}
	
}
