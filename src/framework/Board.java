//Neeraj Asthana Period 5
package framework;

public class Board {
	private Piece[][] board = new Piece[3][3];
	
	public Board(){
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				board[i][j] = null;	
	}
	
	/**
	 * Checks if the provided coordinates define a valid location
	 * on the board.
	 * @param x coordinate
	 * @param y coordinate
	 * @return
	 */
	public boolean isValidLocation(int x, int y){
		if(x > -1 && y > -1 && x < 3 && y < 3)
			return true;
		return false;
	}
	
	/**
	 * Tells whether or not the specified location is empty or
	 * filled.
	 * @param x coordinate
	 * @param y coordinate
	 * @return
	 */
	public boolean isEmpty(int x, int y){
		if(board[x][y] == null)
			return true;
		return false;
	}
	
	/**
	 * Returns the Piece at the specified location on the board.
	 * If either the location is empty or the coordinates are
	 * off the board, the method will return null.
	 * @param x coordinate of the piece
	 * @param y coordinate of the piece
	 * @return the piece at the location
	 */
	public Piece getLocation(int x, int y){
		if (isValidLocation(x,y))
			return board[x][y];
		return null;
	}
	
	/**
	 * Puts a piece at a specified location on the board. Its
	 * return depends on whether or not the setting was successful
	 * (aka if the location was on the board).
	 * @param x coordinate
	 * @param y coordinate
	 * @param piece
	 */
	public boolean setLocation(int x, int y, Piece piece){
		if(isValidLocation(x,y)){
			board[x][y] = piece;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the neighbors of a specified cell in an array.
	 * The Pieces are in North, East, South, West order and
	 * any spots that are empty are null in the array. If the 
	 * specified location is invalid (not on the Board) the
	 * method will return null.
	 * @param x coordinate of the cell
	 * @param y coordinate of the cell
	 * @return array with all the neighboring Pieces
	 */
	public Piece[] getNeighbors(int x, int y){
		if(isValidLocation(x,y)){
			Piece[] array = new Piece[4];
			if(isValidLocation(x,y)){
				array[0] = getLocation(x,y-1);
				array[1] = getLocation(x+1,y);
				array[2] = getLocation(x,y+1);
				array[3] = getLocation(x-1,y);
			}
			return array;
		}
		return null;
	}
	
	/**
	 * Checks to see if all the spots on the Board are filled
	 * @return
	 */
	public boolean isFilled(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == null)
					return false;
			}
		}
		return true;
	}
}
