package br.unisul.ia.mvc.controller;

import br.unisul.ia.mvc.model.Model;
import br.unisul.ia.mvc.scene.Scene;
import java.util.Queue;

public abstract class Controller {
	
	public abstract Model getModel();
	public abstract Scene getScene();
	public abstract Queue commune();
	public abstract void commune(Queue commune);
	
}
