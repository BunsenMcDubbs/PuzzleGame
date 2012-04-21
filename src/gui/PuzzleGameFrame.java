package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import solver.RecursiveSolve;

import framework.*;

public class PuzzleGameFrame extends JFrame implements ActionListener{
	
	private Puzzle puzzle;
	
	private JMenuBar mBar;
	
	private JPanel controlPanel;
	private JButton solve, reset, help;
	
	private PieceShape[] p;
	private PuzzleCanvas pC;
	
	public static final Color backColor = new Color(238, 238, 238);
	
	public PuzzleGameFrame(){
		super("Puzzle Game");
		setTitle("Puzzle Game");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		frameworks();
		pieceMaker();
		menuMaker();
		buttonMaker();
		controlMaker();
		
		pC = new PuzzleCanvas(p, puzzle);
		add(pC, BorderLayout.CENTER);
		
		setSize();
		setVisible(true);
	}
	
	private void setSize(){
		Dimension max = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(max);
		setMinimumSize(new Dimension(1160, 750));
		setSize(getMinimumSize());
	}
	
	public PieceShape[] getP(){
		return p;
	}
	
	private void frameworks() {
		puzzle = new Puzzle();
	}
	
	private void buttonMaker(){
		solve = new JButton("Solve");
		reset = new JButton("Reset");
		help = new JButton("Help");
		
		solve.setActionCommand("solve");
		reset.setActionCommand("reset");
		help.setActionCommand("help");
		
		solve.addActionListener(this);
		reset.addActionListener(this);
		help.addActionListener(this);
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
		Piece[] p2 = puzzle.getPieces();
		for(int i = 0; i < p2.length; i++){
			p[i] = new PieceShape(p2[i]);
			Color c = Color.RED;
//			{
//				double seed = Math.random();
//				for(int j = 0; j < (int)(seed*3); j++){
//					c = c.darker();
//				}
//				for(int j = 0; j < (int)(seed*i*3); j++){
//					c = c.brighter();
//				}
//			}
			for( int j = 0; j < i; j++){
				c = c.darker();
			}
			p[i].setColor(c);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("solve")){
			Puzzle temp = new Puzzle();
			RecursiveSolve r = new RecursiveSolve(temp);
			r.solve();
			
			pieceMaker();
			
			pC.solve(temp);
			System.out.println("Solve");
		}
		
		else if(event.getActionCommand().equals("reset")){
			pC.reset();
			repaint();
			System.out.println("Reset");
		}		
		
		else if(event.getActionCommand().equals("help")){
			String message = "Click a piece to select it and click a spot on the board to place the piece. " 
				+ "Rotate pieces by right clicking them." + "\n"
				+ "Only sides with pegs and holes of the same shape will fit. "
				+ "Place all 9 pieces on the board to win.";
			JOptionPane.showMessageDialog(null,message,"Help", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] a){
		test.Testing.test2();
	}

}
