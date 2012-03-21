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
	private JButton startStop, reset, clear;

	
	public PuzzleGameFrame(){
		super("Puzzle Game");
		setTitle("Puzzle Game");
		setMinimumSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
