package com.exonstudio.bakudan;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.exonstudio.bakudan.logger.Logger;
import com.exonstudio.tools.Time;

public class Bakudan {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Bakudan";
	public boolean running = false;
	public long lastTick = 0;

	private DisplayMode size;
	public TickTimer tickTimer = new TickTimer();

	public Bakudan() {
		size = new DisplayMode(WIDTH, HEIGHT);

		initScreen();
		initGL();
	}

	public void initScreen() {
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
		if (running)
			return;
		running = true;
		gameLoop();
	}

	public void gameLoop() {
		while (running) {
			Display.update();
			if (Display.isCloseRequested()) {
				stop();
			} else if (!Display.isActive()) {
				// Pause game
			} else {
				if (Time.calculatePassedTime(lastTick) >= 17) {
					lastTick = Time.getTime();
					tick();
				}
				render();
			}
		}

	}

	// Tick update de game, bijvoorbeeld coördinaten van speler en het rondlopen
	// van mobs.
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
		if (!running)
			return;
		running = false;
		System.exit(0);
	}

	public static void main(String[] args) {
		Bakudan game = new Bakudan();
		game.start();
	}
}
