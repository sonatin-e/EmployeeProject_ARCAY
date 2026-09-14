package version2;

public class Name {
String firstN;
String MiddleN;
String LastN;
    public String getFirstN() {
        return firstN;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public String getMiddleN() {
        return MiddleN;
    }

    public void setMiddleN(String middleN) {
        MiddleN = middleN;
    }

    public String getLastN() {
        return LastN;
    }

    public void setLastN(String lastN) {
        LastN = lastN;
    }

    public String displayName(String LastN, String FirstN, String MiddleN) {
        if (MiddleN == null) {
            return LastN + FirstN;
        }
        return LastN + "," + " " + FirstN +" "+ MiddleN.charAt(0) + ".";
    }





}
