import java.util.Arrays;

public class SequentialList {
    private Books[] books;
    private int count;

    public SequentialList(int maxBooks) {
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

    public boolean searchBookByTitle(String title) { // Buscar por Título
        boolean found = false;
        String searchTerm = title.toLowerCase();
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().toLowerCase().contains(searchTerm)) {
                System.out.println(books[i].getTitle() + " - " + books[i].getAuthor() + " - " + books[i].getYearOfPublication());
                found = true;
            }
        }
        if (found) {
            return true;
        }else {
            System.out.println("Nenhum livro encontrado com o título: " + title);
        }
        return false;
        // Volta ao menu após a busca completa
    }

    public boolean searchBookByAuthor(String author) { // Buscar por Autor
        boolean found = false;
        String searchTerm = author.toLowerCase();
        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().toLowerCase().contains(searchTerm)) {
                System.out.println(books[i].getTitle() + " - " + books[i].getAuthor() + " - " + books[i].getYearOfPublication());
                found = true;
            }
        }
        if (found) {
            return true;
        }else {
            System.out.println("Nenhum livro encontrado com o autor: " + author);
        }
        return false;
        // Volta ao menu após a busca completa
    }



    private void resizeArray() { // Redimensionar o array de livros
        books = Arrays.copyOf(books, books.length * 2);
    }
}
