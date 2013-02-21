package com.exonstudio.bakudan.room.tile;

import com.exonstudio.bakudan.graphics.SpriteSheet;

public class Tile {

	String sprite;

	public static Tile stone = new StoneTile("stone");
	public static Tile test = new Tile("test");

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
