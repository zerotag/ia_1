package br.unisul.ia.mvc.model.maze.tile;

import br.unisul.ia.mvc.model.entity.RepairPack;

public class FullRepairTile extends RepairTile {
	
	private static final java.awt.Color DEFAULT_COLOR = java.awt.Color.BLUE;
	
	private final RepairPack pack;
	
	public FullRepairTile(int x, int y) {
		super(x, y, DEFAULT_COLOR);
		pack = new RepairPack(10);
	}

	@Override
	public RepairPack getRepairPack() {
		return pack;
	}
	
}
