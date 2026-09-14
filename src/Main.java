//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import version2.*;// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        HourlyEmployee emp1 = new HourlyEmployee(101, "Alice Smith", 40.0f, 25.0f);
        emp1.displayHourlyEmployee();
        System.out.println("");
        System.out.println(emp1.toString());

        System.out.println("");
        PieceWorkerEmployee p1Emp = new PieceWorkerEmployee(67, "John Pork", 20, 32.0);
        p1Emp.displayPieceWorkerEmployee();

        System.out.println("");
        System.out.println(p1Emp.toString());

        System.out.println("");
        CommissionEmployee  Commemp = new CommissionEmployee(55, "Josh Mojica",60000.0);
        Commemp.displayCommissionEmployee();
        System.out.println("");
        System.out.println(Commemp.toString());

        System.out.println("");
        BasePlusCommissionEmployee bComm2 = new BasePlusCommissionEmployee(402, "Henry Cavill", 45000.0, 20000.0);
        bComm2.displayBasePlusCommissionEmployee();
        System.out.println("");
        System.out.println(bComm2.toString());


        Mydate today = new Mydate();


        today.setDate(14);
        today.setMonth(9);
        today.setYear(2026);
        System.out.println("");
        System.out.println(today.displayDate());
        today.setMonth(13);
        System.out.println("");
        System.out.println("Invalid Date " + today.displayDate());

        Name name = new Name();

        System.out.println(name.displayName("Lebron", "James", "Raymone"));
    }
    }
