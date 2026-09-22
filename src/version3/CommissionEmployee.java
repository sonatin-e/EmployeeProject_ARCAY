package version3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class CommissionEmployee extends Employee{

    private int empID;
    private String empName;
    private double totalSale;
    private Mydate empBirthDate;
    private Mydate empDateHired;

    // Constructors
    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
        this.empBirthDate = null;
        this.empDateHired = null;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.empBirthDate = null;
        this.empDateHired = null;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.empBirthDate = null;
        this.empDateHired = null;
    }

    public CommissionEmployee(int empID, String empName, double totalSale, Mydate empBirthDate, Mydate empDateHired) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
    }

    // Getters and Setters
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
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

    // Core Behavioral Methods
    public double computeSalary() {
        double totalSale = this.totalSale;
        double commissionRate = 0.0;

        if (totalSale < 50000.0) {
            commissionRate = 0.05;
        } else if (totalSale < 100000.0) {
            commissionRate = 0.10;
        } else if (totalSale < 500000.0) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        double birthdayBonus = 0.0;
        if (this.empBirthDate != null && this.empBirthDate.getMonth() == java.time.LocalDate.now().getMonthValue()) {
            birthdayBonus = 5000.0;
        }

        return (totalSale * commissionRate) + birthdayBonus;
    }


    public void displayCommissionEmployee() {
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Sales: " + this.totalSale);
        System.out.println("Birth Date: " + (this.empBirthDate != null ? this.empBirthDate : "N/A"));
        System.out.println("Date Hired: " + (this.empDateHired != null ? this.empDateHired : "N/A"));
    }

    @Override
    public String toString() {
        return "Employee ID: " + this.empID + "\n"
                + "Employee Name: " + this.empName + "\n"
                + "Total Sales: " + this.totalSale + "\n"
                + "Birth Date: " + (this.empBirthDate != null ? this.empBirthDate : "N/A") + "\n"
                + "Date Hired: " + (this.empDateHired != null ? this.empDateHired : "N/A") + "\n"
                + "Total Salary (Commission): " + this.computeSalary();
    }
}
