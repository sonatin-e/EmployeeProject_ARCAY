package version3;

public class HourlyEmployee extends Employee{


    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee(float totalHoursWorked, double ratePerHour) {
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public HourlyEmployee(int empID, Name empName, Mydate empBirthDate, Mydate empDateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, empBirthDate, empDateHired);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double computeSalary(Mydate today) {
        double OVERTIME_MULTIPLIER = 1.5;
        double regularPay = 0.0;
        double overtimePay = 0.0;

        if (this.totalHoursWorked <= 40) {
            regularPay = this.totalHoursWorked * this.ratePerHour;
        } else {
            double overtimeHours = this.totalHoursWorked - 40;
            regularPay = 40 * this.ratePerHour;
            overtimePay = overtimeHours * (this.ratePerHour * OVERTIME_MULTIPLIER);
        }

        double totalSalary = regularPay + overtimePay;

        if (this.empBirthDate != null && today != null) {
            if (this.empBirthDate.getMonth() == today.getMonth() && this.empBirthDate.getDate() == today.getDate()) {
                totalSalary += 5000.0;
            }
        }

        return totalSalary;
    }

    public void displayHourlyEmployee() {
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Hours Worked: " + this.totalHoursWorked);
        System.out.println("Rate Per Hour: " + this.ratePerHour);
        System.out.println("Date Hired: " + (this.empDateHired != null ? this.empDateHired.displayDate() : "N/A"));
        System.out.println("Birth Date: " + (this.empBirthDate != null ? this.empBirthDate.displayDate() : "N/A"));
    }

    @Override
    public String toString() {
        return "Employee ID: " + this.empID + "\n"
                + "Employee Name: " + this.empName + "\n"
                + "Total Hours Worked: " + this.totalHoursWorked + "\n"
                + "Rate Per Hour: " + this.ratePerHour + "\n"
                + "Date Hired: " + (this.empDateHired != null ? this.empDateHired.displayDate() : "N/A") + "\n"
                + "Birth Date: " + (this.empBirthDate != null ? this.empBirthDate.displayDate() : "N/A");
    }
}
