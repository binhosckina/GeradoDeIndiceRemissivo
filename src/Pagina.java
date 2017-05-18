import java.util.ArrayList;

/**
 * Created by Binho on 10/05/2017.
 */
public class Pagina {
    public int contador;
    public ArrayList<String> linhas;

    public Pagina() {
        linhas = new ArrayList<>();
    }

    public void adicionaLinha(String linha) {
        linhas.add(linha);
    }

    public String retornaPagina(int numero) {
        StringBuilder sb = new StringBuilder();
        for (int i = (numero - 1) * 40; i < numero * 40; i++) {
            sb.append(linhas.get(i));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "";
    }
}
