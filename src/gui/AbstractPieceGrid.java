package gui;

import java.awt.Point;
import java.awt.dnd.DropTargetListener;

import javax.swing.JComponent;

public abstract class AbstractPieceGrid extends JComponent implements DropTargetListener{
	
	public abstract Point cellAtPoint(Point p);
	
}
