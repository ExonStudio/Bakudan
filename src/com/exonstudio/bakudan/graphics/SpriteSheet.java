package com.exonstudio.bakudan.graphics;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.exonstudio.bakudan.logger.Logger;

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
			Document document = builder.build(SpriteSheet.class.getResourceAsStream("/textures/" + fname + "." + ext));
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
				Logger.log("Loaded SpriteSheet data for " + sprite.getName());
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheetImage(String name, String ext) {
		try {
			spritesheet = TextureLoader.getTexture(ext.toUpperCase(), SpriteSheet.class.getResourceAsStream("/textures/" + name + "." + ext));
			Logger.log("Loaded SpriteSheet");
		} catch (IOException e) {
			Logger.log(e.getMessage());
		}
	}

	public static void draw(Sprite sprite, int x, int y) {
		draw(sprite, x, y, sprite.getWidth(), sprite.getHeight(), Face.TOP);
	}

	public static void draw(Sprite sprite, int x, int y, Face f) {
		draw(sprite, x, y, sprite.getWidth(), sprite.getHeight(), f);
	}

	public static void draw(int x, int y) {
		draw(currentSprite, x, y, currentSprite.getWidth(), currentSprite.getHeight(), Face.TOP);
	}

	public static void draw(int x, int y, Face f) {
		draw(currentSprite, x, y, currentSprite.getWidth(), currentSprite.getHeight(), f);
	}

	public static void draw(int x, int y, int w, int h) {
		draw(currentSprite, x, y, w, h, Face.TOP);
	}

	public static void draw(int x, int y, int w, int h, Face f) {
		draw(currentSprite, x, y, w, h, f);
	}

	public static void draw(Sprite sprite, int x, int y, int w, int h) {
		draw(sprite, x, y, w, h, Face.RIGHT);
	}

	public static void draw(Sprite sprite, int x, int y, int w, int h, Face f) {
		// glEnable(GL_TEXTURE_RECTANGLE_ARB);
		glPushMatrix();
		spritesheet.bind();

		float x2 = (float) (1.0 / Display.getWidth() * x) - Display.getWidth() / 2;
		float y2 = (float) (1.0 / Display.getHeight() * y) - Display.getWidth() / 2;
		float w2 = (float) (1.0 / Display.getWidth() * w);
		float h2 = (float) (1.0 / Display.getHeight() * h);

		float Tx = (float) ((sprite.getX() * 1.0) / spritesheet.getTextureWidth());
		float Ty = (float) ((sprite.getY() * 1.0) / spritesheet.getTextureHeight());
		float Tx2 = (float) ((sprite.getX() * 1.0 + sprite.getWidth()) / spritesheet.getTextureWidth());
		float Ty2 = (float) ((sprite.getY() * 1.0 + sprite.getHeight()) / spritesheet.getTextureHeight());

		glLoadIdentity();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(Tx, Ty);
			glVertex2f(x2, y2);
			glTexCoord2f(Tx2, Ty);
			glVertex2f(x2 + w2, y2);
			glTexCoord2f(Tx2, Ty2);
			glVertex2f(x2 + w2, y2 + h2);
			glTexCoord2f(Tx, Ty2);
			glVertex2f(x2, y2 + h2);
		}
		glEnd();
		glPopMatrix();
	}

	public static Sprite getSprite(String name) {
		return spriteMap.get(name);
	}

	public static void setCurrentSprite(String name) {
		currentSprite = getSprite(name);
	}
}
