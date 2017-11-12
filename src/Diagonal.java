
public class Diagonal {
	private int from;
	private int to;
	private char letterFrom;
	private char letterTo;
	
	public Diagonal(int a, int b, char letterA, char letterB) {
		from = a;
		to = b;
		letterFrom = letterA;
		letterTo = letterB;
	}
	
	// Imprime une diagonale
	public String toString() { 
	    return "" + letterFrom + letterTo;
	} 
	
	// Vérifie si deux diagonales se croisent
	public boolean intersects(Diagonal diagonal) {
		// On s'assure que from est plus petit que To
		int from1 = from < to ? from : to;
		int to1 = from < to ? to : from;
		
		int from2 = diagonal.from < diagonal.to ? diagonal.from : diagonal.to;
		int to2 = diagonal.from < diagonal.to ? diagonal.to : diagonal.from;
		
		return (from2 > from1 && from2 < to1 && to2 > to1) 
				|| (to2 > from1 && to2 < to1 && from2 < from1);
	}
}
