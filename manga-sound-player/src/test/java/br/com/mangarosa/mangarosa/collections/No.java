package br.com.mangarosa.mangarosa.collections;

public class No {
    public Musica musica;
    public No proximo;

    public No(Musica musica) {
        this.musica = musica;
        this.proximo = null;
    }
}