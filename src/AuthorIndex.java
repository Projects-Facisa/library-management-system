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


    // Obter autores com a quantidade de livros registrados
    public Map<String, Integer> getAuthorsWithBookCount() {
        Map<String, Integer> authorBookCount = new HashMap<>();
        for (Map.Entry<String, List<Books>> entry : authorMap.entrySet()) {
            authorBookCount.put(entry.getKey(), entry.getValue().size());
        }
        return authorBookCount;
    }
}
