package br.unisul.ia.core;

import br.unisul.ia.gui.MainScene;

public class SceneHandler {
	
	private final MainScene scene;
	
	private boolean flag = false;
	
	private int mazeSize = 0;
	private int maxHealth = 0;
	private boolean canExceed = false;
	
	private SceneHandler() {
		this.scene = MainScene.run();
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
	
	public void start() throws InstantiationException {
		if (this.flag) {
			scene.generateMaze(this.mazeSize, this.maxHealth, this.canExceed);
			new SceneHandlerWorker(this);
		}
	}
}
