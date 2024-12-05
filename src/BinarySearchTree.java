public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Inserir um livro na árvore
    public void insert(Books book) {
        root = insertRec(root, book);
    }

    private TreeNode insertRec(TreeNode node, Books book) {
        if (node == null) {
            return new TreeNode(book);
        }

        if (book.getTitle().compareToIgnoreCase(node.book.getTitle()) < 0) {
            node.left = insertRec(node.left, book);
        } else if (book.getTitle().compareToIgnoreCase(node.book.getTitle()) > 0) {
            node.right = insertRec(node.right, book);
        }

        return node;
    }

    // Listar livros
    public String listBooks() {
        StringBuilder bookList = new StringBuilder();
        listBooksRec(root, bookList);
        return bookList.length() == 0 ? "Nenhum livro cadastrado." : bookList.toString();
    }

    private void listBooksRec(TreeNode node, StringBuilder bookList) {
        if (node != null) {
            listBooksRec(node.left, bookList);
            bookList.append("Título: ").append(node.book.getTitle())
                    .append("  Autor: ").append(node.book.getAuthor())
                    .append("  Ano Pub.: ").append(node.book.getYearOfPublication()).append("\n");
            listBooksRec(node.right, bookList);
        }
    }

    // Buscar por título
    public Books searchByTitle(String title) {
        return searchByTitleRec(root, title);
    }

    private Books searchByTitleRec(TreeNode node, String title) {
        if (node == null || node.book.getTitle().equalsIgnoreCase(title)) {
            return node != null ? node.book : null;
        }

        if (title.compareToIgnoreCase(node.book.getTitle()) < 0) {
            return searchByTitleRec(node.left, title);
        }

        return searchByTitleRec(node.right, title);
    }

    // Buscar por autor
    public String searchByAuthor(String author) {
        StringBuilder booksByAuthor = new StringBuilder();
        searchByAuthorRec(root, author.toLowerCase(), booksByAuthor);
        return booksByAuthor.length() == 0 ? "Nenhum livro encontrado para o autor: " + author : booksByAuthor.toString();
    }

    private void searchByAuthorRec(TreeNode node, String author, StringBuilder booksByAuthor) {
        if (node != null) {

            searchByAuthorRec(node.left, author, booksByAuthor);

            if (node.book.getAuthor().toLowerCase().contains(author)) {
                booksByAuthor.append("Título: ").append(node.book.getTitle()).append("\n");
            }

            searchByAuthorRec(node.right, author, booksByAuthor);
        }
    }
}
