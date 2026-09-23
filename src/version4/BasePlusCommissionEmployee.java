package version4;

import java.util.Objects;

public class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale,
            double baseSalary) {

        super(
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale
        );

        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException(
                    "Base salary cannot be negative."
            );
        }

        this.baseSalary = baseSalary;
    }

    public double computeSalary(int currentMonth) {
        double salary =
                baseSalary
                        + getTotalSale() * getCommissionRate();

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        displayEmployee();

        System.out.printf(
                "Total Sales: ₱%.2f%n",
                getTotalSale()
        );

        System.out.printf(
                "Commission Rate: %.0f%%%n",
                getCommissionRate() * 100
        );

        System.out.printf(
                "Base Salary: ₱%.2f%n",
                baseSalary
        );
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                getEmpID(),
                getEmpName(),
                getBirthDate(),
                getDateHired()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return Double.compare(
                baseSalary,
                other.baseSalary
        ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                baseSalary
        );
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}