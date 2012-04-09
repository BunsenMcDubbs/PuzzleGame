package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import framework.*;

public class PuzzleGameFrame extends JFrame implements ActionListener, ComponentListener{
	
	private Puzzle game;
	
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
		
		pC = new PuzzleCanvas(p, game);
		add(pC, BorderLayout.CENTER);
		
		
		
		setSize();
		setVisible(true);
	}
	
	private void setSize() {
		
		Dimension prefer = new Dimension(1200, 800);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double ratio = prefer.width/prefer.height;
		int height, width;
		if (prefer.height > screen.height && prefer.width > screen.width){
			//Width is limiting
			if (!getLimitingSide(ratio, screen)){
				width = screen.width;
				height = (int) (screen.width/ratio);
			}
			//Height is limiting
			else{
				height = screen.height;
				width = (int) (screen.height*ratio);
			}
			super.setSize(width, height);
			return;
		}
		super.setSize(prefer);
		
	}
	
	/**
	 * @return true if the limiting side is the width
	 */
	public static boolean getLimitingSide(double ratio, Dimension d){
		return !(d.height*1.5 > d.width);
	}

	public PieceShape[] getP(){
		return p;
	}
	
	private void frameworks() {
		game = new Puzzle();
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
		
		int pieceSize = (int) (getSize().width / 8);
		
		p = new PieceShape[9];
		Piece[] p2 = game.getPieces();
		for(int i = 0; i < p2.length; i++){
			p[i] = new PieceShape(new Piece(-1,-1,1,1), pieceSize);//TODO Defaulting to all hearts
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("solve")){
			//solve method
			System.out.println("Solve");
		}
		
		else if(event.getActionCommand().equals("reset")){
			for( PieceShape e : p){
				e.goHome();
			}
			repaint();
			System.out.println("Reset");
		}		
		
		else if(event.getActionCommand().equals("help")){
			JFrame message;
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
	
	public static void main(String[] a){
		test.Testing.test2();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		setSize();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
