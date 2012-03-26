package gui;

import java.awt.geom.Path2D;

import javax.swing.JFrame;

public class PieceShape {
	
	public static Path2D.Double getHeart(){
		
		Path2D.Double s = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		
		return null;
	}
	
	public static Path2D.Double getClub(){
		return null;

	}
	
	public static Path2D.Double getDiamond(){
		
		int [] x = {50,100,50,0};
		int [] y = {0,50,100,50};
		
		Path2D.Double s = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		s.moveTo(x[0], y[0]);
		for (int i = 1; i < x.length && i < y.length; i++){
			s.lineTo(x[i], y[i]);
		}
		s.closePath();
		
		return s;

	}
	
	public static Path2D.Double getSpade(){
		return null;

	}
	
	public static void main(String [] args){
		PuzzleCanvas canvas = new PuzzleCanvas();
		JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
	}
	
}
