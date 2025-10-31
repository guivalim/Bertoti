package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.conectar();
        biblioteca.criarTabela();

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Buscar livro por título");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    Livro novoLivro = new Livro(titulo, autor, isbn);
                    biblioteca.addLivro(novoLivro);
                    System.out.println("✅ Livro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o título do livro: ");
                    String tituloBusca = sc.nextLine();

                    Livro encontrado = biblioteca.buscarLivroTitulo(tituloBusca);
                    if (encontrado != null) {
                        System.out.println("\n📖 Livro encontrado!");
                        System.out.println("Título: " + encontrado.getTitulo());
                        System.out.println("Autor: " + encontrado.getAutor());
                        System.out.println("ISBN: " + encontrado.getIsbn());
                    } else {
                        System.out.println("⚠️ Nenhum livro encontrado com esse título.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
