import java.util.ArrayList;

// Η κλάση Pelatis επεκτείνει την Destination και αναπαριστά έναν πελάτη
public class Pelatis extends Destination {

    // Ιδιωτικά πεδία
    private String onoma;                             // Όνομα πελάτη
    private int tilefono;                             // Τηλέφωνο πελάτη
    private int budget;                               // Προϋπολογισμός πελάτη
    private String password;                          // Κωδικός πρόσβασης πελάτη
    private ArrayList<Food> likedRestaurants = new ArrayList<>();  // Αγαπημένα εστιατόρια
    private ArrayList<landmarks> chosenLandmarks = new ArrayList<>(); // Επιλεγμένα αξιοθέατα
    private Housing house;                            // Επιλογή διαμονής
    private ArrayList<Route> routes = new ArrayList<>(); // Διαδρομές που έχει δημιουργήσει ο πελάτης
    private static final long serialVersionUID = 1L;  // Για τη σειριοποίηση

    // Κατασκευαστής της κλάσης
    public Pelatis(String onoma, int tilefono, int budget, String password) {
        if (onoma == null || onoma.trim().isEmpty()) {
            throw new IllegalArgumentException("Το όνομα δεν μπορεί να είναι κενό.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Ο κωδικός πρόσβασης δεν μπορεί να είναι κενός.");
        }
        if (tilefono <= 0) {
            throw new IllegalArgumentException("Μη έγκυρος αριθμός τηλεφώνου.");
        }
        if (budget < 0) {
            throw new IllegalArgumentException("Ο προϋπολογισμός δεν μπορεί να είναι αρνητικός.");
        }
        this.onoma = onoma;
        this.tilefono = tilefono;
        this.budget = budget;
        this.password = password;
    }

    // --- Getters και Setters ---

    public String getPassword() {
        return password;
    }

    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getOnoma() {
        return onoma;
    }

    public void setOnoma(String onoma) {
        this.onoma = onoma;
    }

    public int getTilefono() {
        return tilefono;
    }

    public void setTilefono(int tilefono) {
        this.tilefono = tilefono;
    }

    // Προαιρετική μέθοδος για εμφάνιση βασικών στοιχείων του πελάτη
    public void emfanishStoixeion() {
        System.out.println("Όνομα: " + onoma);
        System.out.println("Τηλέφωνο: " + tilefono);
    }

    // --- Μέθοδοι για τα Εστιατόρια ---

    // Προσθήκη εστιατορίου στα αγαπημένα

        public void addRestaurant(Food restaurant) {
            if (restaurant == null) {
                System.out.println("Δεν μπορεί να προστεθεί null εστιατόριο.");
                return;
            }
            if (!likedRestaurants.contains(restaurant)) {
                likedRestaurants.add(restaurant);
            }
        }



    // Αφαίρεση εστιατορίου με βάση το όνομα
    public void removeRestaurant(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Μη έγκυρο όνομα εστιατορίου.");
            return;
        }

        boolean removed = likedRestaurants.removeIf(r -> r.getName().equalsIgnoreCase(name.trim()));

        if (!removed) {
            System.out.println("Δεν βρέθηκε εστιατόριο με το όνομα: " + name);
        }
    }

    // Λήψη της λίστας αγαπημένων εστιατορίων
    public ArrayList<Food> getLikedRestaurants() {
        return likedRestaurants;
    }

    // --- Μέθοδοι για τα Αξιοθέατα ---

    // Προσθήκη αξιοθέατου
    public void addLandmark(landmarks landmark) {
        if (landmark == null) {
            System.out.println("Δεν μπορεί να προστεθεί null.");
            return;
        }
        chosenLandmarks.add(landmark);
    }

    // Αφαίρεση αξιοθέατου με βάση το όνομα
    public void removeLandmark(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Μη έγκυρο όνομα αξιοθέατου.");
            return;
        }

        boolean removed = chosenLandmarks.removeIf(l -> l.getName().equalsIgnoreCase(name.trim()));

        if (!removed) {
            System.out.println("Δεν βρέθηκε αξιοθέατο με το όνομα: " + name);
        }
    }

    // Λήψη της λίστας επιλεγμένων αξιοθέατων
    public ArrayList<landmarks> getChosenLandmarks() {
        return chosenLandmarks;
    }

    // --- Μέθοδοι για το Housing (Διαμονή) ---

    // Λήψη του Housing αντικειμένου
    public Housing getHouse() {
        return house;
    }

    // Ορισμός του Housing αντικειμένου
    public void setHouse(Housing house) { if (house == null) {
        System.out.println("Δεν μπορεί να προστεθεί null .");
        return;
    }
        this.house = house;
    }

    // --- Μέθοδοι για τις Διαδρομές (Routes) ---

    // Προσθήκη διαδρομής
    public void addRoute(Route route) {
        routes.add(route);
    }

    // Λήψη όλων των διαδρομών
    public ArrayList<Route> getRoutes() {
        return routes;
    }

    // Εμφάνιση όλων των διαδρομών του πελάτη
    public void showAllRoutes() {
        if (routes.isEmpty()) {
            System.out.println("Δεν έχετε δημιουργήσει κάποια διαδρομή.");
        } else {
            for (int i = 0; i < routes.size(); i++) {
                System.out.println("Διαδρομή " + (i + 1) + ":");
                routes.get(i).showRoute();
            }
        }
    }

    // Εύρεση διαδρομής με βάση το όνομα
    public Route getRouteByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Μη έγκυρο όνομα διαδρομής.");
            return null;
        }

        for (Route r : routes) {
            if (r.getName().equalsIgnoreCase(name.trim())) {
                return r;
            }
        }

        System.out.println("Δεν βρέθηκε διαδρομή με το όνομα: " + name);
        return null;
    }
}
