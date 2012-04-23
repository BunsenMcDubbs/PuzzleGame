package solver;
import java.util.ArrayList;
import framework.*;
public class RecursiveSolve {

	Puzzle p;
	int turnCounter;
	
	public RecursiveSolve(Puzzle p){
		this.p = p;
		turnCounter = 0;
	}
	
	public int getSpotX(int spot){
		if(spot == 2 || spot == 3 || spot==9)
			return 0;
		if(spot == 4 ||spot == 1||spot == 8)
			return 1;
		return 2;
	}
	
	public int getSpotY(int spot){
		if(spot >= 3 && spot <= 5)
			return 0;
		if(spot == 1 || spot == 2 || spot == 6)
			return 1;
		return 2;
	}
	
	public boolean fitsAtSpot(Piece piece, int spot){
		if(p.canFit(getSpotX(spot), getSpotY(spot),piece))
			return true;
		return false;
	}
	
	public boolean recursiveSolve (ArrayList<Piece> array, int spot){
		if (p.isSolved())
			return true;
		for(int i=0; i<array.size(); i++){
			Piece removed= array.remove(i);
			for (int j=0; j<4; j++){
				if (p.canFit(getSpotY(spot), getSpotX(spot), removed)){
					p.insertPieceAtLocation(getSpotY(spot),getSpotX(spot),removed);
//					System.out.println(array.size());
					if (recursiveSolve(array, spot+1))
						return true;					
					p.clearPuzzleFrom(spot-1);
				}
				removed.rotate();					
			}
			array.add(i,removed);
		}
		return false;
	}

	public ArrayList<Piece> makeArrayList(Piece [] array){
		ArrayList<Piece> newArray = new ArrayList<Piece>();
		for(int i = 0; i < array.length; i++)
			newArray.add(array[i]);
		return newArray;
	}
	
	public Puzzle solve(){
		recursiveSolve(makeArrayList(p.getPieces()), 1);
		return p;
	}
}