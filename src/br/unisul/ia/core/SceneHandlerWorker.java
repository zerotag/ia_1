package br.unisul.ia.core;

import br.unisul.ia.entity.Maze;
import br.unisul.ia.entity.Robit;
import javax.swing.SwingWorker;

public class SceneHandlerWorker extends SwingWorker {
	
	private Robit robit;
	private Maze maze;
	private SceneHandler handler;
	
	private SceneHandlerWorker() {}
	public SceneHandlerWorker(SceneHandler handler) {
		this.handler = handler;
		
		this.robit = new Robit(handler.getMaxHealth(), handler.canExceed());
		try {
			this.maze = new Maze(this.robit, handler.getMazeSize());
		} catch (InstantiationException ex) {
			throw new RuntimeException("Error Instantiating the MAZE!");
		}
	}
	
	@Override
	protected Object doInBackground() throws Exception {
		
		//
		
		return 0;
	}
	
}
