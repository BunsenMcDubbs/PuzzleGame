//Neeraj Asthana Period 5
package framework;

public class Board {
	private Piece[][] board;
	
	public Board(){
		board = new Piece[3][3];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				board[i][j] = null;	
	}
    
	public Board(int x, int y){
		board = new Piece[x][y];
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
	
	public void empty(){
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				board[x][y] = null;
			}
		}
	}
    
public void clearBoardFrom(int spot){
		if (spot==0){
			empty();
		}
		if (spot==1){
			for (int i=0; i<3; i++){
				board [0][i]=null;
				board [2][i]=null;
			}
			board [1][2]=null;
			board [1][0]=null;
		}
		if (spot==2){
			for (int i=0; i<3; i++){
				board [0][i]=null;
				board [2][i]=null;
			}
			board [1][2]=null;
		}
		if (spot==3){
			for (int i=1; i<3; i++){
				board [0][i]=null;
				board [2][i]=null;
			}
			board [1][2]=null;
			board [2][0]=null;
		}
		if (spot==4){
			for (int i=0; i<3; i++){
				board [2][i]=null;
			}
			board [1][2]=null;
			board [0][2]=null;
		}
		if (spot==5){
			for (int i=0; i<3; i++){
				board [2][i]=null;
			}
			board [1][2]=null;
		}
		if (spot==6){
			for (int i=0; i<3; i++){
				board [2][i]=null;
			}
		}
		if (spot==7){
			board [2][0]=null;
			board [2][1]=null;
		}
		if (spot==8){
			board [2][0]=null;
		}
	}
	
	public boolean isSolved(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == null)
					return false;
			}
		}
		return true;
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

	public boolean isEmpty() {
		for (int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				if(board[i][j] != null)
					return false;
		return true;
	}
	
	public int getWidth(){
		return board.length;
	}
	
	public int getHeight(){
		return board[0].length;
	}
}
