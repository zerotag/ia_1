package br.unisul.ia.mvc.model.maze.tile;

import br.unisul.ia.mvc.model.entity.RepairPack;

public class HalfRepairTile extends RepairTile {
	
	private static final java.awt.Color DEFAULT_COLOR = java.awt.Color.CYAN;
	
	private final RepairPack pack;
	
	public HalfRepairTile(int x, int y) {
		super(x, y, DEFAULT_COLOR);
		pack = new RepairPack(5);
	}

	@Override
	public RepairPack getRepairPack() {
		return pack;
	}
	
}
