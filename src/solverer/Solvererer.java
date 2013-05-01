package solverer;

import java.awt.Point;
import java.util.ArrayList;

import framework.*;
import gui.PuzzleGameFrame;

public class Solvererer {

	public static void solve(Puzzle puzzle){
		if (puzzle.isSolved()) return;
		Piece[] pieces = puzzle.getPieces();
		ArrayList<Piece> unused = new ArrayList<Piece>(9);
		for(Piece p : pieces) unused.add(p);
		solve(unused, puzzle, 0, -1);

	}

	public static boolean solve(ArrayList<Piece> unused, Puzzle puzzle, int x, int y){
		if(puzzle.isSolved()) return true;

		Point nextPoint = next(x,y,puzzle.getBoard());
		
		if(nextPoint == null) 
			return puzzle.isSolved();

		x = nextPoint.x; y = nextPoint.y;

		boolean success = false;

		for(int i = 0; i < unused.size(); i++){
			Piece p = unused.get(i);
			for (int j = 0; j < 4; j++) {
				if(puzzle.insertPieceAtLocation(x, y, p)){
					unused.remove(i);
					if (solve(unused, puzzle, x, y)){
						success = true;
						break;
					}
					else{
						puzzle.remove(x, y);
					}
					unused.add(i, p);
				}
				p.rotate();
			}
		}

		return success;
	}

	public static Point next(int x, int y, Board b){
		y++;
		if(b.isValidLocation(x, y)) return new Point(x,y);
		if(y >= b.getWidth())
			y = 0; x++;
		if(b.isValidLocation(x, y)) return new Point(x,y);
		return null;
	}


	public static void main(String[] aadfjasja){
		Puzzle p = new Puzzle();
		solve(p);
		PuzzleGameFrame f = new PuzzleGameFrame();
		f.pC.solve(p);
	}
}
