import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SequentialList list = new SequentialList(2); // Capacidade inicial de 2 livros
        int opcao;

        do {
            System.out.println("\n--- Gerenciamento de Livros ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar Livros");
            System.out.println("4. Buscar Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1: // Adicionar livro
                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String author = scanner.nextLine();
                    System.out.print("Digite o ano de publicação do livro: ");
                    int yearOfPublication = scanner.nextInt();
                    list.addBook(new Books(title, author, yearOfPublication));
                    System.out.println("Livro adicionado com sucesso!");

                    break;
                case 2: // Listar livros
                    System.out.println("Listar Livros:");
                    list.listBooks();
                    break;
                case 3: // Ordenar livros
                    System.out.println("Escolha o critério de ordenação:");
                    System.out.println("1 - Ordenar por Título");
                    System.out.println("2 - Ordenar por Autor");
                    int sortOption = scanner.nextInt();

                    if (sortOption == 1) {
                        list.bubbleSortByTitle(); 
                        System.out.println("Livros ordenados por título:");
                        list.listBooks(); 
                    } else if (sortOption == 2) {
                        list.bubbleSortByAuthor(); 
                        System.out.println("Livros ordenados por autor:");
                        list.listBooks(); 
                    } else {
                        System.out.println("Opção de ordenação inválida.");
                    }
                    break;
                case 4:

                    boolean voltarMenuPrincipal = false;

                    do {
                        System.out.println("Buscar Livro por:");
                        System.out.println("1. Título");
                        System.out.println("2. Autor");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoBuscar = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer do scanner

                        switch (opcaoBuscar) {
                            case 1:
                                System.out.print("Digite o Título do Livro: ");
                                String titleQuery = scanner.nextLine();
                                voltarMenuPrincipal = list.searchBookByTitle(titleQuery);
                                break;
                            case 2:
                                System.out.print("Digite o nome do Autor: ");
                                String authorQuery = scanner.nextLine();
                                voltarMenuPrincipal = list.searchBookByAuthor(authorQuery);
                                break;
                            case 0:
                                System.out.println("Voltando...");
                                voltarMenuPrincipal = true; // Sinaliza para sair do loop de busca
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                        }
                    } while (!voltarMenuPrincipal); // Sai do loop quando `voltarMenuPrincipal` for true
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
