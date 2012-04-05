package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Diamond extends PegShape{

	public Diamond(int side) {
		super(side);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		if(getSide() == 3 || getSide() == 2){
			g2.setColor(new Color(238,238,238));
		}
		else{
			g2.setColor(Color.RED);
		}
		int[] xPoints = {25, 50, 25, 0};
		int[] yPoints = {0, 25, 50, 25};
		g2.fillPolygon(xPoints, yPoints, 4);
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		Diamond diamond = new Diamond(1);
		frame.add(diamond);
	}
}
