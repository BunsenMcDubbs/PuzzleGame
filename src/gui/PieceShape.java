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

/**
 * PieceShape is the graphical representation of a <code>Piece</code> and implements the
 * Shape interface, although many of the Shape methods are deprecated. It draws the pegs
 * using the Shapes in the gui.shapes package.
 *
 */
public class PieceShape implements Shape{
	
	private Piece piece;
	private Rectangle body;
	private PegShape [] sides;
	private Point home;
	private Point loc;
	private Color c;
	
	private Board board;
	private Point boardLoc;
	
	public PieceShape(Piece p) {
		piece = p;
		pieceMaker();
	}

	/**
	 * Sets up the visual representation of the piece with sides
	 */
	public void pieceMaker() {
		
		body = new Rectangle(0,0,130,130);
		sides = new PegShape[4];
		
		for(int i = 0; i < 4; i++){
			setSide(i, piece.getSide(i));
			sides[i].setColor(c);
		}
		
	}
	
	/**
	 * Sets the sides of the PieceShape using the PegShape's child classes
	 * @param dir
	 * @param s
	 */
	private void setSide(int dir, Side s){
		int val = Math.abs(s.getValue());
		switch(val){
		case Side.inClub:	sides[dir] = new Club(dir,piece.getOrientation()); break;
		case Side.inDiamond:sides[dir] = new Diamond(dir,piece.getOrientation()); break;
		case Side.inHeart:	sides[dir] = new Heart(dir,piece.getOrientation()); break;
		case Side.inSpade:	sides[dir] = new Spade(dir,piece.getOrientation()); break;
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
		updateLoc();
		return piece.getOrientation();
	}
	
	/**
	 * Paints the Piece on the frame
	 * @param g
	 */
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		updateLoc();
		
		g2.setColor(c);
		g2.fill(body);
		
		for(PegShape s : sides){
			s.paint(g2);
		}
	}
	
	/**
	 * @return The color of the pieceShape
	 */
	public Color getColor(){
		return c;
	}
	
	/**
	 * Sets the color of the PieceShape
	 * @param c
	 */
	public void setColor(Color c){
		this.c = c;
		for(int i = 0; i < 4; i++){
			setColor(i, c);
		}
	}
	
	/**
	 * Helper method to set the color of individual sides
	 * @param side
	 * @param c
	 */
	private void setColor(int side, Color c){
		sides[side].setColor(c);
	}
	
	/**
	 * Helper method to ensure all the parts of the PieceShape are in the right place
	 */
	public void updateLoc(){
		if (piece.getOrientation() == 0) {
			int xTemp = loc.x + 40;
			int yTemp = loc.y + 0;
			sides[0].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 130;
			yTemp = loc.y + 90;
			sides[1].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 40;
			yTemp = loc.y + 130;
			sides[2].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 0;
			yTemp = loc.y + 90;
			sides[3].setLoc(new Point(xTemp, yTemp));
			body.x = loc.x;
			body.y = loc.y + 50;
		}
		else if (piece.getOrientation() == 1){
			int xTemp = loc.x + 40;
			int yTemp = loc.y + 0;
			sides[0].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 130;
			yTemp = loc.y + 40;
			sides[1].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 40;
			yTemp = loc.y + 130;
			sides[2].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 0;
			yTemp = loc.y + 40;
			sides[3].setLoc(new Point(xTemp, yTemp));
			body.x = loc.x;
			body.y = loc.y;
		}
		else if (piece.getOrientation() == 2){
			int xTemp = loc.x + 90;
			int yTemp = loc.y + 0;
			sides[0].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 130;
			yTemp = loc.y + 40;
			sides[1].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 90;
			yTemp = loc.y + 130;
			sides[2].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 0;
			yTemp = loc.y + 40;
			sides[3].setLoc(new Point(xTemp, yTemp));
			body.x = loc.x + 50;
			body.y = loc.y;
		}
		else{
			int xTemp = loc.x + 90;
			int yTemp = loc.y + 0;
			sides[0].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 130;
			yTemp = loc.y + 90;
			sides[1].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 90;
			yTemp = loc.y + 130;
			sides[2].setLoc(new Point(xTemp, yTemp));
			xTemp = loc.x + 0;
			yTemp = loc.y + 90;
			sides[3].setLoc(new Point(xTemp, yTemp));
			body.x = loc.x + 50;
			body.y = loc.y + 50;
		}
	}
	
	/**
	 * Returns the location of the PieceShape
	 * @return
	 */
	public Point getLoc(){
		return loc;
	}
	
	/**
	 * Sets the location of the PieceShape
	 * @param loc
	 */
	public void setLoc(Point loc){
		this.loc = loc;
	}
	
	/**
	 * Returns true if the Piece is currently in the Board
	 * @return
	 */
	public boolean isInBoard(){
		return piece.isIn();
	}
	
	/**
	 * Sets the inBoard variable of the framework piece
	 * @param tf
	 */
	public void setInBoard(boolean tf){
		if (tf) piece.setIn();
		else piece.setOut();
	}
	
	/**
	 * Toggles the inBoard variable of the framework piece
	 * @return
	 */
	public boolean toggleInBoard(){
		if(piece.isIn())
			piece.setOut();
		else
			piece.setIn();
		return piece.isIn();
	}
	
	/**
	 * @return the framework piece of this PieceShape
	 */
	public Piece getPiece(){
		return piece;
	}

	/**
	 * Sets the home location
	 * @param home
	 */
	public void setHome(Point home) {
		this.home = home;
		setLoc(home);
	}
	
	/**
	 * Sets the home location
	 * @param home
	 */
	public void setHome(Point2D home){
		int x = (int) home.getX();
		int y = (int) home.getY();
		setHome(new Point(x,y));
	}
	
	public Point getHome(){
		return home;
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
	
	/**
	 * Checks if the Point is contained in the PieceShape
	 */
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

	/**
	 * Deprecated
	 */
	@Override
	public boolean contains(Rectangle2D r) {return false;}

	/**
	 * Deprecated
	 */
	@Override
	public boolean contains(double x, double y) {
		Point p = new Point((int)x,(int)y);
		return contains(p);
	}

	/**
	 * Deprecated
	 */
	@Override
	public boolean contains(double x, double y, double w, double h) {return false;}

	@Override
	public Rectangle getBounds() {
		//TODO add the bounds of the sides as well
		return body;
	}

	/**
	 * Deprecated
	 */
	@Override
	public Rectangle2D getBounds2D() {
		return getBounds();
	}

	/**
	 * Deprecated
	 */
	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {return null;}

	/**
	 * Deprecated
	 */
	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {return null;}

	/**
	 * Deprecated
	 */
	@Override
	public boolean intersects(Rectangle2D arg0) {return false;}

	/**
	 * Deprecated
	 */
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return intersects(new Rectangle2D.Double(x,y,w,h));
	}
	
	public String toString(){
		return "PieceShape at [" + loc.x + ", " + loc.y + "]\n\t" + piece.toString();
	}

	/**
	 * Returns the side specified by the integer
	 * @param i
	 * @return
	 */
	public PegShape getSide(int i) {
		return sides[i];
	}
	
	/**
	 * Sets the location and board if the piece is putinto the board
	 * @param loc
	 * @param b
	 */
	public void putInBoard(Point loc, Board b){
		board = b;
		boardLoc = loc;
		setInBoard(true);
	}
	
	/**
	 * Reverses the actions of putInBoard()
	 */
	public void removeFromBoard(){
		if(boardLoc != null)
			board.setLocation(boardLoc.x, boardLoc.y, null);
		boardLoc = null;
		setInBoard(false);
	}
	
	/**
	 * Returns the body of the pieceShape
	 * @return
	 */
	public Shape getBody(){
		return body;
	}
	
	/**
	 * Returns the pegs that face inward of the pieceShape in an array
	 * @return
	 */
	public PegShape[] getInPegs(){
		PegShape[] in = new PegShape[2];
		int j = 0;
		for(int i = 0; i < sides.length; i++){
			if(piece.getSide(i).getValue() > 0){
				in[j] = sides[i];
				j++;
			}
		}
		return in;
	}
	
	/**
	 * Returns the pegs that face outward of the pieceShape in an array
	 * @return
	 */
	public PegShape[] getOutPegs(){
		PegShape[] out = new PegShape[2];
		int j = 0;
		for(int i = 0; i < sides.length; i++){
			if(piece.getSide(i).getValue() < 0){
				out[j] = sides[i];
				j++;
			}
		}
		return out;
	}
}
