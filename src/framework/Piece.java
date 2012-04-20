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
	
	public Piece (int n, int e, int s, int w){
		this(new Side(n), new Side(e), new Side(s), new Side(w));
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
	
	public int getOrientation(){
		return orientation;
	}
	
	public void setOrientation(int o){
		orientation = o;
	}
	
	public Side getSideNorth(){
		if (orientation ==0)
			return north;
		else if (orientation ==1)
			return west;
		else if (orientation==2)
			return south;
		else 
			return east;
	}
	
	public Side getSideEast(){
		if (orientation ==0)
			return east;
		else if (orientation ==1)
			return north;
		else if (orientation==2)
			return west;
		else 
			return south;
	}
	
	public Side getSideSouth(){
		if (orientation ==0)
			return south;
		else if (orientation ==1)
			return east;
		else if (orientation==2)
			return north;
		else 
			return west;
	}
	
	public Side getSideWest(){
		if (orientation ==0)
			return west;
		else if (orientation ==1)
			return south;
		else if (orientation==2)
			return east;
		else 
			return north;
	}
	
	public Side getSide (int num){
		if (num==0){
			return getSideNorth();
		}
		if (num==1 || num==-1){
			return getSideEast();
		}
		if (num==2){
			return getSideSouth();
		}
		return getSideWest();
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
	
	public boolean equals(Piece other){
		int tempOrientation = orientation;
		int otherTempOrientation = other.getOrientation();
		setOrientation(0);
		other.setOrientation(0);
		for(int side = 0; side < 4; side++){
			if(getSide(side).getValue() != other.getSide(side).getValue()){
				setOrientation(tempOrientation);
				other.setOrientation(otherTempOrientation);
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		return "NESW " + north + " " + east + " " + south + " " + west;
	}
}
