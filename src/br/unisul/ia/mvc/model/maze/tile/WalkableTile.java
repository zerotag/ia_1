package br.unisul.ia.mvc.model.maze.tile;

public class WalkableTile extends Tile {

	private static final java.awt.Color DEFAULT_COLOR = java.awt.Color.GRAY;
	private final java.awt.Color color;

	public WalkableTile(int x, int y) {
		super(x, y);
		this.color = DEFAULT_COLOR;
	}
	
	public WalkableTile(int x, int y, java.awt.Color color) {
		super(x, y);
		this.color = color;
	}
	
	@Override
	public boolean isWalkable() {
		return true;
	}
	
	public boolean isLocked(){
		return false;
	}
	
	public boolean isVisited(){
		return false;
	}
	
	public boolean isEntrance(){
		return false;
	}
	
	public boolean isExit(){
		return false;
	}
	
	public boolean hasRepairPack() {
		return false;
	}

	@Override
	public java.awt.Color getColor() {
		return color;
	}
	
}
