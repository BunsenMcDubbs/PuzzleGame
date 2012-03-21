
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
		//set the pieces
		board = new Board(3,3);
	}
	
	public boolean canFit(int row, int column, Piece piece){
		
	}
	
	public void insertPieceAtLocation(int row, int column, Piece piece){
		if(piece.canFit()){
			board.setCell(row,column,piece);
		}
	}
	
	public Piece remove(int row, int column){
		Piece pieceRemoved = board.getCell(row,column);
		board.setCell(row,column, null);
		return pieceRemoved;
	}
}
