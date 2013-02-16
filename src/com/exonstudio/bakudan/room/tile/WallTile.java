package com.exonstudio.bakudan.room.tile;

public class WallTile extends Tile {

	/**
	 * @param sprite
	 */
	public WallTile(String sprite) {
		super(sprite);
	}

	public boolean isSolid() {
		return true;
	}

}
