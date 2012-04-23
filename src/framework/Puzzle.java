package framework;

import java.awt.Point;

/**
 * The Puzzle class performs all of the executive functions 
 * behind the game. 
 * It contains a Board and an array of 9 Pieces in the private data
 * It has a single default constructor with no parameters that 
 * creates all of the Pieces and creates a new Board
 * Methods included in this class are canFit, insertPieceAtLocation,
 * clearPuzzleFrom, remove, getPieces, getBoard, isSolved, empty,
 * find, and toString.
 */
public class Puzzle {
	private Board board;
	private Piece[] p = new Piece[9];	
	
	/**
	 * Constructor method
	 * Has no parameters or return type
	 * Creates all of the Pieces
	 * Uses default constructor of Board to set board
	 */
	public Puzzle(){
		board = new Board();
		p[0] = new Piece(new Side(Side.outSpade),
				new Side(Side.outDiamond),
				new Side(Side.inSpade),
				new Side(Side.inHeart));
		p[1] = new Piece(new Side(Side.outSpade),
				new Side(Side.outSpade),
				new Side(Side.inHeart),
				new Side(Side.inClub));
		p[2] = new Piece(new Side(Side.outClub),
				new Side(Side.outHeart),
				new Side(Side.inDiamond),
				new Side(Side.inClub));
		p[3] = new Piece(new Side(Side.outClub),
				new Side(Side.outHeart),
				new Side(Side.inSpade),
				new Side(Side.inHeart));
		p[4] = new Piece(new Side(Side.outSpade),
				new Side(Side.outDiamond),
				new Side(Side.inHeart),
				new Side(Side.inDiamond));
		p[5] = new Piece(new Side(Side.outHeart),
				new Side(Side.outSpade),
				new Side(Side.inSpade),
				new Side(Side.inClub));
		p[6] = new Piece(new Side(Side.outHeart),
				new Side(Side.outDiamond),
				new Side(Side.inClub),
				new Side(Side.inClub));
		p[7] = new Piece(new Side(Side.outDiamond),
				new Side(Side.outClub),
				new Side(Side.inClub),
				new Side(Side.inDiamond));
		p[8] = new Piece(new Side(Side.outHeart),
				new Side(Side.outDiamond),
				new Side(Side.inDiamond),
				new Side(Side.inHeart));
	}
	
	/**
	 * Checks to see if a Piece fits at a location
	 * @param x - int that signifies the column the Piece is in
	 * @param y - int that signifies the row the Piece is in 
	 * @param piece - Piece that user is trying to fit in a location
	 * @return - a boolean value. True if it can fit at that location
	 * or else it will return false if it cannot fit
	 * Creates an array of Pieces (neighbors) that delegates to the
	 * getNeighbors method of Board class.
	 * Cycles through neighbors and uses a switch case structure to
	 * check each of the sides 
	 */
	public boolean canFit(int x, int y, Piece piece){
		Piece[] neighbors = board.getNeighbors(x, y);
		for(int i = 0; i < neighbors.length; i++){
			if(neighbors[i] != null){
				boolean fits = true;
				switch(i){
				case 0: fits = piece.getSideNorth().fits(neighbors[i].getSideSouth()); break;
				case 1: fits = piece.getSideEast().fits(neighbors[i].getSideWest()); break;
				case 2: fits = piece.getSideSouth().fits(neighbors[i].getSideNorth()); break;
				case 3: fits = piece.getSideWest().fits(neighbors[i].getSideEast()); break;
				}
				if (!fits){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Checks if the piece can fit at the location (x,y) and then inserts it
	 * if canFit() returns true
	 * @param x
	 * @param y
	 * @param piece
	 * @return
	 */
	public boolean insertPieceAtLocation(int x, int y, Piece piece){
		if(canFit(x,y,piece)){
			board.setLocation(x,y,piece);
			return true;
		}
		return false;
	}
	
	/**
	 * Hands-off to the Board class's clearPuzzleFrom()
	 * @param i
	 */
    public void clearPuzzleFrom(int i){
		board.clearBoardFrom(i);
	}
    
    /**
     * Removes and returns the piece at location (x,y)
     * @param x
     * @param y
     * @return the removed piece
     */
	public Piece remove(int x, int y){
		Piece pieceRemoved = board.getLocation(x,y);
		board.setLocation(x,y, null);
		return pieceRemoved;
	}
	
	/**
	 * @return the array of all the pieces of the puzzle
	 */
	public Piece[] getPieces(){
		return p;
	}
	
	/**
	 * @return the board
	 */
	public Board getBoard(){
		return board;
	}
	
	/**
	 * @return true if the puzzle is solved, false if it isn't
	 */
	public boolean isSolved(){
		if(board.isFilled())
			return true;
		return false;
	}
	
	/**
	 * Clears the board
	 */
	public void empty(){
		board.empty();
	}
    
	/**
	 * Finds a given piece in the board
	 * @param piece
	 * @return coordinates of the piece if it is in the board or null if it isn't
	 */
	public Point find(Piece piece) {
		for (int x = 0; x < board.getWidth(); x++)
			for (int y = 0; y < board.getHeight(); y++)
				if (piece == board.getLocation(x, y))
					return new Point(x,y);
		return null;
	}
    
	/**
	 * @return a string representation of the puzzle
	 */
	public String toString(){
		String s= "";
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				s =s +(board.getLocation(i,j)) + "\n";
			}
		}
		return s;
	}
}