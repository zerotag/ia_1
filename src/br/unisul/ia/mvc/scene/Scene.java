package br.unisul.ia.mvc.scene;

import br.unisul.ia.mvc.controller.Controller;
import javax.swing.JFrame;

public abstract class Scene extends JFrame {
	
	public Scene(){}
	
	public abstract void setController(Controller controller);
	
	public void run(){
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			throw new RuntimeException("[FATAL-ERROR] MainScene's LookAndFeel failed to initialize!" + ex);
		}
		
		this.setVisible(true);
	}
	
}
