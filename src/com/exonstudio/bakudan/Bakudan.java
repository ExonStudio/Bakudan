package com.exonstudio.bakudan;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.exonstudio.bakudan.graphics.Face;
import com.exonstudio.bakudan.graphics.SpriteSheet;
import com.exonstudio.bakudan.room.ClassicRoom;
import com.exonstudio.bakudan.room.Room;
import com.exonstudio.tools.Time;

public class Bakudan {

	public static final int WIDTH = 816;
	public static final int HEIGHT = 720;
	public static final String TITLE = "Bakudan";
	public boolean running = false;
	public long lastTick = 0;

	public int vierkantx = WIDTH / 2 - 32;
	public int vierkanty = HEIGHT / 2 - 32;
	public Face vierkantface;

	private DisplayMode size;
	public TickTimer tickTimer = new TickTimer();

	// public static TileMap map = new TileMap();
	public static Room map = new ClassicRoom(17, 15, 0);

	public Bakudan() {
		size = new DisplayMode(WIDTH, HEIGHT);

		initScreen();
		initGL();
		SpriteSheet.init();
		SpriteSheet.setRecalculate(1088, 960);
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

	public void moveVierkant() {
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			vierkantx += 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			vierkanty += 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			vierkantx -= 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			vierkanty -= 2;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
			vierkantface = Face.LEFT;
		}

		if (vierkantx < 0)
			vierkantx = 0;
		if (vierkanty < 0)
			vierkanty = 0;
	}

	public void initGL() {
		glClear(GL_COLOR_BUFFER_BIT | GL_STENCIL_BUFFER_BIT);
		glDisable(GL_DEPTH_TEST);

		glMatrixMode(GL_PROJECTION);
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glColor3f(1, 1, 1);
		glTranslatef(1, 1, 1);
		glLoadIdentity();

		glEnable(GL_TEXTURE_2D); // Enable 2D Texture Rendering
		glEnable(GL_BLEND); // Enable GL Blending
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

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
			if (Display.isCloseRequested()) {
				stop();
			} else if (!Display.isActive()) {
				// Pause game
				if (Time.calculatePassedTime(lastTick) >= 1000 / 60) {
					lastTick = Time.getTime();
					tick();
				}
				Display.update();
			} else {
				if (Time.calculatePassedTime(lastTick) >= 1000 / 60) {
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
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			stop();
		moveVierkant();
	}

	// Render zet alles op het scherm
	public void render() {
		Display.update();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		// glTranslatef(vierkantx, vierkanty, 0);
		// glRectf(-0.75f / 5, -0.75f / 5, 0.75f / 5, 0.75f / 5);
		map.render();
		// Logger.log(vierkantx + " " + vierkanty);
		SpriteSheet.draw(SpriteSheet.getSprite("test"), vierkantx, vierkanty, vierkantface);
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
