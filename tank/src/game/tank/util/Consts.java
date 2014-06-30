package game.tank.util;

public class Consts {

	public static final int CS = 16;

	public static final int ELEMENT_TYPE_ROAD = 0; // ENUM?
	public static final int ELEMENT_TYPE_WALL = 1;
	public static final int ELEMENT_TYPE_STEEL = 2;
	public static final int ELEMENT_TYPE_BASE = 3;
	public static final int ELEMENT_TYPE_EDGE = 4;
	public static final int ELEMENT_TYPE_NOTHING = 5;
	public static final int ELEMENT_TYPE_WHITEFLAG = 6;
	public static final int ELEMENT_TYPE_MINITANK = 7;
	public static final int ELEMENT_TYPE_LAKE = 8;
	public static final int ELEMENT_TYPE_TANK = 15;

	public static final int NORMAL_TANK_TYPE = 1;
	public static final int HEAVY_TANK_TYPE = 2;
	public static final int WIN = 1;
	public static final int LOSE = -1;
	
	/**
	 * 地图尺寸
	 */
	public static final int MAP_SIZE_WIDTH = 32;
	/**
	 * 地图尺寸
	 */
	public static final int MAP_SIZE_HEIGHT = 32;

	// 坦克移动方向
	/**
	 * 坦克移动停止
	 */
	public static final int TANK_DIR_STOP = 0;
	/**
	 * 坦克向上移动
	 */
	public static final int TANK_DIR_UP = 1;
	/**
	 * 坦克向下移动
	 */
	public static final int TANK_DIR_DOWN = 2;
	/**
	 * 坦克向左移动
	 */
	public static final int TANK_DIR_LEFT = 3;
	/**
	 * 坦克向右移动
	 */
	public static final int TANK_DIR_RIGHT = 4;
}
