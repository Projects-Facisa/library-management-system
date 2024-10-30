public class BookManager {
    private Books[] books;
    private int count;

    public BookManager(int maxBooks) {
        this.books = new Books[maxBooks];
        this.count = 0;
    }

    public void addBook(Books book) { // Adicionar livro
        if (count >= books.length) {
            resizeArray();
        }
        books[count++] = book;
    }

    public void listBooks() { // Listar livros
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].getTitle() + " - " + books[i].getAuthor() + " - " + books[i].getYearOfPublication());
        }
    }

    private void resizeArray() { // Redimensionar o array de livros
        Books[] newBooks = new Books[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        books = newBooks;
    }
}
