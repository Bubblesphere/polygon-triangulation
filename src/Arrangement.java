public class Arrangement {
	private int arrangementSize;
	private Diagonal[] arrangement;
	private int arranged;
	private int foundArrangement = 0;
	
	public Arrangement(int polygonSize) {
		arrangementSize = polygonSize - 3;
		arrangement = new Diagonal[arrangementSize];
		arranged = 0;
	}
	
	// Imprime l'ensemble des arrangements valides
	public void printAllArrangements(int index, Diagonal[] diagonals) {
		for (int i = index; i < diagonals.length; i++) {
			if (!intersectsArrangement(diagonals[i])) {
				arrangement[arranged++] = diagonals[i];
				if (arranged == arrangementSize) {
					foundArrangement++;
					// récursivité
					printArrangement();
					arranged--;
				} else {
					printAllArrangements(i + 1, diagonals);
				}
			}
		}
		arranged--;
	}
	
	// Vérifie si une diagonale croise un arrangement
	private  boolean intersectsArrangement(Diagonal newDiagonal) {
		for(int i = 0; i < arranged; i++) {
			if (arrangement[i].intersects(newDiagonal)) {
				return true;
			}
		}
		return false;
	}
	
	// Imprime un arrangement
	private void printArrangement() {
		System.out.print(foundArrangement);
		for (int i = 0; i < arrangementSize; i++) {
			System.out.print(" " + arrangement[i].toString());
		}
		System.out.println("\r\n");
	}
}
