public class TestIssueRecord {
    public static void main(String[] args) {

        IssueRecord record = new IssueRecord(
                101, 201, "26-11-2026"
        );

        record.displayIssueDetails();

        System.out.println("----------------");

        record.returnBook("30-11-2026");

        record.displayIssueDetails();
    }
}