package com.exonstudio.bakudan.room.tile;

import com.exonstudio.bakudan.spritesheet.Sprite;

public class WallTile extends Tile {

	/**
	 * @param sprite
	 */
	public WallTile(Sprite sprite) {
		super(sprite);
	}

	public boolean isSolid() {
		return true;
	}

}
