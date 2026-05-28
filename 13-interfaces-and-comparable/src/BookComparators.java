import java.util.Comparator;

/**
 * Custom comparators for sorting books by different criteria.
 */
public class BookComparators {
    
    /**
     * Comparator for sorting by author name.
     */
    public static class ByAuthor implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareTo(b2.getAuthor());
        }
    }
    
    /**
     * Comparator for sorting by price (ascending).
     */
    public static class ByPrice implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            return Double.compare(b1.getPrice(), b2.getPrice());
        }
    }
    
    /**
     * Comparator for sorting by price descending.
     */
    public static class ByPriceDescending implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            return Double.compare(b2.getPrice(), b1.getPrice());
        }
    }
    
    /**
     * Comparator for sorting by year published.
     */
    public static class ByYear implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.getYear(), b2.getYear());
        }
    }
    
    /**
     * Comparator for sorting by number of pages.
     */
    public static class ByPages implements Comparator<Book> {
        @Override
        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.getPages(), b2.getPages());
        }
    }
}
