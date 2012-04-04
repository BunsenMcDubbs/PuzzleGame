package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import framework.*;

public class PuzzleGameFrame extends JFrame {
	
	private Puzzle game;
	
	private JMenuBar mBar;
	
	private JPanel controlPanel;
	private static JButton solve, reset, help;
	
	private static PieceShape[] p;
	
	public PuzzleGameFrame(){
		super("Puzzle Game");
		setTitle("Puzzle Game");
		setMinimumSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		gameMaker();
		pieceMaker();
		menuMaker();
		buttonMaker();
		controlMaker();
		setSize(getMinimumSize());
		setVisible(true);
	}
	
	public static JButton getSolveButton(){
		return solve;
	}
	
	public static JButton getResetButton(){
		return reset;
	}
	
	public static JButton getHelpButton(){
		return help;
	}
	
	public static PieceShape[] getP(){
		return p;
	}
	
	private void gameMaker() {
		game = new Puzzle();
	}
	
	private void buttonMaker(){
		ActionListener listener = new Listener();
		solve = new JButton("solve");
		reset = new JButton("reset");
		help = new JButton("help");
		solve.addActionListener(listener);
		reset.addActionListener(listener);
		help.addActionListener(listener);
	}

	private void controlMaker() {
		controlPanel = new JPanel();
		controlPanel.add(solve, BorderLayout.EAST);
		controlPanel.add(reset, BorderLayout.CENTER);
		controlPanel.add(help, BorderLayout.WEST);
		add(controlPanel, BorderLayout.SOUTH);
	}

	private void menuMaker() {
		mBar = new JMenuBar();
		setJMenuBar(mBar);
	}

	/**
	 * Uses the Puzzle pieces to make a PieceComponent array as
	 * private data
	 */
	private void pieceMaker() {
		p = new PieceShape[9];
		Piece[] p2 = game.getPieces();
		for(int i = 0; i < p2.length; i++){
			p[i] = new PieceShape(p2[0], null);//TODO FAILLLLLLLLL
		}
	}

}
