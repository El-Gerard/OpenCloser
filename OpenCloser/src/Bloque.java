
import java.util.Date;

public class Bloque {

    public String hash; //Hash que se va a crear
    public String hashAnterior; //Hash del bloque anterior
    private String datos; //los datos del bloque(transacciones)
    private long marcaTiempo; //Marca de tiempo obtenida de la fecha (se puede omitir)
    private int nonce; //Número aleatorio para minar el bloque

    //Constructor de bloque.  
    public Bloque(String datos, String hashAnterior) {

        this.datos = datos;
        this.hashAnterior = hashAnterior;
        this.marcaTiempo = new Date().getTime();
        this.hash = calcularHash();
    }

    //Método para calcular el hash utilizando los datos del bloque
    public String calcularHash() {

        String hashCalculado = StringCreator.Sha256(
                hashAnterior
                + Long.toString(marcaTiempo)
                + Integer.toString(nonce)
                + datos
        );
        return hashCalculado;
    }

    //Método para minar el bloque, aumentará el nonce hasta obtener el número de ceros en la dificultad.
    public void minar(int dificultad) {

        String target = StringCreator.getStringDificultad(dificultad); //Se crea un string con el número de ceros a obtener(dificultad)
        //Ejecutará el ciclo hasta que el substring esté lleno de ceros
        while (!hash.substring(0, dificultad).equals(target)) {
            nonce++;
            hash = calcularHash();
        }
        System.out.println("El bloque ha sido minado con éxito: " + hash);
    }

}
