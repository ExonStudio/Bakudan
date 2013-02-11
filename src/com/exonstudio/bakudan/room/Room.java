package com.exonstudio.bakudan.room;

public class Room {

	public int blocks_width = 0;
	public int blocks_height = 0;
	public int[] blocks;

	public long millis = 0;

	public Room(int width, int height, int millis) {
		blocks_width = width;
		blocks_height = height;
		blocks = new int[width * height];
		this.millis = millis;
	}

}
