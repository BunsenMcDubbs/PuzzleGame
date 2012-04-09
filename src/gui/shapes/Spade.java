package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;


public class Spade extends PegShape{
	private int[] x1;
	private int[] y1;
	private int[] x2;
	private int[] y2;
	
	public Spade(int side) {
		super(side);
		resetPoints();
	}

//	public void paint(Graphics g) {
//		Graphics2D g2 = (Graphics2D) g;
//		if(getSide() == 0 || getSide() == 2){
//			if(getSide() == 0){
//				g2.setColor(Color.RED);
//			}
//			else{
//				g2.setColor(new Color(238,238,238));
//			}
//			g2.fillOval(0, 22, 26, 20);
//			g2.fillOval(25, 22, 25, 20);
//			int[] xPoints = {0,25,50};
//			int[] yPoints = {29,0,29};
//			g2.fillPolygon(xPoints, yPoints, 3);
//			g2.fillRect(24,7,4,43);
//			int[] xPointsBottom = {20,26,31};
//			int[] yPointsBottom = {50,43,50};
//			g2.fillPolygon(xPointsBottom,yPointsBottom,3);
//		}
//		else if(getSide() == 1 || getSide() == 3){
//			if(getSide() == 1){
//				g2.setColor(Color.RED);
//			}
//			else{
//				g2.setColor(new Color(238,238,238));
//			}
//			g2.fillOval(8, 0, 20, 26);
//			g2.fillOval(8, 25, 20, 25);
//			int[] xPoints = {21,50,21};
//			int[] yPoints = {0,25,50};
//			g2.fillPolygon(xPoints, yPoints, 3);
//			g2.fillRect(4,24,40,4);
//			int[] xPointsBottom = {0,7,0};
//			int[] yPointsBottom = {20,26,31};
//			g2.fillPolygon(xPointsBottom,yPointsBottom,3);
//		}
//
//	}
	
	public static void main(String[] args){
//		JFrame frame = new JFrame("asdf");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		Spade spade = new Spade(1);
//		frame.add(spade);
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
