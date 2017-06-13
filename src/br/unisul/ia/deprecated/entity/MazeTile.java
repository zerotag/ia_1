package br.unisul.ia.deprecated.entity;

import br.unisul.ia.mvc.model.entity.Robit;
import br.unisul.ia.mvc.model.entity.RepairPack;
import br.unisul.ia.deprecated.core.SceneHandler;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class MazeTile {
	public static final int BASESIZE = 20;
	
	private final int x;
	private final int y;
	
	private boolean walkable;
	private RepairPack repairPack;
	
	/**/
	private boolean locked		= false;
	private boolean visited		= false;
	/**/
	
	private boolean entrance	= false;//
	private boolean exit		= false;//
	private boolean flag		= false;//
	
	
	
	// GUI INFO
	private JLabel guiTile;
	private AbsoluteConstraints pos;
	private Dimension size;

	private MazeTile() {this.x = -1; this.y = -1; this.walkable = false;}
	
	public MazeTile(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.size = new Dimension(BASESIZE, BASESIZE);
		
		// GUI Tile and Position (calculated by X and Y)
		this.guiTile = new JLabel();
		this.pos = new AbsoluteConstraints(this.x * (BASESIZE + 4), this.y * (BASESIZE + 4), -1, -1);
		
		// Sizing
		this.guiTile.setMinimumSize(this.size);
		this.guiTile.setMaximumSize(this.size);
		this.guiTile.setPreferredSize(this.size);
		this.guiTile.setSize(this.size);
		
		// Color
		this.guiTile.setOpaque( true );
		this.update();
	}
	
	public MazeTile(int x, int y, boolean walkable) {
		this.x = x;
		this.y = y;
		this.walkable = walkable;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public RepairPack getRepairPack() {
		return repairPack;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public boolean isVisited() {
		return visited;
	}

	public boolean isEntrance() {
		return entrance;
	}

	public boolean isExit() {
		return exit;
	}
	
	public boolean hasRepairPack() {
		/*if (this.repairPack != null) {
			if (!this.repairPack.isUsed()) {
				return true;
			}
		}*/
		return false;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

	public void visit() {
		this.visited = true;
	}

	public void setRepairPack(RepairPack repairPack) {
		if (this.repairPack != null) return;
		this.repairPack = repairPack;
	}

	/**
	 * Sets the state to ENTRANCE<br>
	 * And returns itself
	 * @return this tile
	 */
	public MazeTile setEntrance() {
		if (!this.flag) {
			this.entrance = true;
			this.flag = true;
		}
		return this;
	}

	/**
	 * Sets the state to EXIT<br>
	 * And return itself
	 * @return this tile
	 */
	public MazeTile setExit() {
		if (!this.flag) {
			this.exit = true;
			this.flag = true;
		}
		return this;
	}

	public boolean isLocked() {
		return locked;
	}

	public void lock() {
		this.locked = true;
	}

	public JLabel getGuiTile() {
		return guiTile;
	}

	public AbsoluteConstraints getPos() {
		return pos;
	}

	public Dimension getSize() {
		return size;
	}
	
	private char getState(){
		MazeTile me = this;
		Robit robit = SceneHandler.getInstance().getRobit();
		
		if (robit == null) return 'Z';
		
		if (me.getX() == robit.getX() && me.getY() == robit.getY())
		{ return 'A'; }
		if (me.isExit())
		{ return 'B'; }
		
		if (!me.isWalkable())
		{ return 'C'; }
		
		if (me.hasRepairPack()) {
			String pack = me.getRepairPack().toString();
			if (pack.equals("10"))
			{ return 'D'; }
			if (pack.equals("5"))
			{ return 'E'; }
		}
		
		if (me.isWalkable() && me.isVisited())
		{ return 'F'; }
		
		return 'Z';
	}
	
	public final void update(){
		switch (this.getState()) {
			case 'A': this.guiTile.setBackground(Color.YELLOW);				break;
			case 'B': this.guiTile.setBackground(new Color(0, 150, 0));		break;
			case 'C': this.guiTile.setBackground(Color.RED);				break;
			case 'D': this.guiTile.setBackground(Color.BLUE);				break;
			case 'E': this.guiTile.setBackground(Color.CYAN);				break;
			case 'F': this.guiTile.setBackground(new Color(200, 200, 0));	break;
			case 'Z':
			default	: this.guiTile.setBackground(Color.GRAY);				break;
		}
	}
	
	// \u25A0 Full Square
	// \u25A1 Hollow Square
	// \u25C6 Full Diamond
	/**
	 * @deprecated no reason to use it anymore since it will update a swing component
	 * Checks for its state<br>
	 * And returns a HTML colored &lt;span&gt; accordingly<br>
	 * But requires the Robit's instance (for comparing positions)
	 * @param robit
	 * @return HTML colored &lt;span&gt;
	 */
	@Deprecated
	public String toString(Robit robit) {
		String myself = "<span style=\"color:#C0C0C0;\">\u25A0</span>";
		MazeTile me = this;
		
		if (me.getX() == robit.getX() && me.getY() == robit.getY())	{ myself = "<span style=\"color:yellow;\">\u25A0</span>"; }
		else if (me.isExit())										{ myself = "<span style=\"color:green;\">\u25A0</span>"; }
		else if (!me.isWalkable())									{ myself = "<span style=\"color:red;\">\u25A0</span>"; }
		else if (me.hasRepairPack()) {
			switch (me.getRepairPack().toString()) {
				case "5":	myself = "<span style=\"color:#00FFFF;\">\u25A0</span>"; break;
				case "10":	myself = "<span style=\"color:#00A2E8;\">\u25A0</span>"; break;
			}
		}
		else if (me.isWalkable()) {
			if (me.isVisited())	{myself = "<span style=\"color:#808040;\">\u25A0</span>";}
		}
		else {myself = "<span style=\"color:#000000;\">N/A</span>";}
		
		return myself;
	}
}
