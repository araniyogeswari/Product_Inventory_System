public class Student extends LibraryMember {

    private String department;
    private int year;

    public Student(int memberId, String memberName, String contactNumber,
                   String department, int year) {

        super(memberId, memberName, contactNumber);

        this.department = department;
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void displayMemberDetails() {

        System.out.println("Member Type: Student");
        System.out.println("Member ID: " + getMemberId());
        System.out.println("Member Name: " + getMemberName());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Department: " + department);
        System.out.println("Year: " + year);
    }
}