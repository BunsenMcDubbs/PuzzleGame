package framework;

/**
 * The Side class represents the side of a single Puzzle Piece.
 *  It will hold the value of side as private data, which is the shape of the
 *  Side. All negative values are "out" shapes and all positive 
 *  values are "in" shapes. The methods included in this class are:
 *  getValue, setValue, isValidValue, fits, and a toString. This class
 *  also creates many static final variables between -4 and 4 inclusive,
 *  which represent the shapes. 
 */
public class Side {
	private int value;

	/**
	 * Constructor method
	 * @param value - receives an int which corresponds to the shape
	 * no return type
	 * delegates to the setValue method to set the original value.
	 */
	public Side(int value){
		setValue(value);
	}

	/**
	 * This method returns the value integer in the private data. 
	 * It has no parameters. 
	 * @return - the value as an int.
	 */
	public int getValue(){
		return value;
	}

	/**
	 * The setValue method 
	 * @param value - takes in an int which will become value
	 * has no return type
	 * checks to see if value is valid by delegating to the isValidValue method
	 * changes value to the value in the parameter
	 */
	public void setValue(int value){
		if(isValidValue(value))
			this.value = value;
	}

	/**
	 * The isValidValue method checks to make sure that the value is 
	 * one of the side values.
	 * @param num - takes in a an int, which is the number 
	 * the method will check
	 * @return - boolean value that tells whether num is ok to use
	 * Method will return true if num is between -4 and 4 inclusive
	 * Method will return false if num is not between -4 and 4 inclusive
	 */
	public boolean isValidValue(int num){
		if (num <=4 && num >= -4)
			return true;
		return false;
	}
	
	/**
	 * checks to see if this Side will fit with another Side
	 * @param side - takes in a Side to compare to
	 * @return - a boolean value which is true if it fits or false if not
	 * adds the value of each side together by delegating to the getValue method
	 * if this sum is zero, then it will return true
	 * or else it will return false
	 */
	public boolean fits(Side side){
		if(side.getValue() + getValue() == 0)
			return true;
		return false;
	}

	/**
	 * @return a string representation of the side object
	 */
	public String toString(){
		switch(value){
		case(inHeart): return "inHeart";
		case(inSpade): return "inSpade";
		case(inClub): return "inClub";
		case(inDiamond): return "inDiamond";
		case(outHeart): return "outHeart";
		case(outSpade): return "outSpade";
		case(outClub): return "outClub";
		case(outDiamond): return "outDiamond";
		}
		return "";
	}

	public static final int inHeart = 1;
	public static final int inSpade = 2;
	public static final int inClub = 3;
	public static final int inDiamond = 4;
	public static final int outHeart = -1;
	public static final int outSpade = -2;
	public static final int outClub = -3;
	public static final int outDiamond = -4;
}
