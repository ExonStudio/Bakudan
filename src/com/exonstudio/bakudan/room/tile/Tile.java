package com.exonstudio.bakudan.room.tile;

import com.exonstudio.bakudan.graphics.SpriteSheet;

public class Tile {

	String sprite;

	public Tile(String sprite) {
		this.sprite = sprite;
	}

	public void render() {
	}

	public boolean isSolid() {
		return false;
	}

	public void selectSprite() {
		SpriteSheet.setCurrentSprite(sprite);
	}

}
