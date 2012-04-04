package gui;

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
	private Point[] boardLocs;
	private Point[] homeLoc;
	private Board board;
	
	private Point dragOrigin;
	
	public PuzzleCanvas(PieceShape[] pieces, Point[] boardLocs, Point[] homes, Board board){
		this.p = pieces;
		this.boardLocs = boardLocs;
		this.homeLoc = homes;
		this.board = board;
		trayMaker();
	}
	
	private void trayMaker() {
		for(int i = 0; i < p.length; i++){
			p[i].setHome(homeLoc[i]);
		}
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		
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
