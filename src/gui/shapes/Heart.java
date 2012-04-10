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
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;


public class Heart extends PegShape{
	
	private double[] x;
	private double[] y;
	
	public Heart(int side, double ratio) {
		super(side, ratio);
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
		for(int i = 0; i < 2; i++){
			Ellipse2D.Double f = (Ellipse2D.Double)shapes[i];
			f.x += loc.x;
			f.y += loc.y;
		}
		
		for(int i = 0; i < 3; i++){
			x[i] += loc.x;
			y[i] += loc.y;
		}
		triangleMaker();
	}
	
	private void resetPoints(){
		if(getSide() == 0 || getSide() == 2){
			Shape[] shapes = {new Ellipse2D.Double(0,0,26,25),
				new Ellipse2D.Double(25, 0, 25,26), null};
			double[] xPoints = {0*ratio,25*ratio,50*ratio};
			double[] yPoints = {18*ratio,50*ratio,18*ratio};
			super.shapes = shapes;
			this.x = xPoints;
			this.y = yPoints;
		}
		if(getSide() == 1 || getSide() == 3){
			Shape[] shapes ={new Ellipse2D.Double(25*ratio, 0*ratio, 25*ratio, 26*ratio),
					new Ellipse2D.Double(25*ratio, 25*ratio, 25*ratio, 25*ratio), null};
			double[] xPoints = {33*ratio,0*ratio,33*ratio};
			double[] yPoints = {0*ratio,26*ratio,50*ratio};
			super.shapes = shapes;
			this.x = xPoints;
			this.y = yPoints;
		}
		triangleMaker();
	}
	
	private void triangleMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(x[0], y[0]);
		path.lineTo(x[1], y[1]);
		path.lineTo(x[2], y[2]);
		path.closePath();
		shapes[2] = path;
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
