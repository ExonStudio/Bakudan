package com.exonstudio.bakudan;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.exonstudio.bakudan.logger.Logger;

public class Bakudan {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Bakudan";
	public boolean running = false;

	private DisplayMode size;

	public Bakudan() {
		size = new DisplayMode(WIDTH, HEIGHT);
		init();
		initGL();
	}

	public void init() {
		try {
			Display.setDisplayMode(size);
			Display.setTitle(TITLE);
			Display.setVSyncEnabled(true);
			Display.setResizable(false);
			Display.setFullscreen(false);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public void initGL() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);

		glMatrixMode(GL_PROJECTION);
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glColor3f(1, 1, 1);
		glTranslatef(1, 1, 1);
		glLoadIdentity();

		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}

	public void start() {
		if (running) return;
		running = true;
		gameLoop();
	}

	// TODO: Mitchell stel even de juiste tick time etc. in?
	public void gameLoop() {
		while (running) {
			if (Display.isCloseRequested()) {
				running = false;
				return;
			}
			Display.sync(60);
			tick();
			render();
		}
	}
	
	// Tick update de game, bijvoorbeeld coördinaten van speler en het rondlopen van mobs.
	public void tick() {
		Logger.log("TICK");
	}

	// Render zet alles op het scherm
	public void render() {
		Display.update();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glRectf(-0.75f / 30, -0.75f / 30, 0.75f / 30, 0.75f / 30);
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
