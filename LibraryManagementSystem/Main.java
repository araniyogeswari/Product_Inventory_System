import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Register Student");
            System.out.println("5. Register Faculty");
            System.out.println("6. Display All Members");
            System.out.println("7. Search Member");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Issued Books");
            System.out.println("11. Generate Library Report");
            System.out.println("12. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();

                    Book book = new Book(
                            bookId, bookName, author, category, copies
                    );

                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    library.searchBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String studentContact = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();

                    Student student = new Student(
                            studentId, studentName, studentContact,
                            department, year
                    );

                    library.registerStudent(student);
                    break;

                case 5:
                    System.out.print("Enter Member ID: ");
                    int facultyId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Faculty Name: ");
                    String facultyName = sc.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String facultyContact = sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String facultyDepartment = sc.nextLine();

                    Faculty faculty = new Faculty(
                            facultyId, facultyName, facultyContact,
                            designation, facultyDepartment
                    );

                    library.registerFaculty(faculty);
                    break;

                case 6:
                    library.displayMembers();
                    break;

                case 7:
                    System.out.print("Enter Member ID: ");
                    library.searchMember(sc.nextInt());
                    break;

                case 8:
                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int issueMemberId = sc.nextInt();

                    library.issueBook(issueBookId, issueMemberId);
                    break;

                case 9:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int returnMemberId = sc.nextInt();

                    library.returnBook(returnBookId, returnMemberId);
                    break;

                case 10:
                    library.displayIssuedBooks();
                    break;

                case 11:
                    library.generateLibraryReport();
                    break;

                case 12:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 12);

        sc.close();
    }
}