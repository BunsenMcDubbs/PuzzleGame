package gui;

import framework.Piece;
import framework.Puzzle;

import java.awt.Point;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;

import javax.swing.JComponent;

public class Tray extends AbstractPieceGrid{
	private PieceComponent [] tray;
	
	public Tray(){
		this(9);
	}
	
	public Tray(int n){
		tray = new PieceComponent[n];
		setEnabled(true);
	}
	
	public void fill(Puzzle puzzle){
		Piece[] pieces = puzzle.getPieces();
		for(int i = 0; i < pieces.length; i++){
			tray[i] = new PieceComponent(pieces[i]);
		}
	}

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

	@Override
	public Point cellAtPoint(Point p) {
		// TODO Auto-generated method stub
		return null;
	}
}
