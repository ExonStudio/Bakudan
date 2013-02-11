package com.exonstudio.bakudan.room.tile;

import com.exonstudio.bakudan.graphics.Sprite;

public class Tile {

	// TODO: Call by name not static sprite
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
