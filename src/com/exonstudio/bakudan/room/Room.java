package com.exonstudio.bakudan.room;

import com.exonstudio.bakudan.graphics.SpriteSheet;
import com.exonstudio.bakudan.room.tile.Tile;

public class Room {

	public int blocks_width = 17;
	public int blocks_height = 15;
	public Tile[][][] blocks;

	public long millis = 0;

	public Room(int width, int height, int millis) {
		blocks_width = width;
		blocks_height = height;
		blocks = new Tile[blocks_width + 1][blocks_height + 1][3];
		this.millis = millis;
		generateLevel();
	}

	public void generateLevel() {
		for (int x = 0; x <= blocks_width; x++) {
			for (int y = 0; y <= blocks_height; y++) {
				for (int d = 0; d <= 2; d++) {
					blocks[x][y][d] = new Tile("stone");
				}
			}
		}
	}

	public void render() {
		for (int x = 0; x <= blocks_width; x++) {
			for (int y = 0; y <= blocks_height; y++) {
				for (int d = 0; d <= 2; d++) {
					blocks[x][y][d].selectSprite();
					SpriteSheet.draw(x * 64, y * 64);
				}
			}
		}
	}

}
