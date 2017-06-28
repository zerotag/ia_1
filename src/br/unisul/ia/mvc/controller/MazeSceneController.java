package br.unisul.ia.mvc.controller;

import br.unisul.ia.mvc.model.maze.Maze;
import br.unisul.ia.mvc.scene.MazeScene;
import java.util.Queue;

public class MazeSceneController extends Controller {

	private final Maze model;
	private final MazeScene scene;
	
	public MazeSceneController(Maze maze, MazeScene scene) {
		this.model = maze;
		this.scene = scene;
	}
	
	private void setData(int size, int health, boolean exceed){}
	
	@Override
	public Maze getModel() {
		return model;
	}

	@Override
	public MazeScene getScene() {
		return scene;
	}

	@Override
	public Queue commune() {
		throw new RuntimeException("[FATAL-ERROR] Current Scene doesn't allow outbound commune!");
	}

	@Override
	public void commune(Queue commune) {
		try {
			this.setData((int)commune.poll(), (int)commune.poll(), (boolean)commune.poll());
		} catch(Exception e) {
			throw new RuntimeException("[FATAL-ERROR] Current Scene inbound commune failed! (Wrong data types)");
		}
	}
	
}
