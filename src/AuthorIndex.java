import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorIndex {
    private Map<String, List<Books>> authorMap;

    public AuthorIndex() {
        this.authorMap = new HashMap<>();
    }

    // Adicionar livro ao índice
    public void addBook(Books book) {
        String author = book.getAuthor().toLowerCase();
        authorMap.putIfAbsent(author, new ArrayList<>());
        authorMap.get(author).add(book);
    }

    // Obter livros por autor
    public List<Books> getBooksByAuthor(String author) {
        return authorMap.getOrDefault(author.toLowerCase(), new ArrayList<>());
    }

    // Listar todos os autores e seus livros
    public void listAllAuthors() {
        for (Map.Entry<String, List<Books>> entry : authorMap.entrySet()) {
            System.out.println("Autor: " + entry.getKey());
            for (Books book : entry.getValue()) {
                System.out.println("\tTítulo: " + book.getTitle());
            }
        }
    }
}
