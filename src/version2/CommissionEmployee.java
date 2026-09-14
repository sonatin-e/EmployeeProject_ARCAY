package version2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class CommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;

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

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
    }

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

        return totalSale * commissionRate;
    }

    public void displayCommissionEmployee() {
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Sales: " + this.totalSale);
    }

    @Override
    public String toString() {
        return "Employee ID: " + this.empID + "\n"
                + "Employee Name: " + this.empName + "\n"
                + "Total Sales: " + this.totalSale + "\n"
                + "Total Salary (Commission): " + this.computeSalary();
    }

}
