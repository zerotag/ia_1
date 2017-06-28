package br.unisul.ia.mvc.model.maze.tile;

import br.unisul.ia.mvc.model.Model;

public abstract class Tile extends Model {
	
	private final int x;
	private final int y;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public abstract boolean isWalkable();
	public abstract java.awt.Color getColor();
	
}
