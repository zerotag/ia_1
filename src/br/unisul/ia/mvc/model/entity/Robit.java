package br.unisul.ia.mvc.model.entity;

import br.unisul.ia.deprecated.core.SceneHandler;
import br.unisul.ia.deprecated.entity.MazeTile;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Robit {
	private int x;
	private int y;
	private int steps = 0;
	
	private int energyGainByPack = 0;
	
	private boolean alive;
	private int energy;
	private final int maxEnergy;
	private final boolean canExceedMaxEnergy;
	
	/* ROBIT MAZE MEMORY */
	private boolean iFoundIt = false;
	private final LinkedList<MazeTile> pathBefore	= new LinkedList<>();
	private final LinkedList<MazeTile> pathAfter	= new LinkedList<>();
	/* ***************** */
	
	private Robit() {this.alive = false; this.maxEnergy = -1; this.canExceedMaxEnergy = false;}
	
	public Robit(int maxEnergy, boolean canExceedMaxEnergy) {
		this.maxEnergy = maxEnergy;
		this.energy = this.maxEnergy;
		this.canExceedMaxEnergy = canExceedMaxEnergy;
		this.alive = true;
		
		this.pathAfter.add(SceneHandler.getInstance().getMaze().getEntrance());
		this.x = SceneHandler.getInstance().getMaze().getEntrance().getX();
		this.y = SceneHandler.getInstance().getMaze().getEntrance().getY();
	}
	
	public void addEnergy(int energyGain) {
		if (this.canExceedMaxEnergy){
			this.energy += energyGain;
			this.energyGainByPack += energyGain;
		} else{
			this.energy = Math.min(this.energy + energyGain, this.maxEnergy);
			this.energyGainByPack +=
				Math.max(this.energy + energyGain, this.maxEnergy) -
				Math.min(this.energy + energyGain, this.maxEnergy);
		}
	}
	
	public Robit remEnergy(int energyLoss) {
		this.energy = this.energy - energyLoss;
		if (this.energy <= 0) {
			this.alive = false;
			this.energy = 0;
		}
		return this;
	}

	public boolean isAlive() {
		return alive;
	}

	public int getEnergy() {
		return energy;
	}

	public int getX() {
		return x;
	}

	public Robit setX(int x) {
		this.x = x;
		return this;
	}

	public int getY() {
		return y;
	}

	public Robit setY(int y) {
		this.y = y;
		return this;
	}

	public int getSteps() {
		return steps;
	}

	public void step() {
		this.steps = steps + 1;
	}

	public int getEnergyGain() {
		return energyGainByPack;
	}

	public LinkedList<MazeTile> getMyPath() {
		return pathAfter;
	}

	public boolean doStep() {
		MazeTile currentTile = pathAfter.removeFirst();
		pathBefore.add(currentTile);
		currentTile.update();
		
		LinkedList<MazeTile> next = SceneHandler.getInstance().getMaze().getMyNeighbors(currentTile);
		
		if (next.isEmpty()) {currentTile.lock(); return false;}
		
		MazeTile first = next.getFirst();
		double count = next.stream().filter((t) -> {
			return (!t.isLocked()) && (!t.isVisited());
		}).count();
		
		if( count == 0 ) currentTile.lock();

		if (next.size() > 1) {
			next.removeFirst();
			pathAfter.addAll(0, next);
			pathAfter.addFirst(currentTile);
			pathAfter.addFirst(first);
		} else {
			pathAfter.addFirst(currentTile);
			pathAfter.addFirst(first);
		}
		
		// IF NOT VISITED, WE DO NOW
		if (!currentTile.isVisited()) currentTile.visit();
		
		// CHECK FOR REPAIR PACKS AT CURRENT LOCATION
		//if ( currentTile.hasRepairPack() ) { this.addEnergy(currentTile.getRepairPack().use()); }
		
		// UPDATE CURRENT LOCATION and UPDATE ENERGY
		this.step();
		this.setX(currentTile.getX()).setY(currentTile.getY());
		this.remEnergy(1);

		// IF EXIT: YAY! WE DIT IT!
		if (currentTile == SceneHandler.getInstance().getMaze().getExit()) {this.iFoundIt = true; return true;}
		
		// IF EXIT NOT FOUND (BUT ROBIT STILL ALIVE), THIS IS AN INVALID MAZE
		if (!this.iFoundIt && this.alive) {
			JOptionPane.showMessageDialog(null, "Sorry! This maze is unsolvable!");
			return false;
		}
		
		return true;
	}
}
