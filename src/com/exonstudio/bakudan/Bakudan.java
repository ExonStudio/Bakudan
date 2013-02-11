package com.exonstudio.bakudan;

public class Bakudan {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Bakudan";
	public boolean running = false;

	public Bakudan() {

	}

	public void init() {

	}

	public void initGL() {

	}

	public void start() {
		if (running) return;
		running = true;
		gameLoop();
	}

	public void gameLoop() {
		while (running) {
			tick();
			render();
		}
	}

	public void tick() {

	}

	public void render() {

	}

	public void stop() {
		if (!running) return;
		running = false;
		System.exit(0);
	}

	public static void main(String[] args) {
		Bakudan game = new Bakudan();
		game.start();
	}
}
