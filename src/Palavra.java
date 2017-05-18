/**
 * Created by Binho on 10/05/2017.
 */
public class Palavra implements Comparable {
    private String palavra;
    private Lista paginas;
    private int contador;

    public Palavra(String texto) {
        palavra = texto;
    }

    @Override
    public String toString() {
        return palavra;
    }

    @Override
    public int compareTo(Object o) {
        //Celula aux = (Celula) o;
        //Palavra outra = (Palavra) aux.elemento;
        Palavra outra = (Palavra) o;
        return palavra.compareToIgnoreCase(outra.palavra);
    }
}
