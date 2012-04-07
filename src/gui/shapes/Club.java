package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;

public class Club extends PegShape{

	public Club(int side) {
		super(side);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(getSide() == 0 || getSide() == 2){
			if(getSide() == 0){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(12, 0, 25, 25);
			g2.fillOval(0, 13, 25, 25);
			g2.fillOval(25, 13, 25, 25);
			g2.fillRect(24, 2, 3, 50);
		}
		
		else if(getSide() == 1 || getSide() == 3){
			if(getSide() == 1){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(25, 12, 25, 25);
			g2.fillOval(12, 0, 25, 25);
			g2.fillOval(12, 25, 25, 25);
			g2.fillRect(0, 24, 40, 3);
		}
		
	}
	
	public static void main(String[] args){
//		JFrame frame = new JFrame("asdf");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		Club club = new Club(0);
//		frame.add(club);
	}


	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
