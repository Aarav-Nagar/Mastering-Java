/**
 * Interface for library operations.
 */
public interface Library {
    
    /**
     * Add a book to the library.
     */
    void addBook(Book book);
    
    /**
     * Remove a book by title.
     */
    boolean removeBook(String title);
    
    /**
     * Find book by title.
     */
    Book findByTitle(String title);
    
    /**
     * Get total number of books.
     */
    int getBookCount();
    
    /**
     * Display all books.
     */
    void displayAllBooks();
    
    /**
     * Sort books by natural order (title).
     */
    void sortByTitle();
    
    /**
     * Sort books by custom criteria.
     */
    void sortByAuthor();
    
    void sortByPrice();
    
    void sortByYear();
}
