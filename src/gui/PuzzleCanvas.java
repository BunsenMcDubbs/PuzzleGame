package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class PuzzleCanvas extends Canvas {
	
	public PuzzleCanvas(){}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.fill(PieceShape.getClub());
		AffineTransform saveAT = g2.getTransform();
	}
	
}
