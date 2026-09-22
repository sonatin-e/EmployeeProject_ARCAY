package version3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee  extends CommissionEmployee{

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;
    private Mydate empBirthDate;
    private Mydate empDateHired;


    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
        this.empBirthDate = null;
        this.empDateHired = null;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
        this.empBirthDate = null;
        this.empDateHired = null;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
        this.empBirthDate = null;
        this.empDateHired = null;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary, Mydate empBirthDate, Mydate empDateHired) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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


    private double getCommissionRate() {
        if (this.totalSale < 50000.0) {
            return 0.05;
        } else if (this.totalSale < 100000.0) {
            return 0.10;
        } else if (this.totalSale < 500000.0) {
            return 0.15;
        } else {
            return 0.20;
        }
    }


    public double computeSalary() {

        double birthdayBonus = 0.0;
        if (this.empBirthDate != null && this.empBirthDate.getMonth() == java.time.LocalDate.now().getMonthValue()) {
            birthdayBonus = 5000.0;
        }

        return this.baseSalary + (this.totalSale * this.getCommissionRate()) + birthdayBonus;
    }


    public void displayBasePlusCommissionEmployee() {
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Sales: " + this.totalSale);
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Birth Date: " + (this.empBirthDate != null ? this.empBirthDate : "N/A"));
        System.out.println("Date Hired: " + (this.empDateHired != null ? this.empDateHired : "N/A"));
    }

    @Override
    public String toString() {
        return "Employee ID: " + this.empID + "\n"
                + "Employee Name: " + this.empName + "\n"
                + "Birth Date: " + (this.empBirthDate != null ? this.empBirthDate : "N/A") + "\n"
                + "Date Hired: " + (this.empDateHired != null ? this.empDateHired : "N/A") + "\n"
                + "Base Salary: " + this.baseSalary + "\n"
                + "Total Sales: " + this.totalSale + "\n"
                + "Commission Rate Applied: " + (this.getCommissionRate() * 100) + "%\n"
                + "Total Computed Salary: " + this.computeSalary();
    }
}
