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

/**
 * Sets up the window for the game to be displayed and holds all the parts of
 * the GUI representation of the game including the <code>PuzzleCanvas</code>
 * and the buttons.
 * @author bunsen
 *
 */
public class PuzzleGameFrame extends JFrame implements ActionListener{
	
	private Puzzle puzzle;
	
	private JMenuBar mBar;
	
	private JPanel controlPanel;
	private JButton solve, reset, help;
	
	private PieceShape[] p;
	private PuzzleCanvas pC;
	
	public static final Color backColor = Color.LIGHT_GRAY;
	
	/**
	 * Default constructor that sets up the frame, including buttons and
	 * PieceShapes and adds a PuzzleCanvas to the frame
	 */
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
	
	/**
	 * Helper method that sets the size of the frame
	 */
	private void setSize(){
		Dimension max = Toolkit.getDefaultToolkit().getScreenSize();
		setMinimumSize(new Dimension(960, 750));
		setSize(getMinimumSize());
	}

	/**
	 * Helper method initializes the framework puzzle
	 */
	private void frameworks() {
		puzzle = new Puzzle();
	}
	
	/**
	 * Helper method that sets up the buttons and the action listeners
	 */
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

	/**
	 * Helper method that adds the buttons to a panel and adds that to the frame
	 */
	private void controlMaker() {
		controlPanel = new JPanel();
		controlPanel.add(solve, BorderLayout.EAST);
		controlPanel.add(reset, BorderLayout.CENTER);
		controlPanel.add(help, BorderLayout.WEST);
		add(controlPanel, BorderLayout.SOUTH);
	}

	/**
	 * Helper method sets up the menu bar for the frame
	 */
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
			int seed1 = (int)(Math.random()*255);
			int seed2 = (int)(Math.random()*255);
			int seed3 = (int)(Math.random()*255);
			Color c = new Color(seed1,seed2,seed3).brighter().darker();
			p[i].setColor(c);
		}
	}
	
	/**
	 * The action listener for the buttons
	 */
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("solve")){
			Puzzle temp = new Puzzle();
			RecursiveSolve r = new RecursiveSolve(temp);
			r.solve();
			
			pieceMaker();
			
			pC.solve(temp);
//			System.out.println("Solve");
		}
		
		else if(event.getActionCommand().equals("reset")){
			pC.reset();
			repaint();
//			System.out.println("Reset");
		}		
		
		else if(event.getActionCommand().equals("help")){
			String message = "Click a piece to select it and click a spot on the board to place the piece. " 
				+ "Rotate pieces by right clicking them." + "\n"
				+ "Only sides with pegs and holes of the same shape will fit. "
				+ "Place all 9 pieces on the board to win.";
			JOptionPane.showMessageDialog(null,message,"Help", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * main method that starts the game by initializing the frame
	 * @param a
	 */
	public static void main(String[] a){
		PuzzleGameFrame f = new PuzzleGameFrame();
	}

}
