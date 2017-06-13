package br.unisul.ia.mvc.model.maze.tile;

public class NotWalkableTile extends Tile {

	private static final java.awt.Color COLOR = java.awt.Color.RED;

	public NotWalkableTile(int x, int y) {
		super(x, y);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

	@Override
	public java.awt.Color getColor() {
		return COLOR;
	}

}
