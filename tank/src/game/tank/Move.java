package game.tank;

import game.tank.entity.Tank;

/**
 * 坦克的移动方式： 路线选择，速度等
 */
public interface Move {

	/**
	 * 移动坦克
	 * 
	 * @param tank 需要移动的坦克
	 * @param speed 移动坦克的速度
	 * @param scene 当前的游戏场景
	 */
	public void move(Tank tank, int speed, Scene scene);
}
