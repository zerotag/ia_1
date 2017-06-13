package br.unisul.ia.deprecated.entity;

import br.unisul.ia.core.SceneHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

public class MazeOld {
	private boolean masterFLAG = false;
	
	private final int mazeSize;
	private final MazeTile maze[][];
	private MazeTile entrance, exit;
	
	/* FOR LOGS */
	private int wallsMIN			= 0;
	private int wallsMAX			= 0;
	private int generatedWalls		= 0;
	private int generatedPacksOf5	= 0;
	private int generatedPacksOf10	= 0;
	/* ******** */
	
	
	
	private MazeOld() { this.entrance = null; this.exit = null; this.mazeSize = -1; this.maze = null;}

	/**
	 * @param mazeSize single integer value
	 * @throws java.lang.InstantiationException if (mazeSize &lt; 3)
	 */
	public MazeOld(int mazeSize) throws InstantiationException {
		if (mazeSize < 3) throw new InstantiationException("Minimum matrix order is 3!");
		this.mazeSize = mazeSize;
		this.maze = new MazeTile[this.mazeSize][this.mazeSize];
		initMaze();
	}
	
	//<editor-fold defaultstate="collapsed" desc="MazeOld Initialization">
	private void initMaze(){
		this.initMazeTiles();
		this.initNotWalkableTiles(10, 25);	// Default Aspect Ratios
		this.initRepairPacks(5, 3);			// Default Aspect Ratios
	}
	private void initMazeTiles() {
		for (int y = 0; y < this.mazeSize; y++) {
			for (int x = 0; x < this.mazeSize; x++) {
				MazeTile generatedTile = this.maze[x][y] = new MazeTile(x, y);
				generatedTile.setWalkable(true);
			}
		}
		this.entrance = this.maze[0][0].setEntrance();
		this.exit = this.maze[this.mazeSize - 1][this.mazeSize - 1].setExit();
	}
	private void initNotWalkableTiles(int sizeOfMin, int sizeOfMax) {
		double countMin = 0, countMax = 0;
		for (int m = 0; m < this.mazeSize; m++) { countMin += (sizeOfMin / 10.0); }
		for (int n = 0; n < this.mazeSize; n++) { countMax += (sizeOfMax / 10.0); }
		
		int minWalls = (int) Math.floor(countMin), maxWalls = (int) Math.floor(countMax);
		this.wallsMIN = minWalls; this.wallsMAX = maxWalls;	// FOR LOGS
		
		int tilesToInit = ThreadLocalRandom.current().nextInt(minWalls, maxWalls);
		this.generatedWalls = tilesToInit;					// FOR LOGS
		
		MazeTile tilesConverted[][] = new MazeTile[this.mazeSize][this.mazeSize];
		while (tilesToInit > 0) {
			
			int x = ThreadLocalRandom.current().nextInt(0, this.mazeSize);
			int y = ThreadLocalRandom.current().nextInt(0, this.mazeSize);
			
			if ( tilesConverted[x][y] == null ) {
				MazeTile selectedTile = this.maze[x][y];
				if (!selectedTile.isEntrance() && !selectedTile.isExit()) {
					tilesConverted[x][y] = selectedTile;
					selectedTile.setWalkable(false);
					selectedTile.lock();
					tilesToInit--;
				}
			}
		}
	}
	private void initRepairPacks(int sizeOf5, int sizeOf10) {
		double count5 = 0, count10 = 0;
		for (int m = 0; m < this.mazeSize; m++) { count5 += (sizeOf5 / 10.0); }
		for (int n = 0; n < this.mazeSize; n++) { count10 += (sizeOf10 / 10.0); }
		
		this.generatedPacksOf5	= (int) Math.floor(count5);	// FOR LOGS
		this.generatedPacksOf10	= (int) Math.ceil(count10);// FOR LOGS
		
		ArrayList<RepairPack> packsOf5	= new ArrayList<>(this.generatedPacksOf5);
		ArrayList<RepairPack> packsOf10	= new ArrayList<>(this.generatedPacksOf10);
		
		for (int r = 0; r < count5; r++)	{ RepairPack rp = new RepairPack(5);	packsOf5.add(rp);	}
		for (int r = 0; r < count10; r++)	{ RepairPack rp = new RepairPack(10);	packsOf10.add(rp);	}
		
		addPacksToMaze(packsOf5);
		addPacksToMaze(packsOf10);
	}
	private void addPacksToMaze(List<RepairPack> packList) {
		while ( !packList.isEmpty() ) {
			int posX = ThreadLocalRandom.current().nextInt(0, this.mazeSize + 1);
			int posY = ThreadLocalRandom.current().nextInt(0, this.mazeSize + 1);
			
			for (int x = 0; x < this.mazeSize - 1; x++) {
				for (int y = 0; y < this.mazeSize - 1; y++) {
					MazeTile tile = this.maze[x][y];
					if (tile.getX() == posX && tile.getY() == posY) {
						if ( tile.isWalkable() && !tile.isEntrance() && !tile.isExit() && !tile.hasRepairPack() ) {
							tile.setRepairPack(packList.remove(0));
						}
					}
				}
			}
		}
	}
	// </editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="@Deprecated">
	@Deprecated
	public void runRobit() {
		// Set Robit at the Entrance
		Robit me = SceneHandler.getInstance().getRobit();
		
		LinkedList<MazeTile> queue = me.getMyPath();
		
		MazeTile currentTile = queue.removeFirst();
		LinkedList<MazeTile> next = this.nextNeighbors(currentTile);

		if (next.isEmpty()) {currentTile.lock();} else {

		MazeTile first = next.getFirst();
		double count = next.stream().filter((t) -> {
			return (!t.isLocked()) && (!t.isVisited());
		}).count();

		if( count == 0 ) currentTile.lock();

		if (next.size() > 1) {
			next.removeFirst();
			queue.addAll(0, next);
			queue.addFirst(currentTile);
			queue.addFirst(first);
		} else {
			queue.addFirst(currentTile);
			queue.addFirst(first);
		}

		// IF NOT VISITED, WE DO NOW
		if (!currentTile.isVisited()) currentTile.visit();

		// CHECK FOR REPAIR PACKS AT CURRENT LOCATION
		if ( currentTile.hasRepairPack() ) { me.addEnergy(currentTile.getRepairPack().use()); }

		// UPDATE CURRENT LOCATION and UPDATE ENERGY
		me.step();
		me.setX(currentTile.getX()).setY(currentTile.getY());
		me.remEnergy(1);

		// IF EXIT: YAY! WE DIT IT!
		if (currentTile == this.exit) {this.masterFLAG = true; break;}

		// IF ROBIT DIES STOP
		if (!me.isAlive()){ break; }

		currentTile.update();
		}
		// IF EXIT NOT FOUND (BUT ROBIT STILL ALIVE), THIS IS AN INVALID MAZE
		if (!this.masterFLAG && SceneHandler.getInstance().getRobit().isAlive()) { JOptionPane.showMessageDialog(null, "Sorry! This maze is unsolvable!"); }
	}
	//</editor-fold>
	
	private LinkedList<MazeTile> nextNeighbors( MazeTile currentNode ){
		// The effective list that will be returned
		LinkedList<MazeTile> neighbors	= new LinkedList<>();
		
		// Priority lists (which goes first inside the main list)
		// Not necessarily in this order
		LinkedList<MazeTile> isLocked	= new LinkedList<>();
		LinkedList<MazeTile> isVisited	= new LinkedList<>();
		LinkedList<MazeTile> hasPack5	= new LinkedList<>();
		LinkedList<MazeTile> hasPack10	= new LinkedList<>();
		LinkedList<MazeTile> isPure		= new LinkedList<>();
		
		int x = currentNode.getX(), y = currentNode.getY();
		
		//	PRIORITY ORDER
		//	A = RIGHT
		//	B = DOWN
		//	C = LEFT
		//	D = UP
		MazeTile NeiA = null; if ( x + 1 < this.mazeSize )	{ NeiA = this.maze[x + 1][y]; }
		MazeTile NeiB = null; if ( y + 1 < this.mazeSize )	{ NeiB = this.maze[x][y + 1]; }
		MazeTile NeiC = null; if ( x - 1 >= 0 )				{ NeiC = this.maze[x - 1][y]; }
		MazeTile NeiD = null; if ( y - 1 >= 0 )				{ NeiD = this.maze[x][y - 1]; }
		MazeTile Neis[] = new MazeTile[]{ NeiD, NeiC, NeiB, NeiA };
		
		for (MazeTile n : Neis) {
			if (n != null) {
				if (n.isWalkable()) { 
					if (!n.isLocked()) {
						if (!n.isVisited()) {
							if (n.hasRepairPack()) {
								switch (n.getRepairPack().toString()) {
									case "10":	hasPack10.addFirst(n);	break;
									case "5":	hasPack5.addFirst(n);	break;
								}
							} else {
								isPure.addFirst(n);
							}
						} else {
							isVisited.addFirst(n);
						}
					} else {
						isLocked.addFirst(n);
					}
				}
			}
		}
		
		// Add VISITED if no elegible neighbors
		if (isPure.isEmpty()) neighbors.addAll(0, isVisited);
		
		// Add packs first (10 then 5)
		if (!hasPack5.isEmpty()) neighbors.addAll(0, hasPack5);
		if (!hasPack10.isEmpty()) neighbors.addAll(0, hasPack10);
		
		// If we are in a no exit tile: OH NO! Reset the priority to the order
		if (isPure.isEmpty() && isLocked.size() > 0 && isVisited.size() > 0) {
			neighbors.addAll(0, isLocked);
			neighbors.addAll(0, isVisited);
		}
		
		// If any elegible neighbor, go there first!
		if (!isPure.isEmpty()) neighbors.addAll(isPure);
		
		return neighbors;
	}
	
	public int getMazeSize() {
		return mazeSize;
	}

	public MazeTile getEntrance() {
		return entrance;
	}

	public MazeTile getExit() {
		return exit;
	}

	public MazeTile[][] getMaze() {
		return maze;
	}

	public void updateAll() {
		for (MazeTile[] mazeRow : maze) {
			for (MazeTile mazeTile : mazeRow) {
				mazeTile.update();
			}
		}
	}

	public LinkedList<MazeTile> getMyNeighbors(MazeTile currentTile) {
		return this.nextNeighbors(currentTile);
	}
}
