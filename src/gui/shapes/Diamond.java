package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;

public class Diamond extends PegShape{

	private int[] x;
	private int[] y;
	
	public Diamond(int side) {
		super(side);
		resetPoints();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		updateLoc();
		
		if(getSide() == 0 || getSide() == 1){
			g2.setColor(Color.RED);
		}
		else{
			g2.setColor(gui.PuzzleGameFrame.backColor);
		}
		for( Shape s : shapes ){
			g2.fill(s);
		}
	}
	
	private void updateLoc(){
		resetPoints();
		Point loc = getLoc();
		
		Shape[]	sTemp = super.shapes;
		
		for(int i = 0; i < 4; i++){
			x[i] += loc.x;
			y[i] += loc.y;
		}
		diamondMaker();
	}
	
	public void resetPoints(){
		Shape[] shapes = {null};
		super.shapes = shapes;
		int[] xPoints = {25, 50, 25, 0};
		int[] yPoints = {0, 25, 50, 25};
		this.x = xPoints;
		this.y = yPoints;
		diamondMaker();
	}
	
	public void diamondMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(x[0], y[0]);
		path.lineTo(x[1], y[1]);
		path.lineTo(x[2], y[2]);
		path.lineTo(x[3], y[3]);
		path.closePath();
		shapes[0] = path;
	}
	
//	public void paint(Graphics g) {
//		Graphics2D g2 = (Graphics2D)g;
//		if(getSide() == 3 || getSide() == 2){
//			g2.setColor(gui.PuzzleGameFrame.backColor);
//		}
//		else{
//			g2.setColor(Color.RED);
//		}
//		int[] xPoints = {25, 50, 25, 0};
//		int[] yPoints = {0, 25, 50, 25};
//		g2.fillPolygon(xPoints, yPoints, 4);
//		
//	}
	
	public static void main(String[] args){
		test.Testing.main(null);
//		JFrame frame = new JFrame("asdf");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		Diamond diamond = new Diamond(1);
//		frame.add(diamond);
	}

	@Override
	public boolean contains(Point2D p) {
		if(super.contains(p))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
