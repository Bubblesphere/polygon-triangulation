

public class Utils {
	// Cr�e un message d'erreur format�
	public static String errorMessage(String errorMessage, Exception ex) {
		return "Expected " + errorMessage + ". Details: " + ex.getMessage();
	}
}
