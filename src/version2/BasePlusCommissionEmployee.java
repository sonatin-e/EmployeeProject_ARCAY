package version2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double computeSalary() {
        double commissionRate = 0.0;

        if (this.totalSale < 50000.0) {
            commissionRate = 0.05;
        } else if (this.totalSale < 100000.0) {
            commissionRate = 0.10;
        } else if (this.totalSale < 500000.0) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return this.baseSalary + (this.totalSale * commissionRate);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Sales: " + this.totalSale);
        System.out.println("Base Salary: " + this.baseSalary);
    }

    @Override
    public String toString() {
        double commissionRate = 0.0;

        if (this.totalSale < 50000.0) {
            commissionRate = 0.05;
        } else if (this.totalSale < 100000.0) {
            commissionRate = 0.10;
        } else if (this.totalSale < 500000.0) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return "Employee ID: " + this.empID + "\n"
                + "Employee Name: " + this.empName + "\n"
                + "Base Salary: " + this.baseSalary + "\n"
                + "Total Sales: " + this.totalSale + "\n"
                + "Commission Rate Applied: " + (commissionRate * 100) + "%\n"
                + "Total Computed Salary: " + this.computeSalary();
    }
}
