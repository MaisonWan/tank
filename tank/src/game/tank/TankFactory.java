package game.tank;

import game.tank.entity.HeavyTank;
import game.tank.entity.LightTank;
import game.tank.entity.SuperTank;
import game.tank.entity.Tank;
import game.tank.util.TankType;

public class TankFactory {
	
	/**
	 * 生成一个坦克
	 * 
	 * @param type
	 * @param x
	 * @param y
	 * @param direction
	 * @param isComputer
	 * @return
	 */
	public static Tank buildTank(TankType type, int x, int y, int direction,
			boolean isComputer) {
		if (type == TankType.MAIN_TANK) {
			return new Tank(x, y, direction, isComputer);
		} else if (type == TankType.HEAVY_TANK) {
			return new HeavyTank(x, y, direction, isComputer);
		} else if (type == TankType.LIGHT_TANK) {
			return new LightTank(x, y, direction, isComputer);
		} else if (type == TankType.SUPER_TANK) {
			return new SuperTank(x, y, direction, isComputer);
		}
		System.out.println("illegal tank type");
		return null;
	}
}
