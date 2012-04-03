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
import java.io.IOException;

import javax.swing.JComponent;

import framework.Piece;
import framework.Side;

public class Piece implements DropTargetListener{
	
	private Piece piece;
	private Rectangle body;
	private Shape [] sides;
	private boolean inBoard;//Needed?
	
	public PieceComponent(Piece p) {
		piece = p;
		inBoard = false;
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
		repaint();
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
		AffineTransform t = new AffineTransform();
		AffineTransform saveAT = g2.getTransform();
		g2.setTransform(t);
		
		//TODO Draw the piece here
		
		g2.setTransform(saveAT);
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
		;
	}

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
