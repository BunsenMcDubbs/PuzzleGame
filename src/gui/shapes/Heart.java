package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;


public class Heart extends PegShape{

	public Heart(int side, PieceShape p) {
		super(side, p);
	}

	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(getSide() == 0 || getSide() == 2){
			if(getSide() == 0){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(0,0,26,25);
			g2.fillOval(25, 0, 25,25);
			int[] xPoints = {1,26,49};
			int[] yPoints = {18,50,18};
			g2.fillPolygon(xPoints, yPoints, 3);
		}
		if(getSide() == 1 || getSide() == 3){
			if(getSide() == 1){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(25, 0, 25, 26);
			g2.fillOval(25, 25, 25, 25);
			int[] xPoints = {33,0,33};
			int[] yPoints = {1,26,49};
			g2.fillPolygon(xPoints, yPoints, 3);
		}
	}
	
	public static void main(String[] args){
//		JFrame frame = new JFrame("asdf");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		Heart heart = new Heart(1, null);
//		frame.add(heart);
	}


	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
