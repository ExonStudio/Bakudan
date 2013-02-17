package com.exonstudio.bakudan.room;

import com.exonstudio.bakudan.graphics.SpriteSheet;
import com.exonstudio.bakudan.room.tile.Tile;

public class Room {

	public int blocks_width = 17;
	public int blocks_height = 15;
	public Tile[] blocks;

	public long millis = 0;

	public Room(int width, int height, int millis) {
		blocks_width = width;
		blocks_height = height;
		blocks = new Tile[blocks_height * blocks_width];
		this.millis = millis;
		generateLevel();
	}

	public void generateLevel() {
		for (int x = 0; x < blocks_width; x++) {
			for (int y = 0; y < blocks_height; y++) {
				blocks[x * y] = new Tile("stone");
			}
		}
	}

	public void render() {
		for (int x = 0; x < blocks_width; x++) {
			for (int y = 0; y < blocks_height; y++) {
				blocks[x * y].selectSprite();
				SpriteSheet.draw(x * 64, y * 64);
			}
		}
	}

}
