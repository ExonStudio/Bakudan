package com.exonstudio.bakudan.map;

import com.exonstudio.bakudan.graphics.SpriteSheet;

public enum Tile {
	STONE("STONE", "stone1", "stone", true, false);

	private String name;
	private String spriteName;
	private String displayName;
	private boolean decoration;
	private boolean breakable;

	Tile(String name, String spriteName, String displayName, boolean decoration, boolean breakable) {
		this.name = name;
		this.spriteName = spriteName;
		this.displayName = displayName;
		this.breakable = breakable;
	}

	public int getID() {
		return this.ordinal();
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public boolean isBreakable() {
		return breakable;
	}

	public void selectSprite() {
		SpriteSheet.setCurrentSprite(spriteName);
	}
}
