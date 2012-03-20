package framework;


public class Piece {
	
	private Side north;
	private Side east;
	private Side south;
	private Side west; 
	private int orientation;
	private boolean in;
	
	public Piece (Side n, Side e, Side s, Side w){
		north=n;
		east=e;
		south=s;
		west=w;
		orientation= 0;
		in = false;
	}
	
	public void rotateClockwise (){
		orientation++;
		if (orientation==4)
			orientation=0;
	}
	
	public void rotate (){
		rotateClockwise();
		
	}
	
	public void rotateCounterClockwise(){
		orientation --;
		if (orientation==-1)
			orientation=3;
	}
	
	public Side getSideNorth(){
		if (orientation ==0)
			return north;
		if (orientation ==1)
			return west;
		if (orientation==2)
			return south;
		else 
			return east;
	}
	
	public Side getSideEast(){
		if (orientation ==0)
			return east;
		if (orientation ==1)
			return north;
		if (orientation==2)
			return west;
		else 
			return south;
	}
	
	public Side getSideSouth(){
		if (orientation ==0)
			return south;
		if (orientation ==1)
			return east;
		if (orientation==2)
			return north;
		else 
			return west;
	}
	
	public Side getSideWest(){
		if (orientation ==0)
			return west;
		if (orientation ==1)
			return south;
		if (orientation==2)
			return east;
		else 
			return north;
	}
	
	public boolean isIn (){
		if (in==true)
			return true;
		return false;
	}
	
	public void setIn (){
		in=true;
	}
	
	public void setOut (){
		in=false;
	}
}
