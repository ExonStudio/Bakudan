package com.exonstudio.bakudan.room;

import com.exonstudio.bakudan.room.tile.Tile;

public class Room {

	public int blocks_width = 0;
	public int blocks_height = 0;
	public Tile[] blocks;

	public long millis = 0;

	public Room(int width, int height, int millis) {
		blocks_width = width;
		blocks_height = height;
		blocks = new Tile[width * height];
		this.millis = millis;
	}

	public void generateLevel() {
		for (int y = 0; y < blocks_height; y++) {
			for (int x = 0; x < blocks_width; x++) {

			}
		}
	}

}
