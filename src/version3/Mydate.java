package version3;

public class Mydate {
    int date;
    int month;
    int year;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String displayDate() {
        String[] monthNames = {
                "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        if (this.month >= 1 && this.month <= 12) {
            return this.date + " " + monthNames[this.month] + " " + this.year;
        }
        return "Invalid Month";
    }

}
