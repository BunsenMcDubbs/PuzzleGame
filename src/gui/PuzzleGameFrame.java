package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
	private JButton solve, reset, help;
	
	private PieceComponent[] p;
	
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
	
	private void gameMaker() {
		game = new Puzzle();
	}
	
	private void buttonMaker(){
		solve = new JButton("Solve");
		reset = new JButton("reset");
		help = new JButton("help");
		//solve.addActionListner();
	}

	private void controlMaker() {
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		controlPanel.add(solve);
		controlPanel.add(reset);
		controlPanel.add(help);
		solve.setBounds(0,0,controlPanel.getWidth()/3,controlPanel.getHeight());
		reset.setBounds(controlPanel.getWidth()/3,0,controlPanel.getWidth()/3*2,controlPanel.getHeight());
		help.setBounds(controlPanel.getWidth()/3*2,0,controlPanel.getWidth(),controlPanel.getHeight());
		
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
		p = new PieceComponent[9];
		Piece[] p2 = game.getPieces();
		for(int i = 0; i < p2.length; i++){
			p[i] = new PieceComponent(p2[0]);
		}
	}

}
