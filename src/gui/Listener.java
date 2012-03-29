package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class Listener implements ActionListener{
	private JFrame message;
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
			message = new JFrame("HELP");
			message.setSize(350,100);
			message.setLocation(75, 50);
			JLabel text1 = new JLabel("Drag and drop pieces onto spots on the board.");
			JLabel text2 = new JLabel("Only sides with pegs and holes of the same shape will fit.");
			JLabel text3 = new JLabel("Place all 9 pieces on the board to win.");
			message.add(text1, BorderLayout.NORTH);
			message.add(text2, BorderLayout.CENTER);
			message.add(text3, BorderLayout.SOUTH);
			message.setVisible(true);
		}
	}
}
