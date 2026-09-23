package version3;

public class Employee{
    int empID;
    Name empName;
    Mydate empBirthDate;
    Mydate empDateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.empBirthDate = new Mydate();
        this.empDateHired = new Mydate();
    }

    public Employee(int empID, Name name, Mydate empBirthDate, Mydate empDateHired) {
        this.empID = empID;
        this.empName = name;
        this.empBirthDate = empBirthDate;
        this.empDateHired = empDateHired;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Mydate getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(Mydate empBirthDate) {
        this.empBirthDate = empBirthDate;
    }

    public Name getName() {
        return empName;
    }

    public void setName(Name name) {
        this.empName = name;
    }

    public Mydate getEmpDateHired() {
        return empDateHired;
    }

    public void setEmpDateHired(Mydate empDateHired) {
        this.empDateHired = empDateHired;
    }



}
