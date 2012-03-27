package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PuzzleCanvas extends Canvas {
	
	public PuzzleCanvas(){}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.fill(PieceShape.getClub());
	}
	
}
