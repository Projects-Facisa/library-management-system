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

    public void bubbleSortByTitle() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (books[j].getTitle().compareTo(books[j + 1].getTitle()) > 0) {
                    Books temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSortByAuthor() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (books[j].getAuthor().compareTo(books[j + 1].getAuthor()) > 0) {
                    Books temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    private void resizeArray() { // Redimensionar o array de livros
        books = Arrays.copyOf(books, books.length * 2);
    }
}
