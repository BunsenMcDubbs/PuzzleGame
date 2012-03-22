//Neeraj Asthana Period 5
package framework;

public class Board {
	private Piece[][] board = new Piece[3][3];
	
	public Board(){
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				board[i][j] = null;	
	}
	
	public boolean isValidLocation(int x, int y){
		if(x > -1 && y > -1 && x < 3 && y < 3)
			return true;
		return false;
	}
	
	public boolean isEmpty(int x, int y){
		if(board[x][y] == null)
			return true;
		return false;
	}
	
	public Piece getLocation(int x, int y){
		if (isValidLocation(x,y))
			return board[x][y];
		return null;
	}
	
	public void setLocation(int x, int y, Piece piece){
		if(isValidLocation(x,y))
			board[x][y] = piece;
	}
	
	public Piece[] getNeighbors(int x, int y){
		Piece[] array = new Piece[4];
		if(isValidLocation(x,y)){
			array[0] = getLocation(x,y-1);
			array[1] = getLocation(x+1,y);
			array[2] = getLocation(x,y+1);
			array[3] = getLocation(x-1,y);
		}
		return array;
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
