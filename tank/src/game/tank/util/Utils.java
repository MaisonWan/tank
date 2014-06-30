package game.tank.util;

import game.tank.Scene;
import game.tank.TankFactory;
import game.tank.entity.Cell;
import game.tank.entity.Tank;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要一些常用工具
 * 
 * @author maisonwan
 */
public class Utils {
	
	private static int tankId = 1;
	
	/**
	 * 
	 * @param tank
	 * @param step
	 * @param direction
	 * @param speed 像素/秒
	 * @param scene
	 */
	public static void moveTank(Tank tank, int step, int direction, int speed, Scene scene) {
		List<Tank> tankList = scene.getTankList();
		tank.setDirection(direction);
		moveOneStep(direction, step, tank, tankList, speed, scene);
	}
	
	/**
	 * 移动坦克一步
	 * @param direction 方向
	 * @param step 步伐
	 * @param tank 坦克
	 * @param tankList 坦克列表
	 * @param speed 速度
	 * @param scene 场景
	 */
	private static void moveOneStep(int direction, int step, Tank tank,
			List<Tank> tankList, int speed, Scene scene) {
		//坦克副本。用来检测下一步是否发生碰撞
		Tank virtualTank = tank.copy();
		
		for(int i=0; i<step;i++){
			try {
				virtualTank.setLastPosition(new Point(virtualTank.getHorizon(),virtualTank.getVertical()));
				changeLocation(virtualTank,direction);
				if( checkCollide(virtualTank,scene.getMapElements())|| checkCollide(virtualTank,tankList) ){ 
					virtualTank.undo();
					return;
				}
				tank.setLastPosition(new Point(tank.getHorizon(),tank.getVertical()));
				changeLocation(tank,direction);		
				if(checkCollide(tank,tankList)){
					tank.undo();
				}
				Thread.sleep(1*1000/speed);  // 1px * 1000ms / speed
			}catch(Exception e){
				e.printStackTrace();
			}
		
		} // end while
		return ;
	}
	
	/**
	 * 检查是否碰撞
	 * 
	 * @param t 单元一
	 * @param c 单元二
	 * @return 
	 */
	public static boolean checkCollide(Cell t, Cell c) {
		if (t.getRectangle().intersects(c.getRectangle())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检测是否碰撞
	 * 
	 * @param c
	 * @param elements
	 * @return
	 */
	public static boolean checkCollide(Cell c, List<? extends Cell> elements) {
		boolean collide = false;
		for (Cell e : elements) {
			// 如果是空地
			if (e.getType() == 0) {
				continue;
			}
			// 检测坦克之间是否碰撞
			if (c instanceof Tank && e instanceof Tank) {
				if (((Tank) c).getId() == ((Tank) e).getId()) {
					// System.out.println("equ");
					continue;
				}
				if (((Tank) e).isAlive() == false) {
					continue;
				}
			}
			collide = checkCollide(c, e);
			if (collide) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 检测是否是队友
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean checkIfTeammate(Tank t1, Tank t2) {
		if (t1 == null || t2 == null)
			return false;
		return t1.isComputer() && t2.isComputer();
	}
	
	/**
	 * 改变方向
	 * 
	 * @param tank
	 * @param direction
	 */
	private static void changeLocation(Tank tank, int direction) {
		if (direction == Consts.TANK_DIR_UP) {
			tank.setVertical(tank.getVertical() - 1);
		} else if (direction == Consts.TANK_DIR_DOWN) {
			tank.setVertical(tank.getVertical() + 1);
		} else if (direction == Consts.TANK_DIR_LEFT) {
			tank.setHorizon(tank.getHorizon() - 1);
		} else if (direction == Consts.TANK_DIR_RIGHT) {
			tank.setHorizon(tank.getHorizon() + 1);
		}
	}

	/**
	 * 得到坦克ID
	 * 
	 * @return ID
	 */
	public static int getTankId() {
		return tankId;
	}

	/**
	 * 生成坦克的ID，并且返回之后自增一
	 * @return
	 */
	public static int getTankIdAndIncre() {
		tankId++;
		return tankId - 1;
	}
	
	/**
	 * 生成默认的坦克列表
	 * 
	 * @param type
	 * @param number
	 * @return
	 */
	public static List<Tank> buildDefaultTankList(TankType type, int number) {
		List<Tank> tankList = new ArrayList<Tank>();
		for (int i = 0; i < number; i++) {
			Tank t = TankFactory.buildTank(type, 204, 16, 2, true); // 204
			tankList.add(t);
		}
		return tankList;
	}
	
	public static Scene buildScene(int round){
		Scene sce = new Scene(round);
		Tank main = TankFactory.buildTank(TankType.MAIN_TANK, 160, 464, 1, false);
		sce.addTank(main);
		return sce;
	}
	
	public static Scene buildScene(int round, TankType type, int number) {
		Scene sce = new Scene(round);
		Tank main = TankFactory.buildTank(TankType.MAIN_TANK, 160, 464, 1, false);
		sce.addTank(main);
		List<Tank> tanks = buildDefaultTankList(type, number);
		sce.addWaitedTankList(tanks);
		return sce;
	}
}
