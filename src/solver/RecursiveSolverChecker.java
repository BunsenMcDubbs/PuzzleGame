package solver;
import framework.*;

public class RecursiveSolverChecker {
	public static void main(String[] args){
	Puzzle p = new Puzzle();	
	RecursiveSolve r = new RecursiveSolve(p);
	r.solve();
	}
}
