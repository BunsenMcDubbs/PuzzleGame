package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Abstract class that, when inherited, will be a graphical representation of a
 * type of side or just other complex shape
 */
public abstract class PegShape implements Shape{
	
	protected Shape[] shapes;
	private int side;
	private int orientation;
	private Point loc;
	protected Color c = Color.RED;// TODO
	
	/**
	 * Constructor that receives what side this shape is and what the Piece's
	 * current orientation is
	 * @param side
	 * @param orientation
	 */
	public PegShape(int side, int orientation){
		this.orientation = orientation;
		this.side = side;
	}
	
	/**
	 * Returns the orientation
	 * @return
	 */
	public int getOrientation(){
		return orientation;
	}
	
	/**
	 * returns the side
	 * @return
	 */
	public final int getSide(){
		return side;
	}
	
	/**
	 * returns the location
	 * @return
	 */
	public Point getLoc(){
		return loc;
	}
	
	/**
	 * sets the location
	 * @param loc
	 */
	public void setLoc(Point loc){
		this.loc = loc;
	}
	
	/**
	 * sets the color
	 * @param c
	 */
	public void setColor(Color c){
		this.c = c;
	}
	
	public abstract void paint(Graphics g);
	
	/**
	 * Checks if the point is contained in the shape
	 */
	@Override
	public boolean contains(Point2D p){
		for( Shape s : shapes ){
			if(s.contains(p))
				return true;
		}
		return false;
	}

	/**
	 * Deprecated
	 */
	@Override
	public boolean contains(Rectangle2D arg0) {return false;}

	@Override
	public boolean contains(double x, double y) {
		Point p = new Point((int)x,(int)y);
		return contains(p);
	}

	/**
	 * Deprecated
	 */
	@Override
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {return false;}

	@Override
	public abstract Rectangle getBounds();
	/**
	 * Deprecated
	 */
	@Override
	public Rectangle2D getBounds2D() {return null;}
	/**
	 * Deprecated
	 */
	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {return null;}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {return null;}
	/**
	 * Deprecated
	 */
	@Override
	public boolean intersects(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Deprecated
	 */
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return intersects(new Rectangle2D.Double(x,y,w,h));
	}

}
