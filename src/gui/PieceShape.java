package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import framework.*;

public class PieceShape implements Shape{
	
	private Piece piece;
	private Rectangle body;
	private PegShape [] sides;
	private boolean inBoard;//Needed?
	private Point2D home;
	
	public PieceShape(Piece p, Point2D home) {
		piece = p;
		inBoard = false;
		setHome(home);
		pieceMaker();
	}
	
	/**
	 * Sets up the visual representation of the piece with sides
	 */
	private void pieceMaker() {
		
		body = new Rectangle(50,50,100,100);
		sides = new PegShape[4];
		
		for(int i = 0; i < 4; i++){
			setSide(i, piece.getSide(i));
		}
		
	}
	
	/**
	 * Sets the sides of the PieceShape using the PegShape's child classes
	 * @param dir
	 * @param s
	 */
	// TODO send the pegShapes the pieceShape
	private void setSide(int dir, Side s){
		PegShape shape;
		int val = Math.abs(s.getValue());
		switch(val){
		case Side.inClub:	sides[dir] = new Club(dir); break;
		case Side.inDiamond:sides[dir] = new Diamond(dir); break;
		case Side.inHeart:	sides[dir] = new Heart(dir); break;
		case Side.inSpade:	sides[dir] = new Spade(dir); break;
		}
	}
	
	/**
	 * Rotates the piece one way or another depending on a boolean
	 * @param clockwise
	 * @return current orientation ( 0 = north, 1 = east, 2 = south, 3 = west)
	 */
	public int rotate(boolean clockwise){
		if (clockwise){
			piece.rotateClockwise();
		}
		else{
			piece.rotateCounterClockwise();
		}
		pieceMaker();
		return piece.getOrientation();
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
		for(PegShape s : sides){
			// TODO make pegShape a shape
			//g2.draw(g2);
		}
		
	}
	
	/**
	 * Returns true if the Piece is currently in the Board
	 * @return
	 */
	public boolean isInBoard(){
		return inBoard;
	}
	
	// TODO deprecate?
	public void setInBoard(boolean tf){
		inBoard = tf;
	}
	
	public boolean toggleInBoard(){
		inBoard = !inBoard;
		return inBoard;
	}
	
	public Piece getPiece(){
		return piece;
	}

	public void setHome(Point home) {
		this.home = home;
	}
	
	public void setHome(Point2D home){
		int x = (int) home.getX();
		int y = (int) home.getY();
		setHome(new Point(x,y));
	}
	
	/**
	 * Moves the pieces back to their home locations
	 * @return <code>true</code> if the pieces needed to move (not already at
	 * their home location) or <code>false</code> if the piece was already there
	 */
	public boolean returnHome(){
		return false;
	}
	
	//TODO rewrite this method later
	@Override
	public boolean contains(Point2D p) {
		return body.contains(p);
	}

	@Override
	public boolean contains(Rectangle2D r) {return false;}

	@Override
	public boolean contains(double x, double y) {
		Point p = new Point((int)x,(int)y);
		return contains(p);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {return false;}

	@Override
	public Rectangle getBounds() {
		return body;
	}

	@Override
	public Rectangle2D getBounds2D() {
		return body;
	}

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
