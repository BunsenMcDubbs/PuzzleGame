package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;

public class Club extends PegShape{
	private int[] x;
	private int[] y;
	
	public Club(int side) {
		super(side);
		resetPoints();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		updateLoc();
		
		if(getSide() == 0 || getSide() == 1){
			g2.setColor(Color.RED);
		}
		else{
			g2.setColor(gui.PuzzleGameFrame.backColor);
		}
		for( Shape s : shapes ){
			g2.fill(s);
		}
	}
	
	private void updateLoc(){
		resetPoints();
		Point loc = getLoc();
		
		Shape[]	sTemp = super.shapes;
		for(int i = 0; i < 3; i++){
			Ellipse2D.Double f = (Ellipse2D.Double)shapes[i];
			f.x += loc.x;
			f.y += loc.y;
		}
		
		for(int i = 0; i < 4; i++){
			x[i] += loc.x;
			y[i] += loc.y;
		}
		rectangleMaker();
	}
	
	private void resetPoints(){
		if(getSide() == 0 || getSide() == 2){
			Shape[] shapes = {new Ellipse2D.Double(12, 0, 25, 25),
				new Ellipse2D.Double(0, 13, 25, 25),
				new Ellipse2D.Double(25, 13, 25, 25), null};
			int[] xPoints = {24,24,27,27};
			int[] yPoints = {2,52,52,2};
			super.shapes = shapes;
			this.x = xPoints;
			this.y = yPoints;
		}
		else if(getSide() == 1 || getSide() == 3){
			Shape[] shapes ={new Ellipse2D.Double(25, 12, 25, 25),
					new Ellipse2D.Double(0, 13, 25, 25), 
					new Ellipse2D.Double(12, 0, 25, 25), null};
			int[] xPoints = {0,0,40,40};
			int[] yPoints = {24,27,27,24};
			super.shapes = shapes;
			this.x = xPoints;
			this.y = yPoints;
		}
		rectangleMaker();
	}
	
	private void rectangleMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(x[0], y[0]);
		path.lineTo(x[1], y[1]);
		path.lineTo(x[2], y[2]);
		path.lineTo(x[3], y[3]);
		path.closePath();
		shapes[3] = path;
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
//			g2.fillOval(12, 0, 25, 25);
//			g2.fillOval(0, 13, 25, 25);
//			g2.fillOval(25, 13, 25, 25);
//			g2.fillRect(24, 2, 3, 50);
//		}
//		
//		else if(getSide() == 1 || getSide() == 3){
//			if(getSide() == 1){
//				g2.setColor(Color.RED);
//			}
//			else{
//				g2.setColor(new Color(238,238,238));
//			}
//			g2.fillOval(25, 12, 25, 25);
//			g2.fillOval(12, 0, 25, 25);
//			g2.fillOval(12, 25, 25, 25);
//			g2.fillRect(0, 24, 40, 3);
//		}
//		
//	}
	
	public static void main(String[] args){
		test.Testing.main(null);
//		JFrame frame = new JFrame("asdf");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		Club club = new Club(0);
//		frame.add(club);
	}


	@Override
	public boolean contains(Point2D p) {
		if(super.contains(p))
			return true;
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
