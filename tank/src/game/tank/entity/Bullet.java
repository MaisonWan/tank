package game.tank.entity;

import game.tank.ImageManager;
import game.tank.util.Consts;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet extends Cell {

	public static final double SPEED = 200; // 单位：像素/毫秒
	private int status = BUULET_STATE_FLYING; // 1-blast,0-flying
	/**
	 * 子弹已经爆炸
	 */
	public static final int BUULET_STATE_BLAST = 1;
	/**
	 * 子弹飞行中
	 */
	public static final int BUULET_STATE_FLYING = 0;
	private int direction = 0;
	private double degree = 0;

	public Bullet(int horizon, int vertical) {
		this.horizon = horizon;
		this.vertical = vertical;
		img = ImageManager.getInstance().getBullet();
		rectangle = new Rectangle(horizon, vertical, img.getWidth(null) + 3,
				img.getHeight(null) + 3);
	}

	public void drawSelf(Graphics2D g2d) {
		int width = getImg().getWidth(null);
		int height = getImg().getHeight(null);
		g2d.rotate(degree, horizon + width / 2, vertical + height / 2);
		g2d.drawImage(getImg(), horizon, vertical, null);
		g2d.rotate(-degree, horizon + width / 2, vertical + height / 2);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDirection() {
		return direction;
	}

	/**
	 * 设置方向，同时调整子弹的角度
	 * 
	 * @param direction 方向
	 */
	public void setDirection(int direction) {
		this.direction = direction;
		if (direction == Consts.TANK_DIR_UP) {
			degree = 0;
		} else if (direction == Consts.TANK_DIR_DOWN) {
			degree = Math.PI;
		} else if (direction == Consts.TANK_DIR_LEFT) {
			degree = -Math.PI / 2;
		} else if (direction == Consts.TANK_DIR_RIGHT) {
			degree = Math.PI / 2;
		}
	}
}
