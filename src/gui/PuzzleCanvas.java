package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;

import framework.Board;
import framework.Puzzle;

public class PuzzleCanvas extends JComponent implements MouseListener, MouseWheelListener, MouseMotionListener{

	private PieceShape[] p;
	private Point[] boardPoints;
	private Point[] homeLoc;
	private Rectangle[] boardLocs;
	private Puzzle puzzle;

	private Point dragOrigin;

	public PuzzleCanvas(PieceShape[] pieces, Puzzle puzzle){
		this.p = pieces;
		this.puzzle = puzzle;
		trayMaker();
		boardMaker();

		addMouseListener(this);

		setSize(1200,750);
	}

	private void trayMaker() {
		// TODO Max size
		/*homeLoc = new Point[9];
		homeLoc[0] = new Point(500, 50);
		homeLoc[1] = new Point(700, 50);
		homeLoc[2] = new Point(900, 50);
		homeLoc[3] = new Point(500, 250);
		homeLoc[4] = new Point(700, 250);
		homeLoc[5] = new Point(900, 250);
		homeLoc[6] = new Point(500, 450);
		homeLoc[7] = new Point(700, 450);
		homeLoc[8] = new Point(900, 450);
		for(int i = 0; i < p.length; i++){
			p[i].setHome(homeLoc[i]);
		}*/
		
		
	}

	private void boardMaker(){
		// TODO Max size
		/*boardPoints = new Point[9];
		boardPoints[0] = new Point(50, 100);
		boardPoints[1] = new Point(200, 100);
		boardPoints[2] = new Point(350, 100);
		boardPoints[3] = new Point(50, 250);
		boardPoints[4] = new Point(200, 250);
		boardPoints[5] = new Point(350, 250);
		boardPoints[6] = new Point(50, 400);
		boardPoints[7] = new Point(200, 400);
		boardPoints[8] = new Point(350, 400);*/
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
		for(Point p : boardPoints){
			g2.drawRect(p.x, p.y, 10, 10);
		}
		g2.setColor(Color.blue);
		for(Point p : homeLoc){
			g2.drawRect(p.x, p.y, 10, 10);
		}
	}

	private void paintBoard(Graphics2D g2){
		boardLocs = new Rectangle[9];

		for(int i = 0; i < boardPoints.length; i++){
			boardLocs[i] = new Rectangle(boardPoints[i].x,boardPoints[i].y, 150, 150);
			g2.draw(boardLocs[i]);
		}
	}

	public PieceShape getClickedPiece(Point point){
		for(PieceShape e : p){
			if(e.contains(point)){
				System.out.println(point);
				System.out.println(e);
				return e;
			}
		}
		return null;
	}

	private PieceShape selected;
	@Override
	public void mouseClicked(MouseEvent m) {
		if(selected == null){
			Point p = m.getPoint();
			PieceShape piece = getClickedPiece(p);
			if(piece == null)
				return;
			selected = piece;
		}
		else{
			Point p = m.getPoint();
			int spot = getClickedSpot(p);
			if(spot == -1)
				return;
			put(spot);
			selected = null;
		}
	}

	private boolean put(int place){
		
		int y = place/3;
		int x = place%3;
		
//		System.out.println(place);
//		System.out.println("" + x + " , " + y);
		if(puzzle.canFit(x, y, selected.getPiece())){// TODO check with board
			selected.setLoc(new Point(boardLocs[place].x, boardLocs[place].y - 50));
		}
		repaint();
		return true;
	}

	private int getClickedSpot(Point p) {
		for(int i = 0; i < boardLocs.length; i++){
			Rectangle r = boardLocs[i];
			if (r.contains(p))
				return i;
		}
		return -1;
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
