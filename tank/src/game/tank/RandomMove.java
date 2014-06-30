package game.tank;

import game.tank.entity.Tank;
import game.tank.util.Utils;

/**
 * 随机移动，本方法暂时采用随机，其实可以写AI来处理
 * 
 * @author maisonwan
 */
public class RandomMove implements Move {

	public void move(Tank tank, int speed, Scene scene) {
		int direction = (int) Math.round(Math.random() * 4);
		if (direction == 0) {
			direction = 4;
		}
		// if(direction != 0) {
		int step = (int) Math.round(Math.random() * 96);
		Utils.moveTank(tank, step, direction, speed, scene);
		// }
	}
}
