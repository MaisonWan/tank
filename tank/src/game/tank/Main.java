package game.tank;

import game.tank.listener.DirectionListener;
import game.tank.listener.FireMouseListener;
import game.tank.ui.TankPanel;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setTitle("坦克大战");
		TankPanel panel = new TankPanel();
		panel.setFrame(frame);
		Container contentPane = frame.getContentPane();
		contentPane.add(panel);
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// 居中显示
		int winWidth = frame.getWidth();
		int winHeight = frame.getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		int screenWidth = kit.getScreenSize().width;
		int screenHeight = kit.getScreenSize().height;
		frame.setLocation((screenWidth - winWidth) / 2, (screenHeight - winHeight) / 2);
		
		// 添加监听器
		FireMouseListener fireListener = new FireMouseListener(panel);
		frame.addKeyListener(new DirectionListener(panel));
		frame.addMouseListener(fireListener);
		frame.setFocusable(true); // this line is necessary
	}
}
