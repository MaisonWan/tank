package game.tank.util;

/**
 * 游戏地图数据
 * 
 * @author maisonwan
 */
public class GameMap {
	
	public GameMap() {
	}

	public GameMap(int[][] data) {
		this.data = data;
		this.height = data.length;
		if (data.length > 0) {
			this.width = data[0].length;
		}
	}

	public int[][] data;
	public int height;
	public int width;
}
