import java.io.Serializable;
import java.util.ArrayList;

// Κλάση Route που αναπαριστά μια διαδρομή και υλοποιεί το Serializable για αποθήκευση/φόρτωση από αρχεία
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    // Ιδιωτικά πεδία
    private String name;                // Όνομα της διαδρομής
    private ArrayList<String> stops = new ArrayList<>(); // Στάσεις της διαδρομής

    // Κατασκευαστής που δέχεται το όνομα της διαδρομής
    public Route(String name) {
        this.name = name;
    }

    // Getter για το όνομα της διαδρομής
    public String getName() {
        return name;
    }

    // Μέθοδος για προσθήκη νέας στάσης
    public void addStop(String stop) {
        stops.add(stop);
    }

    // Μέθοδος για αφαίρεση στάσης με βάση το όνομα (χωρίς διάκριση πεζών-κεφαλαίων)
    public void removeStop(String stop) {
        stops.removeIf(s -> s.equalsIgnoreCase(stop));
    }

    // Getter για τις στάσεις της διαδρομής
    public ArrayList<String> getStops() {
        return stops;
    }

    // Μέθοδος για εμφάνιση όλων των στάσεων της διαδρομής
    public void showRoute() {
        if (stops.isEmpty()) {
            System.out.println("Η διαδρομή \"" + name + "\" είναι κενή.");
        } else {
            System.out.println("Διαδρομή \"" + name + "\":");
            for (int i = 0; i < stops.size(); i++) {
                System.out.println((i + 1) + ". " + stops.get(i));
            }
        }
    }
}
