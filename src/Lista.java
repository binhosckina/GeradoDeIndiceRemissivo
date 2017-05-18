/**
 * Created by Binho on 10/05/2017.
 */
public class Lista {
    private Celula primeira;
    private int totalDeElementos;

    public void adiciona(Palavra palavra) {
        //Palavra palavra = new Palavra(str);
        Celula celula = new Celula(palavra);
        int comparacao;

        if (this.isEmpty()) {
            primeira = celula;

        } else {
            // instancia os ponteiros dos iterador
            Celula anterior = null;
            Celula atual = primeira;

            do {
                // faz a comaração pra saber se o elemento da celula vem antes(< 0), é igual(= 0) ou depois(> 0)
                // e evita de fazer a comparação varias vezes
                comparacao = celula.elemento.compareTo(atual.elemento);

                if(comparacao < 0) {

                    if (anterior == null) {
                        // adiciona no começo
                        celula.proxima = primeira;
                        primeira = celula;

                    } else {
                        // adiciona no meio
                        anterior.proxima = celula;
                        celula.proxima = atual;
                    }
                } else if (comparacao > 0 && atual.proxima == null) {
                    // adiciona no fim
                    atual.proxima = celula;
                }

                // faz o iteradores andarem uma celula pra frente
                anterior = atual;
                atual = atual.proxima;

            } while (comparacao > 0);
        }
        totalDeElementos++;
    }

    public void adicionaVazia(Object elemento) {

    }

    public void adicionaLinha(String linha) {

    }

    /*
    public void adiciona(Object elemento) {
        if(totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            ultima.proxima = nova;
            ultima = nova;
            totalDeElementos++;
        }
    }
    */

    /*
    public void adiciona(int posicao, Object elemento) throws Exception{
        if(posicao < 0 || posicao > totalDeElementos) {
            throw new Exception("Posição inválida");
        } else if(posicao == 0) {
            adicionaNoComeco(elemento);
        } else if(posicao == totalDeElementos) {
            adiciona(elemento);
        } else {
            Celula nova = new Celula(elemento);
            Celula anterior = iterador(posicao - 1);
            nova.proxima = anterior.proxima;
            anterior.proxima = nova;
            totalDeElementos++;
        }
    }
    */

    /*
    public void adicionaNoComeco(Object elemento) {
        Celula nova = new Celula(elemento);
        if(totalDeElementos == 0) {
            primeira = nova;
        } else {
            nova.proxima = primeira;
            primeira = nova;
        }
        totalDeElementos++;
    }
    */

    /*
    public Object pega(int posicao) {
        Celula atual = iterador(posicao);
        return atual.elemento;
    }
    */

    /*
    public void remove(int posicao) throws Exception {
        if(totalDeElementos == 0) {
            throw new Exception("Lista vazia");
        } else if(totalDeElementos == 1 || posicao == 0) {
            removeDoComeco();
        } else if(posicao == totalDeElementos - 1) {
            removeDoFim();
        } else {
            Celula anterior = iterador(posicao - 1);
            anterior.proxima = anterior.proxima.proxima;
            totalDeElementos--;
        }
    }
    */

    /*
    public void removeDoComeco() throws Exception {
        if(totalDeElementos == 0) {
            throw new Exception("Lista vazia");
        } else if(totalDeElementos == 1) {
            primeira = ultima = null;
            totalDeElementos--;
        } else {
            primeira = primeira.proxima;
            totalDeElementos--;
        }
    }
    */

    /*
    public void removeDoFim() throws Exception {
        if(totalDeElementos == 0) {
            throw new Exception("Lista vazia");
        } else if (totalDeElementos == 1) {
            removeDoComeco();
        } else if (totalDeElementos == 2) {
            ultima = primeira;
            totalDeElementos--;
        } else {
            Celula nova = primeira;
            do {
                nova = nova.proxima;
            } while (nova.proxima != ultima);
            ultima = nova;
            totalDeElementos--;
        }
    }
    */

    // retorna a quantidade de elementos da lista
    public int tamanho() {
        return totalDeElementos;
    }

    // diz se um elemento está contido na lista
    public boolean contem(Object elemento) {
        Comparable comp = (Comparable) elemento;
        Celula atual = primeira;
        do {
            if (comp.compareTo(atual.elemento) < 0) {
                return false;
            } else if (comp.compareTo(atual.elemento) == 0) {
                return true;
            }
            atual = atual.proxima;
        } while (atual.proxima != null);
        return false;
    }


    public boolean isEmpty() {
        return tamanho() == 0;
    }

    public Object primeira() {
        return primeira;
    }

    /*
    public void clear() {
        head
    }
    */

    private Celula iterador(int iteracoes) {
        Celula atual = primeira;
        for (int i = 0; i < iteracoes; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }


    @Override
    public String toString() {
        if(this.totalDeElementos == 0) {
            return "[]";
        } else if (totalDeElementos == 1) {
            return "[" + primeira.elemento + "]";
        } else {
            StringBuilder builder = new StringBuilder();
            Celula atual = primeira;
            builder.append("[");

            do {
                builder.append(atual.elemento);
                builder.append(", ");
                atual = atual.proxima;
            } while (atual.proxima != null);

            builder.append(atual.elemento);
            builder.append("]");

            return builder.toString();
        }
    }

}
