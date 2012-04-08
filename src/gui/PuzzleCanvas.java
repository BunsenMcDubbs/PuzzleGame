package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;

public class PuzzleCanvas extends JComponent implements MouseListener, MouseWheelListener, MouseMotionListener{
	
	private PieceShape[] p;
	private Point[] boardLoc;
	private Point[] homeLoc;
	private Board board;
	
	private Point dragOrigin;
	
	public PuzzleCanvas(PieceShape[] pieces, Board board){
		this.p = pieces;
		this.board = board;
		trayMaker();
		boardMaker();
		
		setSize(1200,750);
	}

	private void trayMaker() {
		homeLoc = new Point[9];
		homeLoc[0] = new Point(600, 50);
		homeLoc[1] = new Point(800, 50);
		homeLoc[2] = new Point(1000, 50);
		homeLoc[3] = new Point(600, 250);
		homeLoc[4] = new Point(800, 250);
		homeLoc[5] = new Point(1000, 250);
		homeLoc[6] = new Point(600, 450);
		homeLoc[7] = new Point(800, 450);
		homeLoc[8] = new Point(1000, 450);
		for(int i = 0; i < p.length; i++){
			p[i].setHome(homeLoc[i]);
		}
	}
	
	private void boardMaker(){
		boardLoc = new Point[9];
		boardLoc[0] = new Point(50, 200);
		boardLoc[1] = new Point(200, 200);
		boardLoc[2] = new Point(350, 200);
		boardLoc[3] = new Point(50, 350);
		boardLoc[4] = new Point(200, 350);
		boardLoc[5] = new Point(350, 350);
		boardLoc[6] = new Point(50, 500);
		boardLoc[7] = new Point(200, 500);
		boardLoc[8] = new Point(350, 500);
	}

	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D)g;
		paintBoard(g2);
		test(g2);
		
		for(PieceShape e : p){
			e.paint(g2);
		}
	}
	
	private void test(Graphics2D g2) {
		g2.setColor(Color.red);
		for(Point p : boardLoc){
			g2.drawRect(p.x, p.y, 10, 10);
		}
		g2.setColor(Color.blue);
		for(Point p : homeLoc){
			g2.drawRect(p.x, p.y, 10, 10);
		}
	}

	private void paintBoard(Graphics2D g2){
		g2.drawLine(50, 200, 50, 650);
		g2.drawLine(200, 200, 200, 650);
		g2.drawLine(350, 200, 350, 650);
		g2.drawLine(500, 200, 500, 650);
		
		g2.drawLine(50, 200, 500, 200);
		g2.drawLine(50, 350, 500, 350);
		g2.drawLine(50, 500, 500, 500);
		g2.drawLine(50, 650, 500, 650);
	}
	
	public PieceShape getClickedPiece(Point point){
		for(PieceShape e : p){
			if(e.contains(point)){
				return e;
			}
		}
		return null;
	}
	
	public boolean put(PieceShape p){
		//TODO adsfadsfasdf
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		Point p = m.getPoint();
		PieceShape piece = getClickedPiece(p);
		if(piece == null)
			return;
		//TODO rotate?
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent m) {
		//TODO stufffffff
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent m) {
		Point loc = m.getPoint();
		PieceShape piece = getClickedPiece(loc);
		if(piece == null)
			return;
		int turns = m.getWheelRotation();
		if(turns > 0){
			for(int i = 0; i < turns; i++){
				piece.getPiece().rotateClockwise();
			}
		}
		else{
			for(int i = 0; i < turns; i++){
				piece.getPiece().rotateCounterClockwise();
			}
		}
		repaint();
	}
	
}
