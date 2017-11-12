
public class Polygon {
	private String letters;
	private Diagonal[] diagonals;
	private int size;
	
	public Polygon(int polygonSize, String polygonLetters) {
		size = polygonSize;
		letters = polygonLetters;
		diagonals = getDiagonals();
	}
	
	public Diagonal[] diagonals() {
		return diagonals;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		return "Polygone " + letters;
	}
	
	// Obtiens l'ensemble des diagonales d'un polygone (sans duplication) 
	private Diagonal[] getDiagonals() {
		int totalDiagonals = getTotalDiagonals();
		Diagonal[] diagonals = new Diagonal[totalDiagonals];
		int diagonalIndex = 0;
		for(int i = 0; i < size; i++) {
			// Début au sommet + 2
			int startIndex = i + 2;
			
			// Fin au sommet - 2
			int endIndex = (size + i - 1) % size;
			
			// Empêche de trouver une diagonale déjà trouvé
			if (i > endIndex) {
				endIndex = 0;
			}
			
			int j = startIndex;
			
			while (j != endIndex) {
				diagonals[diagonalIndex++] = new Diagonal(i, j, letters.charAt(i), letters.charAt(j));
				// Incrémentation de j tout en s'assurant que j ne dépasse pas polygon.length
				j = (j + 1) % size;
			}
			
			if (diagonalIndex == totalDiagonals) {
				break;
			}
		}
		return diagonals;
	}
	
	// Obtiens le nombre total de diagonales
	private int getTotalDiagonals() {
		return size * (size - 3) / 2;
	}
}
