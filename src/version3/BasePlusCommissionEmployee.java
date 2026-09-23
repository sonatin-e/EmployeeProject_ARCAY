package version3;


public class BasePlusCommissionEmployee extends CommissionEmployee {


    private double baseSalary;

    public BasePlusCommissionEmployee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary() {

        return this.baseSalary + super.computeSalary();
    }

    public void displayBasePlusCommissionEmployee() {

        super.displayCommissionEmployee();
        System.out.println("Base Salary: " + this.baseSalary);
    }

    @Override
    public String toString() {

        return "Employee ID: " + this.getEmpID() + "\n"
                + "Employee Name: " + this.getName() + "\n"
                + "Birth Date: " + (this.getEmpBirthDate() != null ? this.getEmpBirthDate() : "N/A") + "\n"
                + "Date Hired: " + (this.getEmpDateHired() != null ? this.getEmpDateHired() : "N/A") + "\n"
                + "Base Salary: " + this.baseSalary + "\n"
                + "Total Sales: " + this.getTotalSale() + "\n"
                + "Total Computed Salary: " + this.computeSalary();
    }
}
