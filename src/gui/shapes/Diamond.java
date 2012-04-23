package gui.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Graphical representation of a diamond that extends the PegShape class. It
 * can draw and keep track of its location
 */
public class Diamond extends PegShape{

	private int[] x;
	private int[] y;
	
	/**
	 * Constructor that receives what side this shape is and what the Piece's
	 * current orientation is
	 * @param side
	 * @param orientation
	 */
	public Diamond(int side, int orientation) {
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
		
		for(int i = 0; i < 4; i++){
			x[i] += loc.x;
			y[i] += loc.y;
		}
		diamondMaker();
	}
	/**
	 * Resets the points back to the default location (top left 0,0)
	 */
	private void resetPoints(){
		Shape[] shapes = {null};
		super.shapes = shapes;
		int[] xPoints = {25, 50, 25, 0};
		int[] yPoints = {0, 25, 50, 25};
		this.x = xPoints;
		this.y = yPoints;
		diamondMaker();
	}
	/**
	 * Helper
	 */
	private void diamondMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(x[0], y[0]);
		path.lineTo(x[1], y[1]);
		path.lineTo(x[2], y[2]);
		path.lineTo(x[3], y[3]);
		path.closePath();
		shapes[0] = path;
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
