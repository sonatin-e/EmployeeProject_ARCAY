package version3;

public class HourlyEmployee {

    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;
    private Mydate empBirthDate;
    private Mydate empDateHired;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
        this.empBirthDate = new Mydate();
        this.empDateHired = new Mydate();
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
        this.empBirthDate = new Mydate();
        this.empDateHired = new Mydate();
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.empBirthDate = new Mydate();
        this.empDateHired = new Mydate();
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour, Mydate empDateHired, Mydate empBirthDate) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
    }

    public int getEmpID() {

        return empID;
    }

    public void setEmpID(int empID) {

        this.empID = empID;
    }

    public String getEmpName() {

        return empName;
    }

    public void setEmpName(String empName) {

        this.empName = empName;
    }

    public float getTotalHoursWorked() {

        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {

        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {

        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {

        this.ratePerHour = ratePerHour;
    }

    public Mydate getEmpBirthDate() {

        return empBirthDate;
    }

    public void setEmpBirthDate(Mydate empBirthDate) {

        this.empBirthDate = empBirthDate;
    }

    public Mydate getEmpDateHired() {

        return empDateHired;
    }

    public void setEmpDateHired(Mydate empDateHired) {

        this.empDateHired = empDateHired;
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
