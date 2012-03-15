/**
 *@author Andrew Dai
 *
 *Generic Board class for all board games using a 2D board.
 *It uses a 2D array of integers to allow for each cell/
 *spot on the board to have multiple states.
 *
 */
package framework;
import java.util.ArrayList;

public class Board {

	private int [][] board;
	
	public Board() {
		this(10,10);
	}
	
	public Board(int row, int col){
		board = new int [row][col];
		setAllToZero();
	}
	
	public Board(Board newBoard){
		board = newBoard.boardToArray();
	}
	
	public int[][] boardToArray(){
		int xLen = getXSize(), yLen = getYSize();
		int [][] array = new int[xLen][yLen];
		for (int x = 0; x < xLen; x++){
			for (int y = 0; y < yLen; y++){
				array[x][y] = getCell(x,y);
			}
		}
		return array;
	}
	
	public void setCell(int x, int y, int value){
		if (isValidLoc(x,y))
			board[x][y] = value;
	}
	
	public void reset(){
		board = new int[board.length][board[0].length];
		setAllToZero();
	}
	
	private void setAllToZero(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public int getCell(int row, int col){
		return board[row][col];
	}
	
	public boolean isValidLoc(int x, int y){
		if (x > board.length-1 || y > board[0].length-1
				|| x < 0 || y < 0){
			return false;
		}
		else
			return true;

	}
	
	public ArrayList<Integer> neighbors(int x, int y){
		ArrayList<Integer> neighbors = new ArrayList<Integer>(0);
		for (int x1 = x - 1; x1 <= x + 1; x1++){
			for (int y1 = y - 1; y1 <= y + 1; y1++){
				if (x1 == x && y1 == y)
					continue;
				else if (isValidLoc(x1, y1)){
					neighbors.add(board[x1][y1]);
				}
			}
		}
		return neighbors;
	}
	
	public int getYSize(){
		return board.length;
	}
	
	public int getXSize(){
		return board[0].length;
	}
	
	public int[][] getBoard(){
		return board;
	}
}
