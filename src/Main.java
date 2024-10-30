import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Livro");
                    break;
                case 2:
                    System.out.println("Listar Livros");
                    break;
                case 3:
                    System.out.println("Ordenar Livros");
                    break;
                case 4:
                    System.out.println("Buscar Livro");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
