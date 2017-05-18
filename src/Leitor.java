import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Binho on 10/05/2017.
 */
public class Leitor {
    // lista em que as palavras seram adicionadas
    Lista dicionario;
    // lista em que as stopswords seram adicionadas
    Lista stopwords;
    // lista em que as linhas seram adicionadas
    public Pagina paginas;
    String arquivo;
    public int contaStopwords;

    public Leitor() {
        stopwords = new Lista();
        dicionario = new Lista();
        paginas = new Pagina();
        leituraStopwords();
        leitura("alice.txt");
    }

    public void analizaPalavra(String str) {
        if(str.equals("")) {
            // não faz nada
        } else if(str.length() < 3) {
            contaStopwords++;
        } else {
            Palavra palavra = new Palavra(str);
            if(verificaStopwords(palavra)) {
                contaStopwords++;
            } else {
                dicionario.adiciona(palavra);
            }
        }
    }

    private void leitura(String origem) {
        Path caminho = Paths.get(origem);
        try (Scanner scannerLinha = new Scanner(Files.newBufferedReader(caminho, Charset.defaultCharset()))) {
            Scanner scannerPalavra = new Scanner(Files.newBufferedReader(caminho, Charset.defaultCharset()));
            //scannerLinha.useDelimiter("[\n]"); // separador: nova linha
            scannerLinha.useDelimiter("[\n]");
            scannerPalavra.useDelimiter("\\W|\\d|_");

            String linhaAtual = "";
            String palavraAtual;
            int contaLinhas;
            //Scanner scannerPalavra = new Scanner(linhaAtual);

            while (scannerLinha.hasNextLine()) {
                linhaAtual = scannerLinha.nextLine();
                paginas.adicionaLinha(linhaAtual);
                //while ()
            }
            while (scannerPalavra.hasNext()) {
                palavraAtual = scannerPalavra.next();
                analizaPalavra(palavraAtual.toLowerCase());
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    private void leituraStopwords() {
        Path caminho = Paths.get("stopwords.txt");
        try (Scanner scanner = new Scanner(Files.newBufferedReader(caminho, Charset.defaultCharset()))) {
            String palavraAtual;
            Palavra palavra;
            while (scanner.hasNext()) {
                palavraAtual = scanner.next();
                palavra = new Palavra(palavraAtual);
                stopwords.adiciona(palavra);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    private boolean verificaStopwords(Palavra palavra) {
        if(stopwords.contem(palavra)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return dicionario.toString() + "\nTotal de palavras: " + dicionario.tamanho() + "\nTotal de stopwords: " + contaStopwords;
    }
}
