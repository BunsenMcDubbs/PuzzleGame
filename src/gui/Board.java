package gui;

import java.awt.Point;
import java.awt.datatransfer.*;
import java.awt.dnd.*;

import framework.*;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class Board extends JComponent implements DropTargetListener{
	
	private Puzzle g;
	private PieceComponent [][] p = new PieceComponent[3][3];
	
	private DropTarget target;
	
	public Board(){
		this(new Puzzle());
	}
	
	public Board(Puzzle g){
		this.g = g;
		dnd();
		// TODO paint the pieces and stuff, esp if there is a predefined board
	}
	
	private void dnd(){
		target = new DropTarget(this, this);
		setTransferHandler(new PieceTransferHandler());
	}
	
	private class PieceTransferHandler extends TransferHandler{
		public PieceTransferHandler(){}
		
		public boolean canImport(JComponent c, DataFlavor[] f){
			DataFlavor temp = new DataFlavor(PieceComponent.class, "PieceComponent");
			for(DataFlavor d : f){
				if(d.equals(temp)){
					return true;
				}
			}
			return false;
		}
		
		public boolean importData(JComponent comp, Transferable t, Point p){
			
			framework.Board b = g.getBoard();
			
			if(b.isValidLocation(p.x,p.y) && b.isEmpty(p.x,p.y))
				return false;
			if(b.getLocation(p.x, p.y) != null)
				return false;
			
			PieceComponent temp;
			
			try{
				temp = (PieceComponent)t.getTransferData(new DataFlavor(PieceComponent.class, "PieceComponent"));
			}
			catch(Exception e){
				return false;
			}
			
			return g.insertPieceAtLocation(p.x, p.y, temp.getPiece());
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
	
}
