package br.unisul.ia;

import br.unisul.ia.mvc.AppManager;

public class App {
	
	public App(){
		AppManager.getInstance().start();
	}
	
	public static void hammerTime(int amount){
		try {
			Thread.sleep(amount);
		} catch (InterruptedException ex) {
			throw new RuntimeException("[FATAL-ERROR] Thread failed to sleep the requested amount!" + ex);
		}
	}
	
	public static void main(String[] args) {
		new App();
	}
}
