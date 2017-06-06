package br.unisul.ia.core;

import br.unisul.ia.entity.Maze;
import br.unisul.ia.entity.Robit;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		boolean success = false;
		while (!success) {
			// Square Matrix (AxA)
			String mazeSizeRaw = JOptionPane.showInputDialog(null, "Maze Order");
			int mazeSize = 0;
			if (!mazeSizeRaw.isEmpty()) mazeSize = Integer.parseInt(mazeSizeRaw);

			// Max energy of our ROBIT
			String maxEnergyRaw = JOptionPane.showInputDialog(null, "Robit's max energy");
			int maxEnergy = 0;
			if (!maxEnergyRaw.isEmpty()) maxEnergy = Integer.parseInt(maxEnergyRaw);

			// -1 for Closing the Window; 0 for YES; 1 for NO;
			int option = JOptionPane.showOptionDialog(null, "Robit can exceed maximum energy?", "Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

			if (
				(mazeSize > 0)				&&
				(maxEnergy > 0)				&&
				(option > -2 && option < 2)
			) {
				success = true;
				// If Robit can gain more than the maximum energy
				boolean canExceed;
				switch (option) {
					case -1:					return;
					case 0:	canExceed = true;	break;
					case 1:	canExceed = false;	break;
					default:					return;
				}
				Robit robit = new Robit(maxEnergy, canExceed);	// Our ROBIT! :D
				Maze maze;										// Our MAZE!
				try { maze = new Maze(robit, mazeSize); } catch (InstantiationException e) { success = false; JOptionPane.showMessageDialog(null, e.getMessage()); continue; }
				maze.runRobit();								// Make it run like the WIND!
			} else {
				JOptionPane.showMessageDialog(null, "ERROR! One or more inputs are not valid!");
			}
		}
	}
}
