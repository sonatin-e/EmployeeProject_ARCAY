package version4;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            int totalPiecesFinished,
            double ratePerPiece) {

        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException("Pieces cannot be negative.");
        }

        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException("Rate cannot be negative.");
        }

        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary(int currentMonth) {
        double salary =
                totalPiecesFinished * ratePerPiece
                        + (totalPiecesFinished / 100) * 10 * ratePerPiece;

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();

        System.out.println(
                "Total Pieces Finished: " + totalPiecesFinished
        );

        System.out.printf(
                "Rate Per Piece: ₱%.2f%n",
                ratePerPiece
        );
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
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

        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }

        PieceWorkerEmployee other =
                (PieceWorkerEmployee) obj;

        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(
                ratePerPiece,
                other.ratePerPiece
        ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                totalPiecesFinished,
                ratePerPiece
        );
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}