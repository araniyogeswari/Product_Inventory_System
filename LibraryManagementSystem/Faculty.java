public class Faculty extends LibraryMember {
    private String designation;
    private String department;
    public Faculty(int memberId, String memberName, String contactNumber,
                    String designation, String department) {
        super(memberId, memberName, contactNumber);
        this.designation = designation;
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }
    public String getDepartment() {
        return department;
    }
    @Override
    public void displayMemberDetails() {
        System.out.println("Member Type: Faculty");
        System.out.println("Member ID: " + getMemberId());
        System.out.println("Member Name: " + getMemberName());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + department);
    }
}