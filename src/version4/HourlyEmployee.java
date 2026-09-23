package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    public HourlyEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            float totalHoursWorked,
            double ratePerHour) {

        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            throw new IllegalArgumentException("Hours cannot be negative.");
        }

        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            throw new IllegalArgumentException("Rate cannot be negative.");
        }

        this.ratePerHour = ratePerHour;
    }

    public double computeSalary(int currentMonth) {
        double regularHours = Math.min(totalHoursWorked, 40);
        double overtimeHours = Math.max(totalHoursWorked - 40, 0);

        double salary =
                regularHours * ratePerHour
                        + overtimeHours * ratePerHour * 1.5;

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayHourlyEmployee() {
        displayEmployee();

        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.printf("Rate Per Hour: ₱%.2f%n", ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
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

        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee other = (HourlyEmployee) obj;

        return Float.compare(
                totalHoursWorked,
                other.totalHoursWorked
        ) == 0
                && Double.compare(
                ratePerHour,
                other.ratePerHour
        ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                totalHoursWorked,
                ratePerHour
        );
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}