package gui.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Graphical representation of a club that extends the PegShape class. It
 * can draw and keep track of its location
 */
public class Club extends PegShape{
	private int[] x;
	private int[] y;
	
	/**
	 * Constructor that receives what side this shape is and what the Piece's
	 * current orientation is
	 * @param side
	 * @param orientation
	 */
	public Club(int side, int orientation) {
		super(side, orientation);
		resetPoints();
	}
	
	/**
	 * Paints this shape
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		updateLoc();
		if(getOrientation() == 0){
			if(getSide() == 0 || getSide() == 1){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 1){
			if(getSide() == 1 || getSide() == 2){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 2){
			if(getSide() == 2 || getSide() == 3){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 3){
			if(getSide() == 0 || getSide() == 3){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}

		for( Shape s : shapes ){
			g2.fill(s);
		}
	}
	
	/**
	 * Helper method to update the points according to the current location
	 * of the shape
	 */
	private void updateLoc(){
		resetPoints();
		Point loc = getLoc();
		
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
	
	/**
	 * Resets the points back to the default location (top left 0,0)
	 */
	private void resetPoints(){
		if(getOrientation() == 0){
			//top facing up
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
			//top facing right
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(25, 12, 25, 25),
						new Ellipse2D.Double(12, 0, 25, 25), 
						new Ellipse2D.Double(12, 25, 25, 25), null};
				int[] xPoints = {0,0,40,40};
				int[] yPoints = {24,27,27,24};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		else if(getOrientation() == 1){
			//top facing down
			if(getSide() == 0 || getSide() == 2){
						Shape[] shapes ={new Ellipse2D.Double(12, 25, 25, 25),
						new Ellipse2D.Double(0, 12, 25, 25), 
						new Ellipse2D.Double(25, 12, 25, 25), null};
				int[] xPoints = {24,24,27,27};
				int[] yPoints = {0,50,50,0};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
			//top facing right
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(25, 12, 25, 25),
						new Ellipse2D.Double(12, 0, 25, 25), 
						new Ellipse2D.Double(12, 25, 25, 25), null};
				int[] xPoints = {0,0,40,40};
				int[] yPoints = {24,27,27,24};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		else if(getOrientation() == 2){
			//top facing down
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes ={new Ellipse2D.Double(12, 25, 25, 25),
						new Ellipse2D.Double(0, 12, 25, 25), 
						new Ellipse2D.Double(25, 12, 25, 25), null};
				int[] xPoints = {24,24,27,27};
				int[] yPoints = {0,50,50,0};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
			//top facing left
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(0, 12, 25, 25),
						new Ellipse2D.Double(13, 0, 25, 25), 
						new Ellipse2D.Double(13, 25, 25, 25), null};
				int[] xPoints = {5,5,50,50};
				int[] yPoints = {24,27,27,24};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		else if(getOrientation() == 3){
			//top facing up
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
			//top facing left
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes ={new Ellipse2D.Double(0, 12, 25, 25),
						new Ellipse2D.Double(13, 0, 25, 25), 
						new Ellipse2D.Double(13, 25, 25, 25), null};
				int[] xPoints = {5,5,50,50};
				int[] yPoints = {24,27,27,24};
				super.shapes = shapes;
				this.x = xPoints;
				this.y = yPoints;
			}
		}
		rectangleMaker();

	}
	
	/**
	 * Helper
	 */
	private void rectangleMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(x[0], y[0]);
		path.lineTo(x[1], y[1]);
		path.lineTo(x[2], y[2]);
		path.lineTo(x[3], y[3]);
		path.closePath();
		shapes[3] = path;
	}

	
	@Override
	public boolean contains(Point2D p) {
		return super.contains(p);
	}

	/**
	 * Deprecated
	 */
	@Override
	public Rectangle getBounds() {return null;}

}
