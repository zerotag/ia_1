package br.unisul.ia.mvc.model.maze.tile;

public class TileFactory {

	private TileFactory() {}
	
	public static Tile makeRobitTile(int x, int y) {
		return new RobitTile(x, y);
	}
	
	public static Tile makeWalkableTile(int x, int y) {
		return new WalkableTile(x, y);
	}
	
	public static Tile makeEntranceTile(int x, int y) {
		return new EntranceTile(x, y);
	}
	
	public static Tile makeExitTile(int x, int y) {
		return new ExitTile(x, y);
	}
	
	public static Tile makeVisitedTile(int x, int y) {
		return new VisitedTile(x, y);
	}
	
	public static Tile makeLockedTile(int x, int y) {
		return new LockedTile(x, y);
	}
	
	public static Tile makeHalfRepairTile(int x, int y) {
		return new HalfRepairTile(x, y);
	}
	
	public static Tile makeFullRepairTile(int x, int y) {
		return new FullRepairTile(x, y);
	}
	
}
