package br.unisul.ia.mvc.model.maze.tile;

public class EntranceTile extends WalkableTile {

	private static final java.awt.Color DEFAULT_COLOR = java.awt.Color.ORANGE;
	
	public EntranceTile(int x, int y){
		super(x, y, DEFAULT_COLOR);
	}
	
	@Override
	public final boolean isEntrance() {
		return true;
	}

}
