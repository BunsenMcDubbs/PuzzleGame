package gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import framework.Piece;
import framework.Side;

public class PieceComponent extends JComponent implements Transferable, DragSourceListener, DragGestureListener{
	
	private Piece piece;
	Rectangle body;
	private Shape [] sides;
	private boolean inBoard;
	
	public PieceComponent(Piece p) {
		piece = p;
		inBoard = false;
		pieceMaker();
		
		dnd();
	}
	
	private void dnd() {
		TransferHandler transfer = new TransferHandler("getPiece");
		setTransferHandler(transfer);
	}

	private void pieceMaker() {
		
		body = new Rectangle(50,50,100,100);
		sides = new Shape[4];
		for (int i = 0; i < sides.length; i++){
			int val = piece.getSide(i).getValue();
			val = Math.abs(val);
//			switch(val){
//			case Side.inHeart: sides[i] = PieceShape.getHeart(); break;
//			case Side.inSpade: sides[i] = PieceShape.getSpade(); break;
//			case Side.inClub: sides[i] = PieceShape.getClub(); break;
//			case Side.inDiamond: sides[i] = PieceShape.getDiamond(); break;
//			}
		}
		repaint();
	}
	
	public int rotate(boolean clockwise){
		if (clockwise){
			piece.rotateClockwise();
		}
		else{
			piece.rotateCounterClockwise();
		}
		pieceMaker();
		return piece.getOrientation();
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform t = new AffineTransform();
		AffineTransform saveAT = g2.getTransform();
		g2.setTransform(t);
		
		//TODO Draw the piece here
		
		g2.setTransform(saveAT);
	}

	public boolean isInBoard(){
		return inBoard;
	}
	
	public void setInBoard(boolean tf){
		inBoard = tf;
	}
	
	public boolean toggleInBoard(){
		inBoard = !inBoard;
		return inBoard;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	private class MouseAdapter{
        public void mousePressed(MouseEvent e){
        	PieceComponent p = (PieceComponent)e.getSource();
            TransferHandler handle = p.getTransferHandler();
            handle.exportAsDrag(p, e, TransferHandler.COPY);
        }
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragEnter(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return false;
	}
}
