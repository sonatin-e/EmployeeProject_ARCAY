package version4;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        totalSale = 0;
    }

    public CommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale) {

        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            throw new IllegalArgumentException(
                    "Total sale cannot be negative."
            );
        }

        this.totalSale = totalSale;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary(int currentMonth) {
        double salary =
                totalSale * getCommissionRate();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        displayEmployee();

        System.out.printf(
                "Total Sales: ₱%.2f%n",
                totalSale
        );

        System.out.printf(
                "Commission Rate: %.0f%%%n",
                getCommissionRate() * 100
        );
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s]", getEmpID(), getEmpName(), getBirthDate(), getDateHired()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee other =
                (CommissionEmployee) obj;

        return Double.compare(
                totalSale,
                other.totalSale
        ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                totalSale
        );
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}