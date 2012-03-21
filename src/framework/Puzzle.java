package framework;

public class Puzzle {
	private Board board;
	private Piece piece1;
	private Piece piece2;
	private Piece piece3;
	private Piece piece4;
	private Piece piece5;
	private Piece piece6;
	private Piece piece7;
	private Piece piece8;
	private Piece piece9;
	
	
	public Puzzle(){
		board = new Board();
		piece1 = new Piece(new Side(Side.outSpade),
				new Side(Side.outDiamond),
				new Side(Side.inSpade),
				new Side(Side.inHeart));
		piece2 = new Piece(new Side(Side.outSpade),
				new Side(Side.outSpade),
				new Side(Side.inHeart),
				new Side(Side.inClub));
		piece3 = new Piece(new Side(Side.outClub),
				new Side(Side.outHeart),
				new Side(Side.inDiamond),
				new Side(Side.inClub));
		piece4 = new Piece(new Side(Side.outClub),
				new Side(Side.outHeart),
				new Side(Side.inSpade),
				new Side(Side.inHeart));
		piece5 = new Piece(new Side(Side.outSpade),
				new Side(Side.outDiamond),
				new Side(Side.inHeart),
				new Side(Side.inDiamond));
		piece6 = new Piece(new Side(Side.outHeart),
				new Side(Side.outSpade),
				new Side(Side.inSpade),
				new Side(Side.inClub));
		piece7 = new Piece(new Side(Side.outHeart),
				new Side(Side.outDiamond),
				new Side(Side.inClub),
				new Side(Side.inClub));
		piece8 = new Piece(new Side(Side.outDiamond),
				new Side(Side.outClub),
				new Side(Side.inClub),
				new Side(Side.inDiamond));
		piece9 = new Piece(new Side(Side.outHeart),
				new Side(Side.outDiamond),
				new Side(Side.inDiamond),
				new Side(Side.inHeart));
	}
	
	public boolean canFit(int row, int column, Piece piece){
		Piece[] neighbors = board.getNeighbors(row, column);
		Piece neighborNorth = neighbors[0];
		Piece neighborEast = neighbors[1];
		Piece neighborSouth = neighbors[2];
		Piece neighborWest = neighbors[3];
		return piece.getSideNorth().fits(neighborNorth.getSideSouth())
		&& piece.getSideEast().fits(neighborEast.getSideWest())
		&& piece.getSideSouth().fits(neighborSouth.getSideNorth())
		&& piece.getSideWest().fits(neighborWest.getSideEast());
	}
	
	public void insertPieceAtLocation(int row, int column, Piece piece){
		if(canFit(row,column,piece)){
			board.setLocation(row,column,piece);
		}
	}
	
	public Piece remove(int row, int column){
		Piece pieceRemoved = board.getLocation(row,column);
		board.setLocation(row,column, null);
		return pieceRemoved;
	}
}
