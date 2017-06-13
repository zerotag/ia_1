package br.unisul.ia.mvc.model.maze.tile;

public class LockedTile extends VisitedTile {

	public LockedTile(int x, int y) {
		super(x, y);
	}
	
	@Override
	public boolean isLocked() {
		return true;
	}
	
}
