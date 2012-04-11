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
	private Point[][] boardLocs;
	private Point[] homeLoc;
	private Puzzle puzzle;

	private Point dragOrigin;

	public PuzzleCanvas(PieceShape[] pieces, Puzzle puzzle){
		this.p = pieces;
		this.puzzle = puzzle;
		trayMaker();
		boardMaker();

		addMouseListener(this);
		p[0].rotate(true);
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
		setHome();
	}
	
	private void setHome(){
		for(int i = 0; i < p.length; i++){
			p[i].setHome(homeLoc[i]);
		}
	}

	private void boardMaker(){
		Point[][] p = new Point[3][3];
		p[0][0] = new Point(50, 200);
		p[1][0] = new Point(200, 200);
		p[2][0] = new Point(350, 200);
		p[0][1] = new Point(50, 350);
		p[1][1] = new Point(200, 350);
		p[2][1] = new Point(350, 350);
		p[0][2] = new Point(50, 500);
		p[1][2] = new Point(200, 500);
		p[2][2] = new Point(350, 500);
		
		boardLocs = p;
	}

	public void paint(Graphics g){

		Graphics2D g2 = (Graphics2D)g;
		paintBoard(g2);
		test(g2);

		for(PieceShape e : p){
			e.paint(g2);
		}
	}

	private void paintBoard(Graphics2D g2) {
		for(int i = 0; i < boardLocs.length; i++){
			for(int j = 0; j < boardLocs[0].length; j++){
				g2.drawRect(boardLocs[i][j].x, boardLocs[i][j].y, 150, 150);
			}
		}
	}

	private void test(Graphics2D g2) {
		g2.setColor(Color.red);
		for(int i = 0; i < boardLocs.length; i++){
			for(int j = 0; j < boardLocs[0].length; j++){
				g2.drawRect(boardLocs[i][j].x, boardLocs[i][j].y, 10, 10);
			}
		}
		g2.setColor(Color.blue);
		for(Point p : homeLoc){
			g2.drawRect(p.x, p.y, 10, 10);
		}
	}

	public PieceShape getClickedPiece(Point point){
		System.out.println("getClickedPiece at " + point);
		for(PieceShape e : p){
			if(e.contains(point)){
				System.out.println("The Piece is " + e);
				return e;
			}
		}
		System.out.println("No piece here");
		return null;
	}

	private PieceShape selected;
	@Override
	public void mouseClicked(MouseEvent m) {
		System.out.println("mouseClicked at " + m.getPoint());
		
		Point p = m.getPoint();
		
		if (m.getButton() == MouseEvent.BUTTON1) {
			if (selected == null) {
				PieceShape piece = getClickedPiece(p);
				if (piece == null)
					return;
				selected = piece;
			}
			else {
				Point bSpot = getClickedBoardSpot(p);
				int tSpot = getClickedTraySpot(p);
				if (bSpot != null) {
					putInBoard(bSpot);
				} else if (tSpot != -1) {
					putInTray(tSpot);
				}
				selected = null;
			}
		}
		else{
			PieceShape piece = getClickedPiece(p);
			if (piece == null)
				return;
			piece.rotate(true);
		}
		repaint();
	}
	
	private int getClickedTraySpot(Point p) {
		for(int i = 0; i < homeLoc.length; i++){
			Rectangle r = new Rectangle(homeLoc[i].x, homeLoc[i].y, 200, 200);
			if (r.contains(p))
				return i;
		}
		return -1;
	}

	private void putInTray(int tSpot) {
		System.out.println("putInTray");
		
		Point h = homeLoc[tSpot];
		Point test = new Point(h.x + 100, h.y + 100);
		
		if (getClickedPiece(test) == null) {
			if(selected.isInBoard()){
				selected.setInBoard(false);
				for (int x = 0; x < boardLocs.length; x++) {
					for (int y = 0; y < boardLocs.length; y++) {
						puzzle.remove(x, y);
					}
				}
			}
			
			{
				selected.setLoc(h);
				repaint();
			}
			return;
		}
		
		System.out.println("not a valid place on the tray");
	}

	/**
	 * Puts the selected Piece into the board
	 * @param p is the point on the board (x,y)
	 * @return true if successful, false if failed
	 */
	private boolean putInBoard(Point p){
		
		System.out.println("putInBoard");
		
		int x = p.x;
		int y = p.y;
		
		Point loc = boardLocs[x][y];
		
		System.out.println(selected);
		System.out.println("" + x + ", " + y);
		System.out.println(puzzle.canFit(x, y, selected.getPiece()));
		System.out.println(puzzle.getBoard().getLocation(x, y));
		if(puzzle.canFit(x, y, selected.getPiece())){// TODO check with board
			if (selected.getPiece().getOrientation() == 0) {
				selected.setLoc(new Point(loc.x, loc.y - 50));
			}
			else if (selected.getPiece().getOrientation() == 1){
				selected.setLoc(new Point(loc.x, loc.y));
			}
			else if (selected.getPiece().getOrientation() == 2){
				selected.setLoc(new Point(loc.x - 50, loc.y));
			}
			else{
				selected.setLoc(new Point(loc.x - 50, loc.y - 50));
			}
			puzzle.insertPieceAtLocation(x, y, selected.getPiece());
		}
		repaint();
		return true;
	}
	
	/**
	 * Checks if the clicked point on the board is a spot on the board
	 * @param p
	 * @return
	 */
	private Point getClickedBoardSpot(Point p) {
		for(int i = 0; i < boardLocs.length; i++){
			for(int j = 0; j < boardLocs[0].length; j++){
				Rectangle r = new Rectangle(boardLocs[i][j].x, boardLocs[i][j].y, 150, 150);
				if (r.contains(p))
					return new Point(i,j);
			}
		}
		return null;
	}
	

	public void reset() {
		for(PieceShape e : p){
			e.goHome();
			e.setInBoard(false);
		}
		puzzle.empty();
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
