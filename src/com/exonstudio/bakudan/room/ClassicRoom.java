package com.exonstudio.bakudan.room;

import com.exonstudio.bakudan.graphics.SpriteSheet;
import com.exonstudio.bakudan.room.tile.Tile;

public class ClassicRoom extends Room {

	/**
	 * @param width
	 * @param height
	 * @param millis
	 */
	public ClassicRoom(int width, int height, int millis) {
		super(width, height, millis);
	}

	public void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				blocks[x + y * width] = Tile.stone;
			}
		}
	}

	public void render() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				blocks[x + y * width].selectSprite();
				SpriteSheet.draw(x * 64, y * 64);
			}
		}
	}

}
