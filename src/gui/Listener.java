package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class Listener implements ActionListener{
	private JPopupMenu popup;
	public Listener() {}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == PuzzleGameFrame.getSolveButton()){
			//solve method
		}
		
		else if(event.getSource() == PuzzleGameFrame.getResetButton()){
			PieceComponent[] pieceComponents = PuzzleGameFrame.getP();
			for(int i = 0; i < pieceComponents.length; i ++){
				PieceComponent piece = pieceComponents[i];
				piece.setInBoard(false);
			}
		}		
		
		else if(event.getSource() == PuzzleGameFrame.getHelpButton()){
			popup = new JPopupMenu("HELP");
			popup.setPopupSize(200,75);
			JTextArea text = new JTextArea("adsfasdf");
			popup.add(text);
			popup.setVisible(true);
		}
	}

}
