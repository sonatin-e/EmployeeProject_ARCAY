package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        max = 10;
        empList = new Employee[max];
        count = 0;
    }

    public EmployeeRoster(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException(
                    "Maximum capacity must be greater than 0."
            );
        }

        this.max = max;
        empList = new Employee[this.max];
        count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }

        empList[count] = emp;
        count++;

        return true;
    }

    public Employee removeEmployee(int empID) {

        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {

                Employee removed = empList[i];

                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }

                empList[count - 1] = null;
                count--;

                return removed;
            }
        }

        return null;
    }

    public Employee searchEmployee(int empID) {

        for (int i = 0; i < count; i++) {

            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

    public int countHE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countPWE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countCE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    public int countBPCE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof HourlyEmployee) {

                HourlyEmployee emp =
                        (HourlyEmployee) empList[i];

                emp.displayHourlyEmployee();
                System.out.println();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee emp =
                        (PieceWorkerEmployee) empList[i];

                emp.displayPieceWorkerEmployee();
                System.out.println();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {

            if (empList[i].getClass() == CommissionEmployee.class) {

                CommissionEmployee emp =
                        (CommissionEmployee) empList[i];

                emp.displayCommissionEmployee();
                System.out.println();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee emp =
                        (BasePlusCommissionEmployee) empList[i];

                emp.displayBasePlusCommissionEmployee();
                System.out.println();
            }
        }
    }

    public void displayAllEmployees() {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            System.out.printf(
                    "%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1,
                    emp.getEmpID(),
                    emp.getEmpName(),
                    emp.getClass().getSimpleName()
            );
        }
    }

    public void displayPayroll(int currentMonth) {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            double salary = 0;
            String type = "";

            if (emp instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee e =
                        (BasePlusCommissionEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Base Plus Commission";

            } else if (emp instanceof CommissionEmployee) {

                CommissionEmployee e =
                        (CommissionEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Commission";

            } else if (emp instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee e =
                        (PieceWorkerEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Piece Worker";

            } else if (emp instanceof HourlyEmployee) {

                HourlyEmployee e =
                        (HourlyEmployee) emp;

                salary = e.computeSalary(currentMonth);
                type = "Hourly";
            }

            boolean birthday =
                    emp.getBirthDate().getMonth() == currentMonth;

            System.out.printf(
                    "[%s] ID: %d | Name: %s | Salary: ₱%,.2f",
                    type,
                    emp.getEmpID(),
                    emp.getEmpName(),
                    salary
            );

            if (birthday) {
                System.out.print(" (Birthday Bonus Applied)");
            }

            System.out.println();
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }
}