import java.util.Map;

public class AVLTree {
    private TreeNode root;
    private AuthorIndex authorIndex;

    public AVLTree() {
        this.root = null;
        this.authorIndex = new AuthorIndex();  // Instancia o índice de autores
    }

    // Inserir um livro na árvore e no índice de autores
    public void insert(Books book) {
        root = insertRec(root, book);
        authorIndex.addBook(book);  // Adiciona ao índice de autores
    }

    private TreeNode insertRec(TreeNode node, Books book) {
        // Passo 1: Realiza a inserção normal da árvore binária de busca
        if (node == null) {
            return new TreeNode(book);
        }

        int cmp = book.getTitle().compareToIgnoreCase(node.book.getTitle());

        if (cmp < 0) {
            node.left = insertRec(node.left, book);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, book);
        } else {
            return node; // Duplicatas não são permitidas
        }

        // Passo 2: Atualiza a altura do nó
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Passo 3: Calcula o fator de balanceamento
        int balance = getBalance(node);

        // Passo 4: Realiza as rotações necessárias (casos de desbalanceamento)
        if (balance > 1) {
            // Caso Left-Left ou Left-Right
            if (cmp < 0) {
                return rotateRight(node);  // Left-Left
            } else {
                node.left = rotateLeft(node.left); // Left-Right
                return rotateRight(node);
            }
        } else if (balance < -1) {
            // Caso Right-Right ou Right-Left
            if (cmp > 0) {
                return rotateLeft(node); // Right-Right
            } else {
                node.right = rotateRight(node.right); // Right-Left
                return rotateLeft(node);
            }
        }

        return node;
    }


    // Rotação à direita
    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // Rotação à esquerda
    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // Retorna a altura de um nó
    private int getHeight(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    // Retorna o fator de balanceamento de um nó
    private int getBalance(TreeNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Listar livros

    public String getRoot() {
        return root.book.getTitle();
    }

    public String listBooks() {
        StringBuilder bookList = new StringBuilder();
        listBooksRec(root, bookList);
        return bookList.length() == 0 ? "Nenhum livro cadastrado." : bookList.toString();
    }

    private void listBooksRec(TreeNode node, StringBuilder bookList) {
        if (node != null) {
            listBooksRec(node.left, bookList);
            bookList.append("Título: ").append(node.book.getTitle())
                    .append("  --  Autor: ").append(node.book.getAuthor())
                    .append("  --  Ano Pub.: ").append(node.book.getYearOfPublication()).append("\n");
            listBooksRec(node.right, bookList);
        }
    }

    // Buscar livros por autor
    public String searchByAuthor(String author) {
        return authorIndex.getBooksByAuthor(author).stream()
                .map(book -> "Título: " + book.getTitle() + "  --   Ano: " + book.getYearOfPublication())
                .reduce((book1, book2) -> book1 + "\n" + book2)
                .orElse("Nenhum livro encontrado para o autor: " + author);
    }


    // Listar autores com a quantidade de livros registrados
    public String listAuthorsWithBookCount() {
        Map<String, Integer> authorsWithCount = authorIndex.getAuthorsWithBookCount();
        if (authorsWithCount.isEmpty()) {
            return "Nenhum autor cadastrado.";
        }

        StringBuilder result = new StringBuilder("Autores e quantidade de livros cadastrados:\n");
        for (Map.Entry<String, Integer> entry : authorsWithCount.entrySet()) {
            result.append("Autor: ").append(entry.getKey())
                    .append(" = ").append(entry.getValue())
                    .append("\n");
        }
        return result.toString();
    }
}