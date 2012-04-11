package framework;

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
	
	public boolean insertPieceAtLocation(int x, int y, Piece piece){
		if(canFit(x,y,piece)){
			board.setLocation(x,y,piece);
			return true;
		}
		return false;
	}
	
	public Piece remove(int x, int y){
		Piece pieceRemoved = board.getLocation(x,y);
		board.setLocation(x,y, null);
		return pieceRemoved;
	}
	
	public Piece[] getPieces(){
		return p;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public boolean isSolved(){
		if(board.isFilled())
			return true;
		return false;
	}
	
	public void empty(){
		board.empty();
	}
	
	public static void main (String [] args){
		Puzzle p = new Puzzle();
		Piece [] array= p.getPieces();
		p.insertPieceAtLocation(1,1, array [0]);
	}
}