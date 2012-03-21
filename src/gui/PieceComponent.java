package gui;

import framework.Piece;
import javax.swing.JComponent;

public class PieceComponent extends JComponent {
	
	private Piece piece;
	
	public PieceComponent(Piece p) {
		piece = p;
	}
	
}
