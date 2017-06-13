package br.unisul.ia.deprecated.core;

import java.util.List;
import javax.swing.SwingWorker;

public class SceneHandlerWorker extends SwingWorker<Object, Object> {
	private SceneHandler handler;
	
	private SceneHandlerWorker() {}
	public SceneHandlerWorker(SceneHandler handler) {
		this.handler = handler;
	}
	
	@Override
	protected Object doInBackground() throws Exception {
		handler.getMaze().updateAll();
		while (true) {
			Thread.sleep(1_500);
			
			if (handler != null)
				if (handler.getScene() != null) {
					handler.getRobit().doStep();
					publish();
				}
		}
		
	}

	@Override
	protected void process(List chunks) {
		System.out.println("[ROBIT]<Steps> " + handler.getRobit().getSteps());
	}
}
