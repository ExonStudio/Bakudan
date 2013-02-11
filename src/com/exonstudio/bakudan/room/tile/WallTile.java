package com.exonstudio.bakudan.room.tile;

import com.exonstudio.bakudan.graphics.Sprite;

public class WallTile extends Tile {

	/**
	 * @param sprite
	 */
	public WallTile(Sprite sprite) {
		// TODO: Call by name not static sprite
		super(sprite);
	}

	public boolean isSolid() {
		return true;
	}

}
