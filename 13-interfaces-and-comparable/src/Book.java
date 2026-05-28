/**
 * Comparable interface implementation for Book sorting.
 * Books are compared by title alphabetically.
 */
public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private double price;
    private int pages;
    
    public Book(String title, String author, int year, double price, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.pages = pages;
    }
    
    /**
     * Comparable: default comparison by title.
     */
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
    
    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', year=%d, price=$%.2f, pages=%d}",
            title, author, year, price, pages);
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getPages() {
        return pages;
    }
}
