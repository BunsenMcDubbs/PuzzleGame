package gui;

import java.awt.Color;
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
import gui.shapes.*;

public class PieceShape implements Shape{
	
	private Piece piece;
	private Rectangle body;
	private PegShape [] sides;
	private boolean inBoard;//Needed?
	private Point home;
	private Point loc;
	
	public PieceShape(Piece p) {
		piece = p;
		inBoard = false;
		pieceMaker();
	}

	/**
	 * Sets up the visual representation of the piece with sides
	 */
	private void pieceMaker() {
		
		body = new Rectangle(0,0,150,150);
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
	
	/**
	 * Paints the Piece on the frame
	 * @param g
	 */
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		updateLoc();
		
		g2.setColor(Color.RED);
		g2.fill(body);
		
		for(PegShape s : sides){
			s.paint(g2);
		}
		
	}
	
	private void updateLoc(){
		int xTemp = loc.x + 50;
		int yTemp = loc.y + 0;
		sides[0].setLoc(new Point(xTemp, yTemp));
		
		xTemp = loc.x + 150;
		yTemp = loc.y + 100;
		sides[1].setLoc(new Point(xTemp, yTemp));
		
		xTemp = loc.x + 50;
		yTemp = loc.y + 150;
		sides[2].setLoc(new Point(xTemp, yTemp));
		
		xTemp = loc.x + 0;
		yTemp = loc.y + 100;
		sides[3].setLoc(new Point(xTemp, yTemp));
		
		body.x = loc.x;
		body.y = loc.y + 50;
	}
	
	public Point getLoc(){
		return loc;
	}
	
	public void setLoc(Point loc){
		this.loc = loc;
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
		setLoc(home);
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
	public boolean goHome(){
		if (loc.equals(home))
			return false;
		loc = home;
		return true;
	}
	
	//TODO rewrite this method later
	@Override
	public boolean contains(Point2D p) {
		//Checks outside the "body" of the piece on the "pegs"
		for(int i = 0; i < 2; i++){
			if(sides[i].contains(p))
				return true;
		}
		//Checks if the point is inside a "hole" on the piece
		for(int i = 1; i < 4; i++){
			if(sides[i].contains(p))
				return false;
		}
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
		//TODO add the bounds of the sides as well
		return body;
	}

	@Override
	public Rectangle2D getBounds2D() {
		return getBounds();
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {return null;}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {return null;}

	@Override
	public boolean intersects(Rectangle2D arg0) {return false;}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return intersects(new Rectangle2D.Double(x,y,w,h));
	}
}
