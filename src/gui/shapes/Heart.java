package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;


public class Heart extends PegShape{
	
	private int[] x;
	private int[] y;
	
	public Heart(int side) {
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
		g2.fill(shapes[0]);
		g2.fill(shapes[1]);
		g2.fillPolygon(x, y, 3);
	}
	
	private void updateLoc(){
		resetPoints();
		Point loc = getLoc();
		
		Shape[]	sTemp = super.shapes;
		for(Shape e : sTemp){
			Ellipse2D.Double f = (Ellipse2D.Double)e;
			f.x += loc.x;
			f.y += loc.y;
		}
		
		for(int i = 0; i < 3; i++){
			x[i] += loc.x;
			y[i] += loc.y;
		}
	}
	
	private void resetPoints(){
		if(getSide() == 0 || getSide() == 2){
			Shape[] shapes = {new Ellipse2D.Double(0,0,26,25),
				new Ellipse2D.Double(25, 0, 25,26)};
			int[] xPoints = {0,25,50};
			int[] yPoints = {18,50,18};
			super.shapes = shapes;
			this.x = xPoints;
			this.y = yPoints;
		}
		if(getSide() == 1 || getSide() == 3){
			Shape[] shapes ={new Ellipse2D.Double(25, 0, 25, 26),
					new Ellipse2D.Double(25, 25, 25, 25)};
			int[] xPoints = {33,0,33};
			int[] yPoints = {0,26,50};
			super.shapes = shapes;
			this.x = xPoints;
			this.y = yPoints;
		}
	}
	
	public static void main(String[] args){
		test.Testing.main(null);
	}


	@Override
	public boolean contains(Point2D p) {
		if(super.contains(p))
			return true;
		//TODO check with polygon shape
		return false;
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
