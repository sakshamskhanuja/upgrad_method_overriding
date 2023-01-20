public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(111,1000);
        BankAccount account2 = new BankAccount(222,2000);
        BankAccount account3 = new BankAccount(333,3000);

        Student s1 = new Student("Sujit", 2, account1);
        System.out.println(s1.getDetails());

        ResearchStudent s2 = new ResearchStudent("siddharth", 3, "Software Engineering",
                account2);
        System.out.println(s2.getDetails());

        PhDStudent s3 = new PhDStudent("hari", 1, "Software Engineering",
                "Automated Evaluation", account3);
        System.out.println(s3.getDetails());
    }
}

class Student {

    /**
     * Name of the student.
     */
    private final String name;

    /**
     * How many years the student has covered.
     */
    private int year;

    /**
     * Annual Fees.
     */
    private static final int annualFees = 10000;

    /**
     * Stores the information of bank account.
     */
    private BankAccount bankAccount;

    // Parameterized Constructor.
    public Student(String name, int year, BankAccount bankAccount) {
        this.name = name;
        this.year = year;
        this.bankAccount = bankAccount;
    }

    /**
     * @return Information about the Student, i.e., name and fees.
     */
    public String getDetails() {
        return "Name: " + name + "\nFees: " + computeFees();
    }

    /**
     * Computes the fees of the Student.
     */
    public int computeFees() {
        return Student.annualFees * year;
    }
}

class ResearchStudent extends Student {

    /**
     * Research area of the Student.
     */
    private String researchArea;

    // Parameterized Constructor.
    public ResearchStudent(String name, int year, String researchArea, BankAccount bankAccount) {
        super(name, year, bankAccount);
        this.researchArea = researchArea;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nResearch Area: " + researchArea;
    }
}

class PhDStudent extends ResearchStudent {

    private String thesisTitle;

    public PhDStudent(String name, int year, String researchArea, String thesisTitle, BankAccount bankAccount) {
        super(name, year, researchArea, bankAccount);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nThesis Title: " + thesisTitle;
    }
}

class BankAccount {

    private int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}