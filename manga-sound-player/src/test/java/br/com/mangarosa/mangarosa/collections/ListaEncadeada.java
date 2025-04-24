package br.com.mangarosa.mangarosa.collections;

public class ListaEncadeada {
    protected No inicio;
    protected int tamanho;

    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    public void adicionar(Musica musica) {
        No novo = new No(musica);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public Musica get(int index) {
        No atual = inicio;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.musica;
    }

    public int getTamanho() {
        return tamanho;
    }
}
