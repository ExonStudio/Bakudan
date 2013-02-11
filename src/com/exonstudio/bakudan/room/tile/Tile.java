package com.exonstudio.bakudan.room.tile;

import com.exonstudio.bakudan.spritesheet.Sprite;

public class Tile {

	Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render() {
	}

	public boolean isSolid() {
		return false;
	}

}
