import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Library implementation using Comparable and Comparator.
 */
public class BookLibrary implements Library {
    private List<Book> books;
    
    public BookLibrary() {
        this.books = new ArrayList<>();
    }
    
    @Override
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }
    
    @Override
    public boolean removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    @Override
    public int getBookCount() {
        return books.size();
    }
    
    @Override
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    @Override
    public void sortByTitle() {
        Collections.sort(books); // Uses Comparable
    }
    
    @Override
    public void sortByAuthor() {
        Collections.sort(books, new BookComparators.ByAuthor());
    }
    
    @Override
    public void sortByPrice() {
        Collections.sort(books, new BookComparators.ByPrice());
    }
    
    @Override
    public void sortByYear() {
        Collections.sort(books, new BookComparators.ByYear());
    }
}
