package version5;

public class Main {

    private static final String LINE = "=".repeat(70);

    public static void main(String[] args) {

        System.out.println(LINE);
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println(LINE);

        EmployeeRoster roster = new EmployeeRoster();

        Employee[] newHires = {
                new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"),
                        new MyDate(15, 9, 1995), new MyDate(1, 3, 2020),
                        40f, 237.50),
                new PieceWorkerEmployee(201, new Name("Bob", "Carl", "Jones", "Jr."),
                        new MyDate(3, 4, 1990), new MyDate(10, 6, 2019),
                        90, 45.00),
                new CommissionEmployee(301, new Name("Maria", "Luz", "Reyes"),
                        new MyDate(22, 9, 1988), new MyDate(5, 1, 2018),
                        100000),
                new BasePlusCommissionEmployee(401, new Name("Kevin", "Santos", "Tan"),
                        new MyDate(8, 12, 1992), new MyDate(20, 8, 2021),
                        100000, 17000)
        };

        String[] labels = {
                "Hourly", "Piece Worker", "Commission", "Base Plus Commission"
        };

        for (int i = 0; i < newHires.length; i++) {
            roster.addEmployee(newHires[i]);
            System.out.println("Enrolled: " + newHires[i].getEmpName()
                    + " (" + labels[i] + ")");
        }

        System.out.println("Total Roster Size: "
                + roster.countEmployees() + " employees");

        System.out.println();
        System.out.println(LINE);
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println(LINE);

        roster.displayPayroll(9);

        System.out.println();
        System.out.println(LINE);
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println(LINE);

        System.out.print("Removing Employee ID 201... ");
        Employee removed = roster.removeEmployee(201);
        System.out.println(removed != null ? "Successfully removed." : "Not found.");
        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println(LINE);
    }
}