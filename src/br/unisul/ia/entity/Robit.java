package br.unisul.ia.entity;

public class Robit {
	private int x;
	private int y;
	private int steps = 0;
	
	private int energyGainByPack = 0;
	
	private boolean alive;
	private int energy;
	private final int maxEnergy;
	private final boolean canExceedMaxEnergy;
	
	private Robit() {this.alive = false; this.maxEnergy = -1; this.canExceedMaxEnergy = false;}
	
	public Robit(int maxEnergy, boolean canExceedMaxEnergy) {
		this.maxEnergy = maxEnergy;
		this.energy = this.maxEnergy;
		this.canExceedMaxEnergy = canExceedMaxEnergy;
		this.x = 0;
		this.y = 0;
		this.alive = true;
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
}
