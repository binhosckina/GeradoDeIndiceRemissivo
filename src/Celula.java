/**
 * Created by Binho on 10/05/2017.
 */
public class Celula implements Comparable {
    public Celula proxima;
    public Comparable elemento;

    public Celula(Celula proxima, Palavra palavra) {
        this.proxima = proxima;
        this.elemento = palavra;
    }

    public Celula(Palavra palavra) {
        this.elemento = palavra;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    public Celula getProxima() {
        return this.proxima;
    }

    public Comparable getElemento() {
        return this.elemento;
    }

    @Override
    public int compareTo(Object o) {
        return elemento.compareTo(o);
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Celula celula = (Celula) o;

        return elemento != null ? elemento.equals(celula.elemento) : celula.elemento == null;
    }
    */
}
