public class IssueRecord {

    private int bookId;
    private int memberId;
    private String issueDate;
    private String returnDate;
    private boolean returned;

    public IssueRecord(int bookId, int memberId, String issueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = "Not Returned";
        this.returned = false;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void returnBook(String returnDate) {
        this.returnDate = returnDate;
        this.returned = true;
    }

    public void displayIssueDetails() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Member ID: " + memberId);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Returned: " + returned);
    }
}