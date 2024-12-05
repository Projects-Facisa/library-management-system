import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int opcao;

        do {
            String menu = """
                --- Gerenciamento de Livros ---
                1. Adicionar Livro
                2. Listar Livros
                3. Pesquisar Livro
                0. Sair
                Escolha uma opção:
                """;

            String input = JOptionPane.showInputDialog(menu);
            if (input == null || input.isEmpty()) {
                break;
            }

            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1: // Adicionar livro
                    String title = JOptionPane.showInputDialog("Digite o título do livro:");
                    String author = JOptionPane.showInputDialog("Digite o autor do livro:");
                    String yearString = JOptionPane.showInputDialog("Digite o ano de publicação do livro:");
                    int yearOfPublication = Integer.parseInt(yearString);

                    tree.insert(new Books(title, author, yearOfPublication));
                    JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                    break;

                case 2: // Listar livros
                    String booksList = tree.listBooks();
                    JOptionPane.showMessageDialog(null, booksList);
                    break;

                case 3: // Recomendar livros
                    String searchOption = JOptionPane.showInputDialog("Recomendar livro por:\n1. Título\n2. Autor");
                    if (searchOption.equals("1")) {
                        String titleQuery = JOptionPane.showInputDialog("Digite o Título do Livro:");
                        Books foundBook = tree.searchByTitle(titleQuery);
                        if (foundBook != null) {
                            JOptionPane.showMessageDialog(null, "Livro encontrado:\n" +
                                    "Título: " + foundBook.getTitle() + "\n" +
                                    "Autor: " + foundBook.getAuthor() + "\n" +
                                    "Ano: " + foundBook.getYearOfPublication());
                        } else {
                            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
                        }
                    } else if (searchOption.equals("2")) {
                        String authorQuery = JOptionPane.showInputDialog("Digite o Autor do Livro:");
                        String booksByAuthor = tree.searchByAuthor(authorQuery);
                        JOptionPane.showMessageDialog(null, booksByAuthor, "Livros do autor " + authorQuery,JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                    break;
                

                case 0: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}
