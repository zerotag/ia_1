package br.unisul.ia.mvc.controller;

import br.unisul.ia.mvc.AppManager;
import br.unisul.ia.mvc.model.Main;
import br.unisul.ia.mvc.scene.MainScene;
import java.util.LinkedList;
import java.util.Queue;

public class MainSceneController extends Controller {
	
	private final Main main;
	private final MainScene scene;
	
	private final Queue communeQueue;
	
	public MainSceneController(Main main, MainScene scene){
		this.main = main;
		this.scene = scene;
		this.communeQueue = new LinkedList();
	}
	
	@Override
	public Main getModel() {
		return main;
	}
	
	@Override
	public MainScene getScene() {
		return scene;
	}
	
	public void commune(int size, int health, boolean exceed){
		this.communeQueue.add(size);
		this.communeQueue.add(health);
		this.communeQueue.add(exceed);
		
		AppManager.getInstance().communeWithTwin(this);
		
		this.communeQueue.clear();
	}
	
	@Override
	public Queue commune() {
		return communeQueue;
	}

	@Override
	public void commune(Queue commune) {
		throw new RuntimeException("[FATAL-ERROR] Current Scene doesn't allow inbound commune!" + commune);
	}
	
}
