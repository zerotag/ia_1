package br.unisul.ia.mvc;

import br.unisul.ia.App;
import br.unisul.ia.mvc.controller.Controller;
import br.unisul.ia.mvc.controller.MainSceneController;
import br.unisul.ia.mvc.controller.MazeSceneController;
import br.unisul.ia.mvc.model.Main;
import br.unisul.ia.mvc.model.maze.Maze;
import br.unisul.ia.mvc.scene.MainScene;
import br.unisul.ia.mvc.scene.MazeScene;
import br.unisul.ia.mvc.scene.Scene;
import java.util.LinkedList;
import java.util.Queue;

public class AppManager {
	
	private final Queue<Controller> controllers = new LinkedList<>();
	
	private Controller OLDER_TWIN;
	private Controller YOUNG_TWIN;
	
	private AppManager() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			throw new RuntimeException("[FATAL-ERROR] LookAndFeel failed to initialize! <" + ex + ">");
		}
		
		Main main = new Main(); MainScene mainScene = new MainScene();
		MainSceneController controller1 = new MainSceneController(main, mainScene);
		mainScene.setController(controller1);
		controllers.add(controller1);
		
		Maze maze = new Maze(); MazeScene mazeScene = new MazeScene();
		MazeSceneController controller2 = new MazeSceneController(maze, mazeScene);
		mazeScene.setController(controller2);
		controllers.add(controller2);
	}
	
	public static AppManager getInstance()	{return SceneManagerHolder.INSTANCE;}
	private static class SceneManagerHolder	{private static final AppManager INSTANCE = new AppManager();}
	
	public void communeWithTwin(Controller yourself){
		boolean successInCommune = false;
		while (!successInCommune) {
			if (OLDER_TWIN != null && YOUNG_TWIN != null) {
				if (OLDER_TWIN.equals(yourself)){
					YOUNG_TWIN.commune(OLDER_TWIN.commune());
				} else if (YOUNG_TWIN.equals(yourself)){
					OLDER_TWIN.commune(YOUNG_TWIN.commune());
				} else {
					throw new RuntimeException("[FATAL-ERROR] Neither of twins are equal to the provided controller!");
				}
				
				successInCommune = true;
			}
			App.hammerTime(500);
		}
	}
	
	private Controller getCurrentController(){
		return OLDER_TWIN;
	}
	
	private Controller getNextController(){
		if (OLDER_TWIN == null && YOUNG_TWIN == null){
			YOUNG_TWIN = controllers.poll();
			OLDER_TWIN = YOUNG_TWIN;
		} else if (!OLDER_TWIN.equals(YOUNG_TWIN)) {
			if (YOUNG_TWIN != null){OLDER_TWIN = YOUNG_TWIN;}
			YOUNG_TWIN = controllers.poll();
		}
		return YOUNG_TWIN;
	}
	
	public void next() {
		YOUNG_TWIN.getScene().setVisible(false);
	}
	
	public void start(){
		boolean endgame = false;
		Scene scene;
		while (!endgame) {
			if (getNextController() != null) {
				scene = getCurrentController().getScene();
				
				if (scene == null) {
					endgame = true;
				} else {
					scene.run();
					while (scene.isShowing()) {
						App.hammerTime(1_000);
					}
				}
			}
		}
		System.exit(0);
	}
}
