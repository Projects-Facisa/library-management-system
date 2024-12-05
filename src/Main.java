import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        SequentialList list = new SequentialList(2); // Capacidade inicial de 2 livros
        int opcao;

        do {
            // Exibir menu de opções
            String menu = """
                --- Gerenciamento de Livros ---
                1. Adicionar Livro
                2. Listar Livros
                3. Ordenar Livros
                4. Pesquisar Livro
                0. Sair
                Escolha uma opção:
                """;

            String input = JOptionPane.showInputDialog(menu);

            // Verificar se o input é nulo (caso o usuário feche a janela) ou vazio
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

                    list.addBook(new Books(title, author, yearOfPublication));
                    JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                    break;

                case 2: // Listar livros
                    JOptionPane.showMessageDialog(null, "Aqui Aparecerao os Livros");
                    break;

                case 3: // Ordenar livros
                    String sortOption = JOptionPane.showInputDialog("Escolha o critério de ordenação:\n1 - Ordenar por Título\n2 - Ordenar por Autor");

                    if (sortOption.equals("1")) {
                        list.bubbleSortByTitle();
                        JOptionPane.showMessageDialog(null, "Livros ordenados por título:\n");
                    } else if (sortOption.equals("2")) {
                        list.bubbleSortByAuthor();
                        JOptionPane.showMessageDialog(null, "Livros ordenados por autor:\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção de ordenação inválida.");
                    }
                    break;

                case 4: // Pesquisar livros
                    boolean voltarMenuPrincipal = false;

                    do {
                        String subMenu = """
                            Buscar Livro por:
                            1. Título
                            2. Autor
                            0. Voltar
                            """;

                        String opcaoBuscar = JOptionPane.showInputDialog(subMenu);

                        if (opcaoBuscar == null || opcaoBuscar.isEmpty()) {
                            break;
                        }

                        switch (opcaoBuscar) {
                            case "1":
                                String titleQuery = JOptionPane.showInputDialog("Digite o Título do Livro:");
                                voltarMenuPrincipal = list.searchBookByTitle(titleQuery);
                                break;
                            case "2":
                                String authorQuery = JOptionPane.showInputDialog("Digite o nome do Autor:");
                                voltarMenuPrincipal = list.searchBookByAuthor(authorQuery);
                                break;
                            case "0":
                                voltarMenuPrincipal = true;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                        }
                    } while (!voltarMenuPrincipal);
                    break;

                case 0: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }
}
