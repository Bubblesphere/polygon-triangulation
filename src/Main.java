import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> lines = FileReader.GetFileLines("Config.txt");
		Polygon[] polygons = PolygonParser.parseFromFileContent(lines);

		for (int i = 0; i < polygons.length; i++) {
			System.out.println(polygons[i].toString());
			Arrangement arrangement = new Arrangement(polygons[i].size());
			arrangement.printAllArrangements(0, polygons[i].diagonals());
		}
	}
}