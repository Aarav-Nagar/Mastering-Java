/**
 * Day 13: Interfaces and Comparable
 * Demonstrates interface implementation, Comparable, Comparator, and sorting.
 * 
 * Key concepts:
 * - Book implements Comparable<Book> for natural ordering (by title)
 * - BookComparators provide multiple Comparator implementations
 * - BookLibrary implements custom Library interface
 * - Arrays.sort() and Collections.sort() use these interfaces
 */
public class InterfaceComparableApp {
    
    public static void main(String[] args) {
        System.out.println("=== Interfaces and Comparable Lab ===\n");
        
        // Test 1: Create a library and add books
        System.out.println("Test 1: Creating Library and Adding Books");
        System.out.println("----------------------------------------");
        
        BookLibrary library = new BookLibrary();
        
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 12.99, 180));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 14.99, 281));
        library.addBook(new Book("1984", "George Orwell", 1949, 13.99, 328));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813, 11.99, 279));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 13.99, 265));
        library.addBook(new Book("Brave New World", "Aldous Huxley", 1932, 14.99, 288));
        
        System.out.println("Added " + library.getBookCount() + " books to library");
        System.out.println();
        
        // Test 2: Display books in original order
        System.out.println("Test 2: Books in Original Order");
        System.out.println("----------------------------------------");
        library.displayAllBooks();
        System.out.println();
        
        // Test 3: Sort by title (Comparable - natural order)
        System.out.println("Test 3: Sort by Title (Natural Order - Comparable)");
        System.out.println("----------------------------------------");
        library.sortByTitle();
        library.displayAllBooks();
        System.out.println();
        
        // Test 4: Sort by author (Comparator)
        System.out.println("Test 4: Sort by Author (Comparator)");
        System.out.println("----------------------------------------");
        library.sortByAuthor();
        library.displayAllBooks();
        System.out.println();
        
        // Test 5: Sort by price ascending (Comparator)
        System.out.println("Test 5: Sort by Price Ascending (Comparator)");
        System.out.println("----------------------------------------");
        library.sortByPrice();
        library.displayAllBooks();
        System.out.println();
        
        // Test 6: Sort by year published (Comparator)
        System.out.println("Test 6: Sort by Year Published (Comparator)");
        System.out.println("----------------------------------------");
        library.sortByYear();
        library.displayAllBooks();
        System.out.println();
        
        // Test 7: Finding books
        System.out.println("Test 7: Finding Books (Interface Method)");
        System.out.println("----------------------------------------");
        Book found = library.findByTitle("1984");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Book not found");
        }
        System.out.println();
        
        // Test 8: Remove and count
        System.out.println("Test 8: Remove Book and Count");
        System.out.println("----------------------------------------");
        System.out.println("Books before removal: " + library.getBookCount());
        boolean removed = library.removeBook("The Great Gatsby");
        System.out.println("Removed 'The Great Gatsby': " + removed);
        System.out.println("Books after removal: " + library.getBookCount());
        System.out.println();
        
        // Test 9: Demonstrate Comparable vs Comparator
        System.out.println("Test 9: Comparable vs Comparator");
        System.out.println("----------------------------------------");
        System.out.println("Comparable: Book implements Comparable<Book>");
        System.out.println("  - Collections.sort(books) uses compareTo() method");
        System.out.println("  - Default/natural ordering (alphabetical by title)");
        System.out.println();
        System.out.println("Comparator: BookComparators.ByAuthor, ByPrice, etc.");
        System.out.println("  - Collections.sort(books, comparator) uses custom logic");
        System.out.println("  - Multiple sorting strategies without modifying Book class");
        System.out.println();
        
        // Test 10: Books sorted by title (final check)
        System.out.println("Test 10: Final Sort by Title");
        System.out.println("----------------------------------------");
        library.sortByTitle();
        library.displayAllBooks();
        System.out.println();
        
        System.out.println("=== Interfaces and Comparable Lab Complete ===");
    }
}
