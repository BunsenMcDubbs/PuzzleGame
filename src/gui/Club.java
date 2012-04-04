package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Club extends PegShape{

	public Club(int side) {
		super(side);
	}

	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(getSide() == 1 || getSide() == 3){
			if(getSide() == 1){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(25, 0, 25, 25);
			g2.fillOval(13, 13, 25, 25);
			g2.fillOval(38, 13, 25, 25);
			g2.fillRect(37, 2, 3, 45);
		}
		
		else if(getSide() == 2 || getSide() == 4){
			if(getSide() == 2){
				g2.setColor(Color.RED);
			}
			else{
				g2.setColor(new Color(238,238,238));
			}
			g2.fillOval(25, 25, 25, 25);
			g2.fillOval(12, 13, 25, 25);
			g2.fillOval(12, 38, 25, 25);
			g2.fillRect(2, 37, 40, 3);
		}
		
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("asdf");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		Club club = new Club(2);
		frame.add(club);
	}

}
