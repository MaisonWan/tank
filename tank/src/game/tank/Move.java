package game.tank;

import game.tank.entity.Tank;

/**
 * ̹�˵��ƶ���ʽ�� ·��ѡ���ٶȵ�
 */
public interface Move {

	/**
	 * �ƶ�̹��
	 * 
	 * @param tank ��Ҫ�ƶ���̹��
	 * @param speed �ƶ�̹�˵��ٶ�
	 * @param scene ��ǰ����Ϸ����
	 */
	public void move(Tank tank, int speed, Scene scene);
}
