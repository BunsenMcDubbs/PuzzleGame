package gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

import framework.Piece;
import gui.*;


public class Spade extends PegShape{
	private int[] xtriangle1;
	private int[] ytriangle1;
	private int[] xtriangle2;
	private int[] ytriangle2;
	private int[] xrectangle;
	private int[] yrectangle;
	
	public Spade(int side) {
		super(side);
//		resetPoints();
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
		for(int i = 0; i < 2; i++){
			Ellipse2D.Double f = (Ellipse2D.Double)shapes[i];
			f.x += loc.x;
			f.y += loc.y;
		}
		
		for(int i = 0; i < 3; i++){
			xtriangle1[i] += loc.x;
			ytriangle1[i] += loc.y;
			xtriangle2[i] += loc.x;
			ytriangle2[i] += loc.y;
		}
		
		for(int i = 0; i < 4; i++){
			xrectangle[i] += loc.x;
			yrectangle[i] += loc.y;
		}
		triangleMaker();
		rectangleMaker();
	}
	
	private void resetPoints(){
		if(getSide() == 0 || getSide() == 2){
			Shape[] shapes = {new Ellipse2D.Double(0, 22, 26, 20),
				new Ellipse2D.Double(25, 22, 25, 20), null,null,null};
			super.shapes = shapes;
			int[] xTriangle1Points = {0,25,50};
			int[] yTriangle1Points = {29,0,29};
			this.xtriangle1 = xTriangle1Points;
			this.ytriangle1 = yTriangle1Points;
			int[] xTriangle2Points = {20,26,31};
			int[] yTriangle2Points = {50,43,50};
			this.xtriangle2 = xTriangle2Points;
			this.ytriangle2 = yTriangle2Points;
			int[] xRectanglePoints = {24,24,28,28};
			int[] yRectanglePoints = {7,50,50,7};
			xrectangle = xRectanglePoints;
			yrectangle = yRectanglePoints;
		}
		else if(getSide() == 1 || getSide() == 3){
			Shape[] shapes = {new Ellipse2D.Double(8, 0, 20, 26),
					new Ellipse2D.Double(8, 25, 20, 25), null,null,null};
			super.shapes = shapes;
			int[] xTriangle1Points = {21,50,21};
			int[] yTriangle1Points = {0,25,50};
			this.xtriangle1 = xTriangle1Points;
			this.ytriangle1 = yTriangle1Points;
			int[] xTriangle2Points = {0,7,0};
			int[] yTriangle2Points = {20,26,31};
			this.xtriangle2 = xTriangle2Points;
			this.ytriangle2 = yTriangle2Points;
			int[] xRectanglePoints = {2,2,44,44};
			int[] yRectanglePoints = {24,28,28,24};
			xrectangle = xRectanglePoints;
			yrectangle = yRectanglePoints;
		}
		triangleMaker();
		rectangleMaker();
	}
	
	private void triangleMaker(){
		Path2D.Double path1 = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path1.moveTo(xtriangle1[0], ytriangle1[0]);
		path1.lineTo(xtriangle1[1], ytriangle1[1]);
		path1.lineTo(xtriangle1[2], ytriangle1[2]);
		path1.closePath();
		shapes[2] = path1;
		
		Path2D.Double path2 = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path2.moveTo(xtriangle2[0], ytriangle2[0]);
		path2.lineTo(xtriangle2[1], ytriangle2[1]);
		path2.lineTo(xtriangle2[2], ytriangle2[2]);
		path2.closePath();
		shapes[3] = path2;
	}
	
	private void rectangleMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(xrectangle[0], yrectangle[0]);
		path.lineTo(xrectangle[1], yrectangle[1]);
		path.lineTo(xrectangle[2], yrectangle[2]);
		path.lineTo(xrectangle[3], yrectangle[3]);
		path.closePath();
		shapes[4] = path;
	}

//	public void paint(Graphics g) {
//		Graphics2D g2 = (Graphics2D) g;
//		if(getSide() == 0 || getSide() == 2){
//			if(getSide() == 0){
//				g2.setColor(Color.RED);
//			}
//			else{
//				g2.setColor(new Color(238,238,238));
//			}
//			g2.fillOval(0, 22, 26, 20);
//			g2.fillOval(25, 22, 25, 20);
//			int[] xPoints = {0,25,50};
//			int[] yPoints = {29,0,29};
//			g2.fillPolygon(xPoints, yPoints, 3);
//			g2.fillRect(24,7,4,43);
//			int[] xPointsBottom = {20,26,31};
//			int[] yPointsBottom = {50,43,50};
//			g2.fillPolygon(xPointsBottom,yPointsBottom,3);
//		}
//		else if(getSide() == 1 || getSide() == 3){
//			if(getSide() == 1){
//				g2.setColor(Color.RED);
//			}
//			else{
//				g2.setColor(new Color(238,238,238));
//			}
//			g2.fillOval(8, 0, 20, 26);
//			g2.fillOval(8, 25, 20, 25);
//			int[] xPoints = {21,50,21};
//			int[] yPoints = {0,25,50};
//			g2.fillPolygon(xPoints, yPoints, 3);
//			g2.fillRect(4,24,40,4);
//			int[] xPointsBottom = {0,7,0};
//			int[] yPointsBottom = {20,26,31};
//			g2.fillPolygon(xPointsBottom,yPointsBottom,3);
//		}
//
//	}
	
	public static void main(String[] args){
		test.Testing.main(null);
//		JFrame frame = new JFrame("asdf");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500,500);
//		frame.setVisible(true);
//		Spade spade = new Spade(1);
//		frame.add(spade);
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

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
