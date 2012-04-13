package framework;
//Neeraj Asthana Period 5

public class Side {
	private int value;
	
	public Side(int value){
		setValue(value);
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		if(isValidValue(value))
			this.value = value;
	}
	
	public boolean isValidValue(int num){
		if (num <=4 && num >= -4)
			return true;
		return false;
	}
	
	public boolean fits(Side side){
		if(side.getValue() + getValue() == 0)
			return true;
		return false;
	}
	
	public String toString(){
		switch(value){
		case(inHeart): return "inHeart";
		case(inSpade): return "inSpade";
		case(inClub): return "inClub";
		case(inDiamond): return "inDiamond";
		case(outHeart): return "outHeart";
		case(outSpade): return "outSpade";
		case(outClub): return "outClub";
		case(outDiamond): return "outDiamond";
		}
		return "";
	}
	
	public static final int inHeart = 1;
	public static final int inSpade = 2;
	public static final int inClub = 3;
	public static final int inDiamond = 4;
	public static final int outHeart = -1;
	public static final int outSpade = -2;
	public static final int outClub = -3;
	public static final int outDiamond = -4;
}
