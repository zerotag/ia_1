package br.unisul.ia.mvc.model.maze.tile;

public class ExitTile extends WalkableTile {

	private static final java.awt.Color DEFAULT_COLOR = java.awt.Color.GREEN;

	public ExitTile(int x, int y) {
		super(x, y, DEFAULT_COLOR);
	}
	
	@Override
	public final boolean isExit() {
		return true;
	}
	
}
