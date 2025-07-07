// Κλάση Housing που υλοποιεί το interface Cost
public class Housing implements Cost {

    // Ιδιωτικά πεδία
    private String hotel;     // Όνομα ξενοδοχείου
    private int costperday;   // Κόστος ανά ημέρα
    private Date date;        // Ημερομηνία και διάρκεια διαμονής

    // Κατασκευαστής
    public Housing(String hotel, int costperday, Date date) {
        this.hotel = hotel;
        this.costperday = costperday;
        this.date = date;
    }

    // Getter για το όνομα του ξενοδοχείου
    public String getHotel() {
        return hotel;
    }

    // Setter για το όνομα του ξενοδοχείου
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    // Getter για το κόστος ανά ημέρα
    public int getCostperday() {
        return costperday;
    }

    // Setter για το κόστος ανά ημέρα
    public void setCostperday(int costperday) {
        this.costperday = costperday;
    }

    // Getter για την ημερομηνία διαμονής
    public Date getDate() {
        return date;
    }

    // Setter για την ημερομηνία διαμονής
    public void setDate(Date date) {
        this.date = date;
    }

    // Υλοποίηση της μεθόδου του interface Cost
    // Υπολογίζει το συνολικό κόστος διαμονής
    @Override
    public int calculateCost() {
        return this.costperday * this.date.getDuration();
    }
}
