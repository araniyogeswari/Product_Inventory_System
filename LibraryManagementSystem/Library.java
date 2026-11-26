
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.time.LocalDate;

public class Library extends LibraryOperations {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<LibraryMember> members = new ArrayList<>();
    private HashMap<Integer, Book> bookMap = new HashMap<>();
    private LinkedHashMap<Integer, IssueRecord> issueRecords = new LinkedHashMap<>();
    private HashSet<Integer> issuedBookIds = new HashSet<>();

    @Override
    public void addBook(Book book) {

        if (bookMap.containsKey(book.getBookId())) {
            System.out.println("Book ID already exists!");
        } else {
            books.add(book);
            bookMap.put(book.getBookId(), book);
            System.out.println("Book added successfully!");
        }
    }

    @Override
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book book : books) {
            System.out.println("----------------------");
            book.displayBookDetails();
        }
    }

    public void searchBook(int bookId) {

        if (bookMap.containsKey(bookId)) {
            Book book = bookMap.get(bookId);
            System.out.println("Book Found!");
            book.displayBookDetails();
        } else {
            System.out.println("Book not found!");
        }
    }

    public void registerStudent(Student student) {

        for (LibraryMember member : members) {
            if (member.getMemberId() == student.getMemberId()) {
                System.out.println("Member ID already exists!");
                return;
            }
        }

        members.add(student);
        System.out.println("Student registered successfully!");
    }

    public void registerFaculty(Faculty faculty) {

        for (LibraryMember member : members) {
            if (member.getMemberId() == faculty.getMemberId()) {
                System.out.println("Member ID already exists!");
                return;
            }
        }

        members.add(faculty);
        System.out.println("Faculty registered successfully!");
    }

    public void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("No members registered!");
            return;
        }

        for (LibraryMember member : members) {
            System.out.println("----------------------");
            member.displayMemberDetails();
        }
    }

    public void searchMember(int memberId) {

        for (LibraryMember member : members) {
            if (member.getMemberId() == memberId) {
                System.out.println("Member Found!");
                member.displayMemberDetails();
                return;
            }
        }

        System.out.println("Member not found!");
    }

    @Override
    public void issueBook(int bookId, int memberId) {

        if (!bookMap.containsKey(bookId)) {
            System.out.println("Book not found!");
            return;
        }

        LibraryMember foundMember = null;

        for (LibraryMember member : members) {
            if (member.getMemberId() == memberId) {
                foundMember = member;
                break;
            }
        }

        if (foundMember == null) {
            System.out.println("Member not found!");
            return;
        }

        Book book = bookMap.get(bookId);

        if (book.getAvailableCopies() <= 0) {
            System.out.println("Book is not available!");
            return;
        }

        if (issuedBookIds.contains(bookId)) {
            System.out.println("This book is already issued!");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        int recordId = issueRecords.size() + 1;

        IssueRecord record = new IssueRecord(
                bookId, memberId, LocalDate.now().toString()
        );

        issueRecords.put(recordId, record);
        issuedBookIds.add(bookId);

        System.out.println("Book issued successfully!");
    }

    @Override
    public void returnBook(int bookId, int memberId) {

        for (IssueRecord record : issueRecords.values()) {

            if (record.getBookId() == bookId &&
                record.getMemberId() == memberId &&
                !record.isReturned()) {

                record.returnBook(LocalDate.now().toString());

                Book book = bookMap.get(bookId);

                book.setAvailableCopies(
                        book.getAvailableCopies() + 1
                );

                issuedBookIds.remove(bookId);

                System.out.println("Book returned successfully!");
                return;
            }
        }

        System.out.println("No active issue record found!");
    }

    public void displayIssuedBooks() {

        if (issueRecords.isEmpty()) {
            System.out.println("No issue records available!");
            return;
        }

        for (IssueRecord record : issueRecords.values()) {
            System.out.println("----------------------");
            record.displayIssueDetails();

            if (record.isReturned()) {
                System.out.println("Status: Returned");
            } else {
                System.out.println("Status: Currently Issued");
            }
        }
    }

    public void generateLibraryReport() {

        int totalBooks = books.size();
        int totalMembers = members.size();
        int totalIssued = 0;
        int totalReturned = 0;

        for (IssueRecord record : issueRecords.values()) {
            if (record.isReturned()) {
                totalReturned++;
            } else {
                totalIssued++;
            }
        }

        System.out.println("\n===== LIBRARY REPORT =====");
        System.out.println("Total Book Titles: " + totalBooks);
        System.out.println("Total Members: " + totalMembers);
        System.out.println("Currently Issued Books: " + totalIssued);
        System.out.println("Total Returned Books: " + totalReturned);
        System.out.println("Total Issue Records: " + issueRecords.size());
        System.out.println("==========================");
    }
}
