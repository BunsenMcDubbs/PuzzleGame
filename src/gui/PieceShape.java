package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import framework.*;

public class PieceShape implements Shape{
	
	private Piece piece;
	private Rectangle body;
	private Shape [] sides;
	private boolean inBoard;//Needed?
	private Point2D home;
	
	public PieceShape(Piece p, Point2D home) {
		piece = p;
		inBoard = false;
		setHome(home);
		pieceMaker();
	}
	
	private void pieceMaker() {
		
		body = new Rectangle(50,50,100,100);
		sides = new Shape[4];
		for (int i = 0; i < sides.length; i++){
			int val = piece.getSide(i).getValue();
			val = Math.abs(val);
//			switch(val){
//			case Side.inHeart: sides[i] = PieceShape.getHeart(); break;
//			case Side.inSpade: sides[i] = PieceShape.getSpade(); break;
//			case Side.inClub: sides[i] = PieceShape.getClub(); break;
//			case Side.inDiamond: sides[i] = PieceShape.getDiamond(); break;
//			}
		}
	}
	
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
		
		//TODO Draw the piece here
		
		
	}

	public boolean isInBoard(){
		return inBoard;
	}
	
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
