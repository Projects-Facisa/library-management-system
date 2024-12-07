import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Criar livros com todas as letras do alfabeto
        List<Books> books = Arrays.asList(
                new Books("Zoology", "Silas", 2000),         // Z
                new Books("Astronomy", "Silas", 1995),      // A
                new Books("Botany", "Silas", 1987),        // B
                new Books("Chemistry", "Silas", 2005),     // C
                new Books("Drama", "Diana", 1990),         // D
                new Books("Economics", "Ethan", 2003),     // E
                new Books("Fiction", "Fiona", 2011),       // F
                new Books("Geography", "George", 1993),    // G
                new Books("History", "Harry", 1999),       // H
                new Books("Information Technology", "Iris", 2018), // I
                new Books("Journalism", "Jack", 2001),     // J
                new Books("Kinetics", "Kara", 2007),       // K
                new Books("Linguistics", "Marclod", 1996),    // L
                new Books("Mathematics", "Mike", 2010),    // M
                new Books("Neurology", "Nina", 2020),      // N
                new Books("Oceanography", "Oliver", 1998), // O
                new Books("Philosophy", "Yuri", 2004),    // P
                new Books("Quantum Mechanics", "Yuri", 2015), // Q
                new Books("Robotics", "Rachel", 2017),     // R
                new Books("Sociology", "Sophia", 1991),    // S
                new Books("Theology", "Yuri", 2002),     // T
                new Books("Urban Studies", "Uma", 2013),   // U
                new Books("Virology", "Neto", 1988),     // V
                new Books("World History", "Neto", 1994), // W
                new Books("Xenobiology", "Caio", 2006),  // X
                new Books("Youth Studies", "Marclod", 2021)   // Y
        );

        // Embaralhar a lista para garantir ordem aleatória
        Collections.shuffle(books);

        // Inserir os livros na árvore AVL
        for (Books book : books) {
            tree.insert(book);
        }


        int opcao;

        do {
            String menu = """
                --- Gerenciamento de Livros ---
                1. Adicionar Livro
                2. Listar Livros (in-order)
                3. Listar Autores e Qtnd de Livros
                4. Recomendar Livros Por Autor
                5. Pesquisar Raiz atual da Arvore
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
                    if (booksList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, booksList);
                    }
                    break;

                case 3: // Listar Autores e quantidade de livros
                    String listBooksByAuthor = tree.listAuthorsWithBookCount();
                    JOptionPane.showMessageDialog(null, listBooksByAuthor);
                    break;

                case 4: // Recomendar livro por Autor
                    String authorQuery = JOptionPane.showInputDialog("Digite o Autor do Livro:");
                    String booksByAuthor = tree.searchByAuthor(authorQuery);
                    if (booksByAuthor.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro encontrado para o autor: " + authorQuery);
                    } else {
                        JOptionPane.showMessageDialog(null, booksByAuthor, "Livros do autor " + authorQuery, JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 5: // Pesquisar Raiz atual da Arvore
                    String root = tree.getRoot();
                    JOptionPane.showMessageDialog(null, "Raiz Atual: " + root);
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
