import java.util.ArrayList;

// Κλάση Food που υλοποιεί το interface Cost
public class Food implements Cost {

    // Ιδιωτικά πεδία
    private String name; // Όνομα εστιατορίου
    private String type; // Τύπος φαγητού (π.χ. Ιταλικό, Κινέζικο)

    // Κατασκευαστής
    public Food(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getter για το όνομα
    public String getName() {
        return name;
    }

    // Setter για το όνομα
    public void setName(String name) {
        this.name = name;
    }

    // Getter για τον τύπο φαγητού
    public String getType() {
        return type;
    }

    // Setter για τον τύπο φαγητού
    public void setType(String type) {
        this.type = type;
    }

    // Υλοποίηση της μεθόδου του interface Cost
    // Αυτή τη στιγμή επιστρέφει πάντα 15 που ειναι περίπου το κόστος σε κάθε ετσιατόριο
    @Override
    public int calculateCost() {
        return 15;
    }
}
