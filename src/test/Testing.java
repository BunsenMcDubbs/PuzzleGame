package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		
		Timer t = new Timer(10, this);
		
		r = new Rectangle(0,0,50,50);
		
		setVisible(true);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x++;
		y++;
		r.setBounds(x,y,50,50);
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(r);
	}
	
	public static void main(String[]a){
		Testing t = new Testing();
	}

}
