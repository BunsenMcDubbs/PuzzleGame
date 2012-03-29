package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import framework.Piece;
import framework.Side;

import javax.swing.JComponent;

public class PieceComponent extends JComponent implements Placeable{
	
	private Piece piece;
	Rectangle body;
	private Shape [] sides;
	private boolean inBoard;
	
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
			switch(val){
			case Side.inHeart: sides[i] = PieceShape.getHeart(); break;
			case Side.inSpade: sides[i] = PieceShape.getSpade(); break;
			case Side.inClub: sides[i] = PieceShape.getClub(); break;
			case Side.inDiamond: sides[i] = PieceShape.getDiamond(); break;
			case Side.outHeart: sides[i] = PieceShape.getHeart(); break;
			case Side.outSpade: sides[i] = PieceShape.getSpade(); break;
			case Side.outClub: sides[i] = PieceShape.getClub(); break;
			case Side.outDiamond: sides[i] = PieceShape.getDiamond(); break;
			}
		}
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
	
}
