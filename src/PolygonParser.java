import java.util.List;

public class PolygonParser {
	private static int lineCursor = 0;
	
	// Retourne les polygons en param�tres
	public static Polygon[] parseFromFileContent(List<String> lines) {
		// Premi�rement, on cr�e un tableau des n polygons pr�sents dans le fichier
		Polygon[] polygon = new Polygon[retrieveNumberOfPolygon(lines.get(lineCursor))];
		
		// On cr�e un polygone pour chaque ligne suivantes
		for(int i = 0; i < polygon.length; i++) {
			String line = lines.get(lineCursor++);
			polygon[i] = new Polygon(line.length(), line);
		}

		return polygon;
	}
	
	// Retourne le nombre de polygone en param�tres
	private static int retrieveNumberOfPolygon(String line) {
		try {
			int nbPolygons = Integer.parseInt(line);
			++lineCursor;
			return nbPolygons;
		} catch (Exception ex) {
			System.err.println(Utils.errorMessage("an integer on line " + lineCursor, ex));
			System.exit(1);
		}
		return 0;
	}
}
