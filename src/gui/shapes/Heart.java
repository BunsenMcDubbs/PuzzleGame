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
	
	public Heart(int side, int orientation) {
		super(side, orientation);
		resetPoints();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		updateLoc();
		if(getOrientation() == 0){
			if(getSide() == 0 || getSide() == 1){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 1){
			if(getSide() == 1 || getSide() == 2){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 2){
			if(getSide() == 2 || getSide() == 3){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 3){
			if(getSide() == 0 || getSide() == 3){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
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
		if(getOrientation() == 0){
			//top facing up
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes = {new Ellipse2D.Double(0,0,26,25),
					new Ellipse2D.Double(25, 0, 25,26), null};
				double[] xPoints = {1,25,50};
				double[] yPoints = {18,50,18};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
			//top facing right
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(25, 0, 25, 26),
						new Ellipse2D.Double(25, 25, 25, 25), null};
				double[] xPoints = {33,0,33};
				double[] yPoints = {0,26,50};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		else if(getOrientation() == 1){
			//top facing down
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes = {new Ellipse2D.Double(0,25,26,25),
					new Ellipse2D.Double(25, 25, 25,26), null};
				double[] xPoints = {0,25,50};
				double[] yPoints = {33,0,33};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
			//top facing right
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(25, 0, 25, 26),
						new Ellipse2D.Double(25, 25, 25, 25), null};
				double[] xPoints = {33,0,33};
				double[] yPoints = {0,26,50};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		else if(getOrientation() == 2){
			//top facing down
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes = {new Ellipse2D.Double(0,25,26,25),
					new Ellipse2D.Double(25, 25, 25,26), null};
				double[] xPoints = {0,25,50};
				double[] yPoints = {33,0,33};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
			//top facing left
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(0, 0, 25, 26),
						new Ellipse2D.Double(0, 25, 25, 25), null};
				double[] xPoints = {17,50,17};
				double[] yPoints = {0,26,50};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		else if(getOrientation() == 3){
			//top facing up
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes = {new Ellipse2D.Double(0,0,26,25),
					new Ellipse2D.Double(25, 0, 25,26), null};
				double[] xPoints = {1,25,50};
				double[] yPoints = {18,50,18};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
			//top facing left
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(0, 0, 25, 26),
						new Ellipse2D.Double(0, 25, 25, 25), null};
				double[] xPoints = {17,50,17};
				double[] yPoints = {0,26,50};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
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
