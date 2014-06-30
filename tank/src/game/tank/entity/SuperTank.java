package game.tank.entity;

import game.tank.ImageManager;

public class SuperTank extends Tank {

	
	public SuperTank(int horizon, int vertical, int direction, boolean computer) {
		super(horizon, vertical, direction, computer);
		img = ImageManager.getInstance().getHeavyTank();
		hp = 3;
		speed = 200;
	}

}
