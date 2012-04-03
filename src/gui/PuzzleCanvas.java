package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

public class PuzzleCanvas extends JComponent implements DragSourceListener, DropTargetListener {
	
	private PieceComponent[] p;
	private Point[] board;
	private Point[] homeLoc;
	
	private Point dragOrigin;
	
	public PuzzleCanvas(PieceComponent[] p, Point[] b, Point[] h){
		this.p = p;
		board = b;
		homeLoc = h;
		trayMaker();
	}
	
	private void trayMaker() {
		for(int i = 0; i < p.length; i++){
			p[i].setHome(homeLoc[i]);
		}
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform saveAT = g2.getTransform();
	}
//DropTargetListener
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

//DragGestureListener
	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {
		// TODO Auto-generated method stub
		
	}
//DragSourceListener
	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}
	
}
