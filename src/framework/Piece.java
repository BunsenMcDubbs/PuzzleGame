package framework;

/**
 * The purpose of this class is to create a Piece object can be used in a 
 * jigsaw puzzle. For private data a Piece has 4 sides, a north, east, south 
 * and west side. Each side has a value which determines the shape of the 
 * piece (see Side class to see what each integer means). There is also an
 * integer for orientation which records how may times the piece has been 
 * rotated and a boolean which tells if the Piece is in or out of the Puzzle.
 * The class has two 4 argument constructors, one which take sin sides and 
 * one that takes in integers. The methods in this class include getters for
 * sides, orientation and the boolean 'in'. There is also a setter for 'in'. 
 * Other methods include rotateClockwise and rotateCounterClockwise.  
 */
public class Piece {
	
	private Side north;
	private Side east;
	private Side south;
	private Side west; 
	private int orientation;
	private boolean in;
	
	
	/**
	 * The constructor takes in 4 sides, one for each direction, and sets the private
	 * data equal to the values it takes in. The orientation of a new Piece is set to
	 * zero and the Piece is automatically set so that it is not in the Puzzle.
	 * @param north side
	 * @param east side
	 * @param south side
	 * @param west side
	 */
	public Piece (Side n, Side e, Side s, Side w){
		north=n;
		east=e;
		south=s;
		west=w;
		orientation= 0;
		in = false;
	}
	
	/**
	 *This constructor takes in 4 integers and based on the integers it creates four
	 *Side objects which will be used as the sides of the Piece. This Side objects
	 *are then sent to the constructor above. 
	 * @param north side
	 * @param east side
	 * @param south side
	 * @param west side
	 */
	public Piece (int n, int e, int s, int w){
		this(new Side(n), new Side(e), new Side(s), new Side(w));
	}
	
	
	/**
	 * Rotates Piece clockwise by incrementing orientation
	 */
	public void rotateClockwise (){
		orientation++;
		if (orientation==4)
			orientation=0;
	}
	
	/**
	 * Rotates Piece clockwise by calling rotateClockwise()
	 */
	public void rotate (){
		rotateClockwise();
	}
	
	/**
	 * Rotates Piece counter clockwise by decrementing orientation 
	 */
	public void rotateCounterClockwise(){
		orientation --;
		if (orientation==-1)
			orientation=3;
	}
	
	
	/**
	 * Returns Piece's orientation
	 * @return
	 */
	public int getOrientation(){
		return orientation;
	}
    
    /**
     * Sets the Piece's orientation
     * @param o
     */
	public void setOrientation(int o){
		orientation = o;
	}
	
	/**
	 * Based on the Piece's orientation it determines which side is
	 * the north side and returns the Side object
	 */
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
	
	/**
	 * Based on the Piece's orientation it determines which side is
	 * the east side and returns the Side object
	 */
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
	
	/**
	 * Based on the Piece's orientation it determines which side is
	 * the south side and returns the Side object
	 */
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
	
	/**
	 * Based on the Piece's orientation it determines which side is
	 * the west side and returns the Side object
	 */
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
	
	/**
	 * Takes in an integer which represents a side number (0=north,
	 * 1 or -1=east, 2=south, 3=west) and returns that Side 
	 */
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
	
	/**
	 * Returns true if Piece is in the puzzle or board
	 * @return
	 */
	public boolean isIn (){
		if (in==true)
			return true;
		return false;
	}
	
	/**
	 * Sets Piece in the board
	 */
	public void setIn (){
		in=true;
	}
	
	/**
	 * Sets Piece out of the Board
	 */
	public void setOut (){
		in=false;
	}
    
	/**
	 * Checks if this piece is equal to the give Piece
	 * @param other
	 * @return
	 */
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
	
	/**
	 * Creates String representation by printing out the numerical values
	 * of each of the sides, starting with the north side and proceeding
	 * clockwise
	 */
	public String toString(){
		return "NESW " + north + " " + east + " " + south + " " + west;
	}
}
