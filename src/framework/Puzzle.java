package framework;

import exceptions.InvalidLocationException;
import exceptions.NotCompatibleException;

public class Puzzle {
	private Board board;
	private Piece[] p = new Piece[9];
	
	
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
	
	public boolean canFit(int row, int column, Piece piece) throws InvalidLocationException{
		Piece[] neighbors = board.getNeighbors(row, column);
		try{
			Object o = neighbors[0];
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new InvalidLocationException("That location is not on the board or even bordering the outside of the board");
		}
		Piece neighborNorth = neighbors[0];
		Piece neighborEast = neighbors[1];
		Piece neighborSouth = neighbors[2];
		Piece neighborWest = neighbors[3];
		return piece.getSideNorth().fits(neighborNorth.getSideSouth())
		&& piece.getSideEast().fits(neighborEast.getSideWest())
		&& piece.getSideSouth().fits(neighborSouth.getSideNorth())
		&& piece.getSideWest().fits(neighborWest.getSideEast());
	}
	
	public void insertPieceAtLocation(int row, int column, Piece piece)throws NotCompatibleException, InvalidLocationException{
		if(canFit(row,column,piece)){
			board.setLocation(row,column,piece);
			return;
		}
		throw new NotCompatibleException("Your piece does not fit at" + column + " , " + row);
	}
	
	public Piece remove(int row, int column){
		Piece pieceRemoved = board.getLocation(row,column);
		board.setLocation(row,column, null);
		return pieceRemoved;
	}
	
	public Piece[] getPieces(){
		return p;
	}
}
