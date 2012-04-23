package gui.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Graphical representation of a spade that extends the PegShape class. It
 * can draw and keep track of its location
 */
public class Spade extends PegShape{
	private int[] xtriangle1;
	private int[] ytriangle1;
	private int[] xtriangle2;
	private int[] ytriangle2;
	private int[] xrectangle;
	private int[] yrectangle;
	
	/**
	 * Constructor that receives what side this shape is and what the Piece's
	 * current orientation is
	 * @param side
	 * @param orientation
	 */
	public Spade(int side, int orientation) {
		super(side, orientation);
		resetPoints();
	}
	
	/**
	 * Paints this shape
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		updateLoc();
		if(getOrientation() == 0){
			if(getSide() == 0 || getSide() == 1){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 1){
			if(getSide() == 1 || getSide() == 2){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 2){
			if(getSide() == 2 || getSide() == 3){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}
		if(getOrientation() == 3){
			if(getSide() == 0 || getSide() == 3){
				g2.setColor(super.c);
			}
			else{
				g2.setColor(gui.PuzzleGameFrame.backColor);
			}
		}

		for( Shape s : shapes ){
			g2.fill(s);
		}
	}
	
	/**
	 * Helper method to update the points according to the current location
	 * of the shape
	 */
	private void updateLoc(){
		resetPoints();
		Point loc = getLoc();
		
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
	/**
	 * Resets the points back to the default location (top left 0,0)
	 */
	private void resetPoints(){
		if(getOrientation() == 0){
			//top facing up
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
			//top facing right
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
		}
		else if(getOrientation() == 1){
			//top facing down
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes = {new Ellipse2D.Double(0, 8, 26, 20),
					new Ellipse2D.Double(25, 8, 25, 20), null,null,null};
				super.shapes = shapes;
				int[] xTriangle1Points = {0,25,50};
				int[] yTriangle1Points = {21,50,21};
				this.xtriangle1 = xTriangle1Points;
				this.ytriangle1 = yTriangle1Points;
				int[] xTriangle2Points = {20,26,31};
				int[] yTriangle2Points = {0,7,0};
				this.xtriangle2 = xTriangle2Points;
				this.ytriangle2 = yTriangle2Points;
				int[] xRectanglePoints = {24,24,28,28};
				int[] yRectanglePoints = {43,0,0,43};
				xrectangle = xRectanglePoints;
				yrectangle = yRectanglePoints;
			}
			//top facing right
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
		}
		else if(getOrientation() == 2){
			//top facing down
			if(getSide() == 0 || getSide() == 2){
				Shape[] shapes = {new Ellipse2D.Double(0, 8, 26, 20),
					new Ellipse2D.Double(25, 8, 25, 20), null,null,null};
				super.shapes = shapes;
				int[] xTriangle1Points = {0,25,50};
				int[] yTriangle1Points = {21,50,21};
				this.xtriangle1 = xTriangle1Points;
				this.ytriangle1 = yTriangle1Points;
				int[] xTriangle2Points = {20,26,31};
				int[] yTriangle2Points = {0,7,0};
				this.xtriangle2 = xTriangle2Points;
				this.ytriangle2 = yTriangle2Points;
				int[] xRectanglePoints = {24,24,28,28};
				int[] yRectanglePoints = {43,0,0,43};
				xrectangle = xRectanglePoints;
				yrectangle = yRectanglePoints;
			}
			//top facing left
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes = {new Ellipse2D.Double(22, 0, 20, 26),
						new Ellipse2D.Double(22, 25, 20, 25), null,null,null};
				super.shapes = shapes;
				int[] xTriangle1Points = {29,0,29};
				int[] yTriangle1Points = {0,25,50};
				this.xtriangle1 = xTriangle1Points;
				this.ytriangle1 = yTriangle1Points;
				int[] xTriangle2Points = {50,43,50};
				int[] yTriangle2Points = {20,26,31};
				this.xtriangle2 = xTriangle2Points;
				this.ytriangle2 = yTriangle2Points;
				int[] xRectanglePoints = {48,48,6,6};
				int[] yRectanglePoints = {24,28,28,24};
				xrectangle = xRectanglePoints;
				yrectangle = yRectanglePoints;
			}
		}
		else if(getOrientation() == 3){
			//top facing up
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
			//top facing left
			else if(getSide() == 1 || getSide() == 3){
				Shape[] shapes = {new Ellipse2D.Double(22, 0, 20, 26),
						new Ellipse2D.Double(22, 25, 20, 25), null,null,null};
				super.shapes = shapes;
				int[] xTriangle1Points = {29,0,29};
				int[] yTriangle1Points = {0,25,50};
				this.xtriangle1 = xTriangle1Points;
				this.ytriangle1 = yTriangle1Points;
				int[] xTriangle2Points = {50,43,50};
				int[] yTriangle2Points = {20,26,31};
				this.xtriangle2 = xTriangle2Points;
				this.ytriangle2 = yTriangle2Points;
				int[] xRectanglePoints = {48,48,6,6};
				int[] yRectanglePoints = {24,28,28,24};
				xrectangle = xRectanglePoints;
				yrectangle = yRectanglePoints;
			}
		}

		triangleMaker();
		rectangleMaker();
	}
	/**
	 * Helper
	 */
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
	/**
	 * Helper
	 */
	private void rectangleMaker(){
		Path2D.Double path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		path.moveTo(xrectangle[0], yrectangle[0]);
		path.lineTo(xrectangle[1], yrectangle[1]);
		path.lineTo(xrectangle[2], yrectangle[2]);
		path.lineTo(xrectangle[3], yrectangle[3]);
		path.closePath();
		shapes[4] = path;
	}

	@Override
	public boolean contains(Point2D p) {
		return super.contains(p);
	}
	/**
	 * Deprecated
	 */
	@Override
	public Rectangle getBounds() {return null;}
}
