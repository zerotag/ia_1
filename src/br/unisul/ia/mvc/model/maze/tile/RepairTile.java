package br.unisul.ia.mvc.model.maze.tile;

import br.unisul.ia.mvc.model.entity.RepairPack;

public abstract class RepairTile extends WalkableTile {

	public RepairTile(int x, int y, java.awt.Color color) {
		super(x, y, color);
	}
	
	@Override
	public final boolean hasRepairPack() {
		return true;
	}
	
	public abstract RepairPack getRepairPack();
	
}
