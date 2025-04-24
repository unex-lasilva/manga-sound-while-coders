package br.com.mangarosa.mangarosa.collections;

import java.util.Scanner;

//ao executar informar o nome da música "night-road.wav"//

public class ListaReproducao extends ListaEncadeada {
    private String nome;
    private ReprodutorLista Reprodutor;

    public ListaReproducao(String nome) {
        super();
        this.nome = nome;
    }

    public void tocar() {
        Scanner scanner = new Scanner(System.in);
        No atual = inicio;
        while (atual != null) {
            System.out.println("Tocando: " + atual.musica.getNomeArquivo());
            Reprodutor.reproduzir("repositorio/" + atual.musica.getNomeArquivo());
            System.out.println("Pressione Enter para próxima música...");
            scanner.nextLine();
            atual = atual.proximo;
        }
    }

    public String getNome() {
        return nome;
    }
}
