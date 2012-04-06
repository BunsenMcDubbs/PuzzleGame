package test;

import framework.Piece;
import gui.PieceShape;
import gui.shapes.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Testing extends JFrame implements ActionListener{

	private Rectangle r;
	private int x = 0, y = 0;
	
	public Testing() {
		super("Puzzle Game");
		setTitle("Puzzle Game");
		setMinimumSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Timer t = new Timer(10, this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x++;
		y++;
		r.setBounds(x,y,50,50);
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		Heart c = new Heart(0, new PieceShape(new Piece(1,2,-1,-2), new Point(0,0)));
		g2.getTransform().translate(100, 100);
		c.paint(g2);
	}
	
	public static void main(String[]a){
		Testing t = new Testing();
	}

}
