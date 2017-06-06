package br.unisul.ia.entity;

public class RepairPack {
	private boolean used;
	private final int repairAmount;

	private RepairPack() {this.used = true; this.repairAmount = 0;}
	
	public RepairPack(int repairAmount) {
		this.repairAmount = repairAmount;
	}

	public int use() {
		if (!this.used) {
			this.used = true;
			return getRepairAmount();
		}
		return 0;
	}
	
	public boolean isUsed() {
		return used;
	}

	private int getRepairAmount() {
		return repairAmount;
	}
	
	@Override
	public String toString() {
		return "" + repairAmount;
	}
	
}
