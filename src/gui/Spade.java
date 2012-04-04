package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;


public class Spade extends PegShape{

	public Spade(int side) {
		super(side);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(getSide() == 1 || getSide() == 3){
			if(getSide() == 1){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(22, 22, 23, 22);
			g2.fillOval(44, 22, 22, 22);
			int[] xPoints = {23,44,65};
			int[] yPoints = {29,4,29};
			g2.fillPolygon(xPoints, yPoints, 3);
			g2.fillRect(43,7,4,43);
			int[] xPointsBottom = {39, 45,50};
			int[] yPointsBottom = {50,43,50};
			g2.fillPolygon(xPointsBottom,yPointsBottom,3);
		}
		else if(getSide() == 2 || getSide() == 4){
			if(getSide() == 2){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(25, 25, 25, 26);
			g2.fillOval(25, 50, 25, 25);
			int[] xPoints = {32,4,32};
			int[] yPoints = {26,51,74};
			g2.fillPolygon(xPoints, yPoints, 3);
			g2.fillRect(5,49,50,4);
		}
		

	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		Spade spade = new Spade(1);
		frame.add(spade);
	}

}
