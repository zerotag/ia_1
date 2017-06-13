package br.unisul.ia.deprecated.core;

import br.unisul.ia.deprecated.entity.MazeOld;
import br.unisul.ia.mvc.model.entity.Robit;
import br.unisul.ia.deprecated.gui.MainSceneOld;

public class SceneHandler {
	
	private MainSceneOld scene;
	
	private boolean flag = false;
	
	private int mazeSize = 0;
	private int maxHealth = 0;
	private boolean canExceed = false;
	
	private SceneHandlerWorker worker;
	private Robit robit;
	private MazeOld maze;
	
	private SceneHandler() {
		MainSceneOld.run();
	}
	public static SceneHandler getInstance() { return SceneHandlerHolder.INSTANCE; }
	private static class SceneHandlerHolder {
		private static final SceneHandler INSTANCE = new SceneHandler();
	}
	
	public void setUserInput(int mazeSize, int maxHealth, boolean canExceed) {
		this.mazeSize = mazeSize;
		this.maxHealth = maxHealth;
		this.canExceed = canExceed;
		
		this.flag = true;
	}

	public int getMazeSize() {
		return mazeSize;
	}

	public void setMazeSize(int mazeSize) {
		this.mazeSize = mazeSize;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public boolean canExceed() {
		return canExceed;
	}

	public void setCanExceed(boolean canExceed) {
		this.canExceed = canExceed;
	}

	public void setScene(MainSceneOld scene) {
		this.scene = scene;
	}

	public MainSceneOld getScene() {
		return scene;
	}

	public Robit getRobit() {
		return robit;
	}

	public MazeOld getMaze() {
		return maze;
	}
	
	public void execute() throws InstantiationException {
		if (this.flag) {
			this.flag = true;
			
			// OUR MAZE AND ROBIT
			this.maze = new MazeOld(this.mazeSize);
			this.robit = new Robit(this.maxHealth, this.canExceed);
			
			scene.generateMaze(this.maze);
			worker = new SceneHandlerWorker(this);
			worker.execute();
		}
	}
}
