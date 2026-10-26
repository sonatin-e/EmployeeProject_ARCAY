package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {

    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException(
                    "Initial capacity must be greater than 0."
            );
        }

        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }

        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }

        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }

        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);

            System.out.printf(
                    "ID: %d | Name: %-25s | Payout: ₱%,.2f",
                    emp.getEmpID(),
                    emp.getEmpName(),
                    salary
            );

            if (emp.getBirthDate().getMonth() == currentMonth) {
                System.out.print(" (Birthday Bonus Applied)");
            }

            System.out.println();
        }
    }

    public int countHE() {
        int total = 0;

        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countPWE() {
        int total = 0;

        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countCE() {
        int total = 0;

        for (Employee emp : empList) {
            if (emp.getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    public int countBPCE() {
        int total = 0;

        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    public void displayHE() {
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) {
                ((HourlyEmployee) emp).displayHourlyEmployee();
                System.out.println();
            }
        }
    }

    public void displayPWE() {
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) emp).displayPieceWorkerEmployee();
                System.out.println();
            }
        }
    }

    public void displayCE() {
        for (Employee emp : empList) {
            if (emp.getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) emp).displayCommissionEmployee();
                System.out.println();
            }
        }
    }

    public void displayBPCE() {
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) emp).displayBasePlusCommissionEmployee();
                System.out.println();
            }
        }
    }

    public void displayAllEmployees() {
        int n = 1;

        for (Employee emp : empList) {
            System.out.println(n++ + ". " + emp);
        }
    }
}