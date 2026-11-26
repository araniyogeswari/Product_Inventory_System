
public class Book {

    private int bookId;
    private String bookName;
    private String author;
    private String category;
    private int availableCopies;

    public Book(int bookId, String bookName, String author, String category, int availableCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies >= 0) {
            this.availableCopies = availableCopies;
        } else {
            System.out.println("Invalid Available Copies!");
        }
    }

    public void displayBookDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Available Copies: " + availableCopies);
    }
 class TestBook {
    public static void main(String[] args) {

        Book book = new Book(101, "Java Programming",
                "James Gosling", "Programming", 5);

        book.displayBookDetails();
    }
}
}
