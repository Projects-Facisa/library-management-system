import java.util.Arrays;

public class List {
    private Books[] books;
    private int count;

    public List(int maxBooks) {
        this.books = new Books[maxBooks];
        this.count = 0;
    }

    public void addBook(Books book) { 
        if (count >= books.length) {
            resizeArray();
        }
        books[count++] = book;
    }

    public void listBooks() { 
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].getTitle() + " - " + books[i].getAuthor() + " - " + books[i].getYearOfPublication());
        }
    }

    private void resizeArray() { 
        books = Arrays.copyOf(books, books.length * 2);
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
}
