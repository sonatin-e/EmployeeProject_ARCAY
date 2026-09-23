package version3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class PieceWorkerEmployee extends Employee{

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee(int totalPiecesFinished, double ratePerPiece) {
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public PieceWorkerEmployee(int empID, Name empName, Mydate empBirthDate, Mydate empDateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, empBirthDate, empDateHired);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary() {
        double basePay = this.totalPiecesFinished * this.ratePerPiece;
        int bonusFactor = this.totalPiecesFinished / 100;
        double bonusPay = bonusFactor * (10 * this.ratePerPiece);


        double birthdayBonus = 0.0;
        if (this.empBirthDate != null && this.empBirthDate.getMonth() == java.time.LocalDate.now().getMonthValue()) {
            birthdayBonus = 5000.0;
        }

        return basePay + bonusPay + birthdayBonus;
    }


    public void displayPieceWorkerEmployee() {
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Pieces Finished: " + this.totalPiecesFinished);
        System.out.println("Rate Per Piece: " + this.ratePerPiece);
    }

    @Override
    public String toString() {
        return "Employee ID: " + this.empID + "\n" +
                "Employee Name: " + this.empName + "\n" +
                "Total Pieces Finished: " + this.totalPiecesFinished + "\n" +
                "Rate Per Piece: " + this.ratePerPiece + "\n" +
                "Total Salary: " + this.computeSalary();
    }
}
