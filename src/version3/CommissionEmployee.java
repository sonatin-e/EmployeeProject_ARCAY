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

    private double totalSale;

    public double getTotalSale() {

        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
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
