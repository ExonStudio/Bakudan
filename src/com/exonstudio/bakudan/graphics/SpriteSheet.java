package com.exonstudio.bakudan.graphics;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class SpriteSheet {
	private static Texture spritesheet;
	private static Map<String, Sprite> spriteMap = new HashMap<String, Sprite>();
	private static Sprite currentSprite;

	public static void init() {
		loadSheet("gfx");
	}

	private static void loadSheet(String name) {
		loadSheetImage(name, "png");
		loadSheetData(name, "xml");
	}

	private static void loadSheetData(String fname, String ext) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(SpriteSheet.class.getResourceAsStream("/img/" + fname + "." + ext));
			Element root = document.getRootElement();
			for (Object spriteObject : root.getChildren()) {
				Element spriteElement = (Element) spriteObject;
				String name = spriteElement.getAttributeValue("n");
				int x = spriteElement.getAttribute("x").getIntValue();
				int y = spriteElement.getAttribute("y").getIntValue();
				int w = spriteElement.getAttribute("w").getIntValue();
				int h = spriteElement.getAttribute("h").getIntValue();
				String a = spriteElement.getAttribute("a").getValue();
				Sprite sprite = new Sprite(name, x, y, w, h, a);
				spriteMap.put(sprite.getName(), sprite);
				// Console.log("Loaded SpriteSheet data for " +
				// sprite.getName());
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheetImage(String name, String ext) {
		try {
			spritesheet = TextureLoader.getTexture(ext.toUpperCase(), SpriteSheet.class.getResourceAsStream("/img/" + name + "." + ext));
			// Console.log("Loaded SpriteSheet");
		} catch (IOException e) {
			// Console.log(e.getMessage());
		}
	}

	public static void draw(Sprite sprite, int x, int y) {
		draw(sprite, x, y, sprite.getWidth(), sprite.getHeight(), 0);
	}

	public static void draw(Sprite sprite, int x, int y, int r) {
		draw(sprite, x, y, sprite.getWidth(), sprite.getHeight(), r);
	}

	public static void draw(int x, int y) {
		draw(currentSprite, x, y, currentSprite.getWidth(), currentSprite.getHeight(), 0);
	}

	public static void draw(int x, int y, int r) {
		draw(currentSprite, x, y, currentSprite.getWidth(), currentSprite.getHeight(), r);
	}

	public static void draw(int x, int y, int w, int h) {
		draw(currentSprite, x, y, w, h, 0);
	}

	public static void draw(int x, int y, int w, int h, int r) {
		draw(currentSprite, x, y, w, h, r);
	}

	public static void draw(Sprite sprite, int x, int y, int w, int h) {
		draw(sprite, x, y, w, h, 0);
	}

	public static void draw(Sprite sprite, int x, int y, int w, int h, int r) {
		// glEnable(GL_TEXTURE_RECTANGLE_ARB);
		spritesheet.bind();

		double Tx = (sprite.getX() * 1.0) / spritesheet.getTextureWidth();
		double Ty = (sprite.getY() * 1.0) / spritesheet.getTextureHeight();
		double Tx2 = (sprite.getX() * 1.0 + sprite.getWidth()) / spritesheet.getTextureWidth();
		double Ty2 = (sprite.getY() * 1.0 + sprite.getHeight()) / spritesheet.getTextureHeight();
		// x *= 2;
		// y *= 2;

		if (r != 0) {
			glRotated(r, 0.0, 0.0, 1.0);
		}

		glLoadIdentity();
		glBegin(GL_QUADS);
		glTexCoord2d(Tx, Ty);
		glVertex2d(x, y);
		glTexCoord2d(Tx2, Ty);
		glVertex2d(x + w, y);
		glTexCoord2d(Tx2, Ty2);
		glVertex2d(x + w, y + h);
		glTexCoord2d(Tx, Ty2);
		glVertex2d(x, y + h);
		glEnd();

		// glBindTexture(GL_TEXTURE_RECTANGLE_ARB, 0);
		// glDisable(GL_TEXTURE_RECTANGLE_ARB);
	}

	public static Sprite getSprite(String name) {
		return spriteMap.get(name);
	}

	public static void setCurrentSprite(String name) {
		currentSprite = getSprite(name);
	}
}
