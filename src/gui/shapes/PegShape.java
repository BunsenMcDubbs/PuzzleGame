package gui.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import framework.*;
import gui.*;

public abstract class PegShape implements Shape{
	
	private int side;
	private PieceShape p;
	//private Piece piece = p.getPiece() ?
	
	public PegShape(int side, PieceShape p){
		this.side = side;
		this.p = p;
	}
	
	public final int getSide(){
		return side;
	}
	
	public abstract void paint(Graphics g);
	
	@Override
	public abstract boolean contains(Point2D arg0);

	@Override
	public boolean contains(Rectangle2D arg0) {return false;}

	@Override
	public boolean contains(double x, double y) {
		Point p = new Point((int)x,(int)y);
		return contains(p);
	}

	@Override
	public boolean contains(double arg0, double arg1, double arg2, double arg3) {return false;}

	@Override
	public abstract Rectangle getBounds();

	@Override
	public Rectangle2D getBounds2D() {return null;}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {return null;}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {return null;}

	@Override
	public boolean intersects(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return intersects(new Rectangle2D.Double(x,y,w,h));
	}

}
