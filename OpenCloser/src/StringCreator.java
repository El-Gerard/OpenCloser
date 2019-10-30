
import com.google.gson.GsonBuilder;
import java.security.MessageDigest;

public class StringCreator {
    
    //Método para aplicar el algoritmo de Sha256 y devolver un String. 
	public static String Sha256(String input){
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			//Aplica SHA256 al input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
	        
			StringBuffer hexString = new StringBuffer(); // Guardara el hash como hexadecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//Método para transformar un objeto en un objeto JSON (aún no se usa)
	public static String getJson(Object o) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(o);
	}
	
	//Método que retorna el string que servirá para compararlo con el hash a minar
        //es decir, será un string lleno del número de ceros que se pasen por dificultad
	public static String getStringDificultad(int dificultad) {
		return new String(new char[dificultad]).replace('\0', '0');
	}
    
}
