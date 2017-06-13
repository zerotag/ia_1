package br.unisul.ia.mvc.model.maze.tile;

public class VisitedTile extends WalkableTile {

	private static final java.awt.Color DEFAULT_COLOR = new java.awt.Color( 128, 128, 0); // DARK YELLOW

	public VisitedTile(int x, int y) {
		super(x, y, DEFAULT_COLOR);
	}
	
	@Override
	public boolean isVisited() {
		return true;
	}
	
}
