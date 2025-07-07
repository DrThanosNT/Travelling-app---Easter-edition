// Κλάση landmarks που υλοποιεί το interface Cost
public class landmarks implements Cost {

    // Ιδιωτικά πεδία
    private String name;    // Όνομα αξιοθέατου
    private String rating;  // Βαθμολογία αξιοθέατου
    private String comment; // Σχόλιο για το αξιοθέατο

    // Κατασκευαστής με παραμέτρους για αρχικοποίηση όλων των πεδίων
    public landmarks(String name, String rating, String comment) {
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    // Getter για το όνομα
    public String getName() {
        return name;
    }

    // Getter για το rating
    public String getRating() {
        return rating;
    }

    // Getter για το σχόλιο
    public String getComment() {
        return comment;
    }

    // Setter για το όνομα
    public void setName(String name) {
        this.name = name;
    }

    // Setter για το rating
    public void setRating(String rating) {
        this.rating = rating;
    }

    // Setter για το σχόλιο
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Υλοποίηση της μεθόδου του interface Cost
    @Override
    public int calculateCost() {
        return 0; // Τα αξιοθέατα θεωρούνται δωρεάν (μηδενικό κόστος)
    }
}
