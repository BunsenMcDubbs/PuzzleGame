package gui;

import framework.Piece;
import javax.swing.JComponent;

public class PieceComponent extends JComponent implements Placeable{
	
	private Piece piece;
	private boolean inBoard;
	
	public PieceComponent(Piece p) {
		piece = p;
		inBoard = false;
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
