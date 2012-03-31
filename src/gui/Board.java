package gui;

import java.awt.Point;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.IOException;

import framework.*;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class Board extends JComponent implements DropTargetListener{
	
	private Puzzle g;
	private PieceComponent [][] board;
	private PieceComponent [][] tray;
	
	private DropTarget target;
	
	public Board(){
		g = new Puzzle();
		board = new PieceComponent[3][3];
		tray = new PieceComponent[3][3];
		dnd();
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
		
		public boolean importData(JComponent comp, Transferable t, Point mouse){
			
			framework.Board b = g.getBoard();
			
			Point p = cellAtPoint(mouse);
			
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
	

	private Point cellAtPoint(Point p){
		// TODO find the closest "home location" and corresponding cell
		return null;
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Highlighting system of cells and sides available etc
		
	}

	@Override
	public void dragExit(DropTargetEvent dtde) {
		// TODO Highlighting system of cells and sides available etc
		
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Highlighting system of cells and sides available etc
		
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		try{
			Point loc = dtde.getLocation();
			Transferable t = dtde.getTransferable();
			DataFlavor[] d = t.getTransferDataFlavors();
			
			if(getTransferHandler().canImport(this, d)){
				((PieceTransferHandler)getTransferHandler()).importData(this, (PieceComponent)t.getTransferData(d[0]), loc);
				repaint();
			}
			else
				return;
		}
		catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			dtde.dropComplete(true);
		}
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {}
	
}
