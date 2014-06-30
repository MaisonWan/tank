package game.tank.listener;

import game.tank.BulletFly;
import game.tank.MapManager;
import game.tank.entity.Bullet;
import game.tank.entity.Tank;
import game.tank.ui.TankPanel;
import game.tank.util.Consts;
import game.tank.util.Utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * ���̼�����
 * 
 * @author maisonwan
 */
public class DirectionListener extends KeyAdapter {

	private int k;
	private static Tank tank;
	/**
	 * ̹���ƶ�����0Ϊֹͣ
	 */
	private int direction = Consts.TANK_DIR_STOP;
	
	private TankPanel tankPanel;

	private Thread animation;

	public DirectionListener(TankPanel panel) {
		tankPanel = panel;
		tank = panel.getScene().getMainTank();
		animation = new Thread(new TankMoveThread());
		animation.start();
	}

	public void keyPressed(KeyEvent e) {

		if (MapManager.getInstance().getGameResult() != 0)
			return;
		k = e.getKeyCode();

		switch (k) {
		case KeyEvent.VK_UP:
			direction = Consts.TANK_DIR_UP;
			break;

		case KeyEvent.VK_DOWN:
			direction = Consts.TANK_DIR_DOWN;
			break;

		case KeyEvent.VK_LEFT:
			direction = Consts.TANK_DIR_LEFT;
			break;

		case KeyEvent.VK_RIGHT:
			direction = Consts.TANK_DIR_RIGHT;
			break;
		case KeyEvent.VK_SPACE:
			openFire();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		k = e.getKeyCode();

		switch (k) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			// �ͷŰ���ʱ��ֹͣ�ƶ�
			direction = Consts.TANK_DIR_STOP;
			break;
		}
	}
	
	public void openFire() {
		if (MapManager.getInstance().getGameResult() != 0) {
			return;
		}
		if (tank.getBullet() != null) {
			System.out.println("bullet still fly");
			return;
		}
		Bullet bullet = tank.readyTofire();
		// ���������̣߳�
		new Thread() {
			public void run() {
				BulletFly bulletFly = new BulletFly();
				bulletFly.flyBullet(tank, tankPanel.getScene());
			}
		}.start();
	}
	
	/**
	 * ��̹���ƶ��̣߳�����̹���ƶ��������ˢ��
	 */
	class TankMoveThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (direction == 0) {
					continue;
				}
				Tank main = tankPanel.getScene().getMainTank();
				Utils.moveTank(main, 16, direction, main.getSpeed(),
						tankPanel.getScene());
			}
		}

	}
	
}
