package br.com.mangarosa.mangarosa.collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MangaController {
    private List<ListaReproducao> listas = new ArrayList<>();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMangaSound:");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarMusica(scanner);
                case 2 -> criarLista(scanner);
                case 3 -> editarLista(scanner);
                case 4 -> executarLista(scanner);
                case 5 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarMusica(Scanner scanner) {
        System.out.println("Digite o caminho do arquivo .wav:");
        String caminho = scanner.nextLine();
        File origem = new File(caminho);
        if (!origem.exists()) {
            System.out.println("Arquivo não encontrado.");
            return;
        }
        File destino = new File("repositorio/" + origem.getName());
        try {
            Files.copy(origem.toPath(), destino.toPath());
            System.out.println("Música adicionada ao repositório.");
        } catch (IOException e) {
            System.out.println("Erro ao copiar música: " + e.getMessage());
        }
    }

    private void criarLista(Scanner scanner) {
        System.out.println("Nome da lista:");
        String nome = scanner.nextLine();
        listas.add(new ListaReproducao(nome));
        System.out.println("Lista criada.");
    }

    private void editarLista(Scanner scanner) {
        if (listas.isEmpty()) {
            System.out.println("Nenhuma lista disponível.");
            return;
        }
        for (int i = 0; i < listas.size(); i++) {
            System.out.println(i + " - " + listas.get(i).getNome());
        }
        System.out.println("Escolha a lista:");
        int index = scanner.nextInt();
        scanner.nextLine();
        ListaReproducao lista = listas.get(index);

        System.out.println("Digite o nome da música no repositório:");
        String nomeMusica = scanner.nextLine();
        lista.adicionar(new Musica(nomeMusica));
    }

    private void executarLista(Scanner scanner) {
        if (listas.isEmpty()) {
            System.out.println("Nenhuma lista disponível.");
            return;
        }
        for (int i = 0; i < listas.size(); i++) {
            System.out.println(i + " - " + listas.get(i).getNome());
        }
        System.out.println("Escolha a lista:");
        int index = scanner.nextInt();
        scanner.nextLine();
        listas.get(index).tocar();
    }
}
