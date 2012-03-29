package gui;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import javax.swing.JFrame;

public abstract class PieceShape {
	
	private int side;
	
	public PieceShape(int side){
		this.side = side;
	}
	
	public final int getSide(){
		return side;
	}
	
	public abstract void paint(Graphics2D g);
	
//	public static Shape getHeart(){
//		
//		Ellipse2D.Double s = new Ellipse2D.Double(10,0,30,50);
//		
//		return s;
//	}
//	
//	public static Shape getClub(){
//		
//		return new Rectangle(0,0,50,50);
//
//	}
//	
//	public static Shape getDiamond(){
//		
//		int [] x = {25,40,25,10};
//		int [] y = {0,25,50,25};
//		
//		Path2D.Double s = new Path2D.Double(Path2D.WIND_EVEN_ODD);
//		s.moveTo(x[0], y[0]);
//		for (int i = 1; i < x.length && i < y.length; i++){
//			s.lineTo(x[i], y[i]);
//		}
//		s.closePath();
//		
//		return s;
//
//	}
//	
//	public static Shape getSpade(){
//		
//		int [] x = {25,50,0};
//		int [] y = {0,50,50};
//		
//		Path2D.Double s = new Path2D.Double(Path2D.WIND_EVEN_ODD);
//		s.moveTo(x[0], y[0]);
//		for (int i = 1; i < x.length && i < y.length; i++){
//			s.lineTo(x[i], y[i]);
//		}
//		s.closePath();
//		
//		return s;
//
//	}
	
	public static void main(String [] args){
		PuzzleCanvas canvas = new PuzzleCanvas();
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas);
		frame.setVisible(true);
	}
	
}
