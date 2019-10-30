
import java.util.ArrayList;

public class Main {

    //Lista que guardará lo bloques creados
    public static ArrayList<Bloque> blockchain = new ArrayList<Bloque>();
    //dificultad de minado (número de ceros como objetivo)
    public static int dificultad = 5;

    public static void main(String[] args) {

        System.out.println("Minando bloque 1...");
        añadirBloque(new Bloque("Aqui deberían venir datos", "0"));

        System.out.println("Minando bloque 2... ");
        añadirBloque(new Bloque("Aqui tambien deberían haber más datsos", blockchain.get(blockchain.size() - 1).hash));

        System.out.println("Minando bloque 3...");
        añadirBloque(new Bloque("Sigo sin tener datos we", blockchain.get(blockchain.size() - 1).hash));

        String blockchainJson = StringCreator.getJson(blockchain);
        System.out.println("\nCadena de bloques hasta ahora: ");
        System.out.println(blockchainJson);

    }

    public static void añadirBloque(Bloque nuevo) {
        nuevo.minar(dificultad);
        blockchain.add(nuevo);
    }

}
