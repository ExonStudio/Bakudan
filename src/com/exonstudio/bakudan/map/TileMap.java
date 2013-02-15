/**
 * 
 */
package com.exonstudio.bakudan.map;

import com.exonstudio.bakudan.graphics.SpriteSheet;
import com.exonstudio.bakudan.logger.Logger;

/**
 * @author Mitchell
 * 
 */
public class TileMap {

	public Tile[][][] currentMap = new Tile[18][16][3];

	public TileMap() {
		Logger.log("Loading map");
		for (int x = 0; x <= 17; x++) {
			for (int y = 0; y <= 15; y++) {
				for (int d = 0; d <= 2; d++) {
					// Logger.log("Set " + x + " " + y + " " + d + "");
					currentMap[x][y][d] = Tile.STONE;
				}
			}
		}
	}

	public void load(String lvl) {

	}

	public void tick() {

	}

	public void render() {
		for (int x = 0; x <= 17; x++) {
			for (int y = 0; y <= 15; y++) {
				for (int d = 0; d <= 2; d++) {
					Logger.log(x + " " + y + " " + d + " ");
					currentMap[x][y][d].selectSprite();
					SpriteSheet.draw(x * 64, y * 64);
				}
			}
		}
	}
}
