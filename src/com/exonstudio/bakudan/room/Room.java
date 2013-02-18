package com.exonstudio.bakudan.room;

import com.exonstudio.bakudan.graphics.SpriteSheet;
import com.exonstudio.bakudan.room.tile.Tile;

public class Room {

	public int width;
	public int height;
	public Tile[] blocks;

	public long millis = 0;

	public Room(int width, int height, int millis) {
		this.width = width;
		this.height = height;
		this.millis = millis;
		blocks = new Tile[width * height];
		generateLevel();
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
