import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pelatis> accounts = new ArrayList<>();
    private static String filename = "pelat.dat";

    public static void main(String[] args) {
        accounts = loadPelates(filename); // Φόρτωση υπαρχόντων λογαριασμών από αρχείο
        Main obj = new Main();
        obj.intro(); // Εκκίνηση εφαρμογής
    }

    private void intro() {
        if (accounts.isEmpty()) { // Αν δεν υπάρχουν πελάτες, ζητάει εγγραφή
            System.out.println("Καλως ήρθατε στο Παπει Travellers!");
            System.out.println("Παρακαλώ κάντε Sign up");
            Signup();
        } else {
            // Αν υπάρχουν πελάτες, προσφέρει επιλογές για εγγραφή ή σύνδεση
            Scanner input = new Scanner(System.in);
            System.out.println("Καλως ήρθατε στο Παπει Travellers!");
            System.out.println("Παρακαλώ επιλέξτε μια απο τις παρακάτω επιλογές ( γράφοντας τον αριθμό )");
            System.out.println("<---------------------------------------------------------------------------->");
            System.out.println("1. Sign up (Αν δεν έχετε λογαριασμό)");
            System.out.println("2. Log in (Αν έχετε λογαριασμό)");
            System.out.println("<---------------------------------------------------------------------------->");
            Boolean con = true;
            do {
                  switch (readInt()) {
                      case 1:
                          Signup();
                          con = false;
                          break;

                      case 2:
                          Login();
                          con = false;
                          break;
                      default:
                          System.out.println("Παρακαλώ επιλέξτε έναν αριθμό από τις επιλογές.");
                          break;
                  }
              }while(con);
        }
    }

    private void menu(int ID) {
        Scanner input = new Scanner(System.in);
        Pelatis user = accounts.get(ID); // Ανάκτηση πελάτη με βάση το ID
        String onoma = user.getOnoma();
        System.out.println("Γεια σας " + onoma + " τι θα θέλατε να κάνετε? (Πατήστε τον αριθμό που θέλετε)");
        Boolean Continue = true;

        do {
            // Εμφάνιση διαθέσιμων επιλογών στον χρήστη
            System.out.println("<---------------------------------------------------------------------------->");
            System.out.println(
                    "1. Προβολή προορισμού\n" +
                            "2. Ορισμός κατοικίας\n" +
                            "3. Προβολή κατοικίας\n" +
                            "4. Προβολή κόστους (οικείας)\n" +
                            "5. Προσθήκη νέου αξιοθέατου \n" +
                            "6. Προβολή όλων των διαθέσιμων αξιοθέατων/καταλυμάτων\n" +
                            "7. Προβολή κριτικών αξιοθέατου\n" +
                            "8. Προβολή κόστους (επίσκεψης αξιοθεάτου)\n" +
                            "9. Προσθήκη εστιατορίου για επίσκεψη\n" +
                            "10. Αναζήτηση βάσει ονόματος (εστιατόριο)\n" +
                            "11. Προβολή κόστους (εστιατορίου)\n" +
                            "12. Διαγραφή εστιατορίου\n" +
                            "13. Δημιουργία διαδρομής \n" +
                            "14. Έξοδος από την εφαρμογή \n");

            System.out.println("<---------------------------------------------------------------------------->");

            switch (readInt()) {
                case 1:
                    // Εμφάνιση προορισμού
                    System.out.println("Ο προορισμός σας είναι " + user.getCity());
                    break;
                case 2:
                    // Καταχώρηση νέας κατοικίας
                    System.out.println("Παρακαλώ εισάγεται το όνομα του ξενοδοχείου σας: ");
                    String H = input.nextLine();
                    System.out.println("Παρακαλώ εισάγεται το κόστος/ημέρα του ξενοδοχείου σας: ");
                    int Hcost = readInt();
                    System.out.println("Παρακαλώ εισάγεται την ημερομηνία της διαμονής σας (πρώτη μέρα): ");
                    String date = input.nextLine();
                    System.out.println("Παρακαλώ εισάγεται τη διάρκεια της διαμονής σας: ");
                    int dura = readInt();
                    user.setHouse(new Housing(H, Hcost, new Date(date, dura)));
                    break;
                case 3:
                    // Εμφάνιση κατοικίας
                    if (user.getHouse() == null) {
                        System.out.println("Δεν έχετε ορίσει κατοικία");
                    } else {
                        System.out.println(user.getHouse().getHotel());
                    }
                    break;
                case 4:
                    // Υπολογισμός κόστους κατοικίας
                    if (user.getHouse() == null) {
                        System.out.println("Δεν έχετε ορίσει κατοικία");
                    } else {
                        System.out.println("Το συνολικό κόστος είναι " + user.getHouse().calculateCost() + "$");
                    }
                    break;
                case 5:
                    // Προσθήκη αξιοθέατου
                    System.out.println("Ποιό είναι το όνομα του αξιοθεάτου?");
                    String markname = input.nextLine();
                    System.out.println("Τι rating βάζετε?");
                    String rating = input.nextLine();
                    System.out.println("Τι σχόλιο βάζετε?");
                    String comment = input.nextLine();
                    landmarks mark = new landmarks(markname, rating, comment);
                    user.getChosenLandmarks().add(mark);
                    System.out.println("H λίστα ενημερώθηκε");
                    break;
                case 6:
                    // Προβολή όλων αξιοθέατων
                    showUserLandmarks(user);
                    break;
                case 7:
                    // Προβολή κριτικής αξιοθέατου
                    System.out.println("Σε ποιό αξιοθέατο θέλετε να δείτε κριτική?");
                    String nameToSearch = input.nextLine();
                    landmarks L = searchLandmarkByName(user, nameToSearch);
                    if (L != null) {
                        System.out.println("Η κριτική είναι " + L.getRating());
                    }
                    break;
                case 8:
                    // Προβολή κόστους αξιοθέατου
                    System.out.println("Σε ποιό αξιοθέατο θέλετε να δείτε κριτική?");
                    nameToSearch = input.nextLine();
                    L = searchLandmarkByName(user, nameToSearch);
                    if (L != null) {
                        System.out.println("Το κόστος είναι " + L.calculateCost());
                    }
                    else { System.out.println("Δεν εχετε ορίσει αξιοθέατο");}
                    break;
                case 9:
                    // Προσθήκη εστιατορίου
                    System.out.println("Ποιό είναι το όνομα του εστιατορίου?");
                    String restname = input.nextLine();
                    System.out.println("Τι είδος φαγητού έχει?");
                    String type = input.nextLine();
                    System.out.println("H λίστα ενημερώθηκε");

                    Food rest = new Food(restname, type);
                    user.getLikedRestaurants().add(rest);
                    break;
                case 10:
                    // Αναζήτηση εστιατορίου
                    System.out.println("Ποιό εστιατόριο ψάχνετε?");
                    String search1 = input.nextLine();
                    Food restaur = searchRestaurantByName(user, search1);
                    if (restaur != null) {
                    System.out.println("Tο " + searchRestaurantByName(user, search1).getName() + " υπάρχει στη λίστα"); }


                    break;
                case 11:
                    // Προβολή κόστους εστιατορίου
                    System.out.println("Ποιό εστιατόριο θέλετε να δείτε το κόστος?");
                    String search = input.nextLine();
                     restaur = searchRestaurantByName(user, search);
                    if (restaur != null) {
                        System.out.println("Το κόστος είναι " + restaur.calculateCost() + "$");
                    }
                    else { System.out.println("Δεν έχετε ορίσει εστιατόρια");}
                    break;
                case 12:
                    // Διαγραφή εστιατορίου
                    System.out.println("Ποιό εστιατόριο θέλετε να διαγράψετε?");
                    search = input.nextLine();
                    removeRestaurantByName(user, search);
                    break;
                case 13:
                    // Δημιουργία διαδρομής
                    addRoute(user);
                    break;
                case 14:
                    // Έξοδος
                    System.out.println("Καλό ταξίδι!");
                    Continue = false;
                    break;
                default:
                    System.out.println("Παρακαλώ επιλέξτε έναν αριθμό από τις επιλογές.");
                    break;
            }
        } while (Continue);

        savePelates(accounts, filename); // Αποθήκευση στοιχείων κατά την έξοδο
    }

    private void Signup() {
        // Εγγραφή νέου χρήστη
        Scanner input = new Scanner(System.in);
        System.out.println("Παρακαλώ δώστε το όνομα σας: ");
        String onoma = input.nextLine();
        System.out.println("Παρακαλώ δώστε το τηλέφωνο σας: ");
        int number = readInt();
        System.out.println("Παρακαλώ δώστε το ποσό χρημάτων για το ταξίδι σας (σε αριθμό): ");
        int budget = readInt();
        System.out.println("Παρακαλώ δημιουργήστε τον κωδικό σας: ");
        String password = input.nextLine();

        while (!Robot_check()) { // Έλεγχος αν είναι ρομπότ
            System.out.println("You are a Robot!");
        }

        Pelatis account = new Pelatis(onoma, number, budget, password);
        accounts.add(account);
        int id = accounts.size() - 1;
        System.out.println("Το ID σας ειναι " + id);
        menu(accounts.size() - 1);
    }

    public landmarks searchLandmarkByName(Pelatis user, String nameToSearch) {
        // Αναζήτηση αξιοθέατου
        ArrayList<landmarks> landmarksList = user.getChosenLandmarks();
        if (landmarksList == null || landmarksList.isEmpty()) {
            System.out.println("Δεν έχετε επιλέξει κάποιο αξιοθέατο ακόμα.");
            return null;
        }
        for (landmarks l : landmarksList) {
            if (l.getName().equalsIgnoreCase(nameToSearch)) {
                return l;
            }
        }
        System.out.println("Το αξιοθέατο \"" + nameToSearch + "\" δεν βρέθηκε στη λίστα σας.");
        return null;
    }

    public void showUserLandmarks(Pelatis user) {
        // Εμφάνιση αξιοθέατων χρήστη
        ArrayList<landmarks> landmarksList = user.getChosenLandmarks();
        if (landmarksList == null || landmarksList.isEmpty()) {
            System.out.println("Δεν έχετε ορίσει κάποιο αξιοθέατο ακόμα.");
        } else {
            System.out.println("Τα αξιοθέατα που έχετε επιλέξει:");
            for (landmarks lm : landmarksList) {
                System.out.println("- " + lm.getName());
            }
        }
    }

    private void Login() {
        // Σύνδεση χρήστη
        Scanner input = new Scanner(System.in);
        System.out.println("Παρακαλώ δώστε το ID σας: ");
        int ID = readInt();
        System.out.println("Παρακαλώ δώστε τον κωδικό σας: ");
        String password = input.nextLine();
        if (ID >= 0 && ID < accounts.size() && Objects.equals(password, accounts.get(ID).getPassword())) {
            menu(ID);
        } else {
            System.out.println("Λάθος κωδικός ή ID");
        }
    }

    private Boolean Robot_check() {
        // Έλεγχος ανθρώπου
        Scanner input = new Scanner(System.in);
        System.out.println("Παρακαλώ γράψτε τον αριθμό που βλέπετε για να δείξετε ότι δεν είστε ρομπότ");
        System.out.println("1111111\n" +
                "     1\n" +
                "    1\n" +
                "   1\n" +
                "  1\n" +
                " 1\n" +
                "1");
        int num = readInt();
        return num == 7;
    }

    public static int readInt() {
        // Διασφάλιση σωστής εισαγωγής ακέραιου αριθμού
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean valid = false;
        do {
            try {
                number = Integer.parseInt(input.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Δεν είναι αριθμός αυτό!");
            }
        } while (!valid);
        return number;
    }

    public Food searchRestaurantByName(Pelatis user, String nameToSearch) {
        // Αναζήτηση εστιατορίου
        ArrayList<Food> restaurantsList = user.getLikedRestaurants();
        if (restaurantsList == null || restaurantsList.isEmpty()) {
            System.out.println("Δεν έχετε προσθέσει κάποιο εστιατόριο ακόμα.");
            return null;
        }
        for (Food r : restaurantsList) {
            if (r.getName().equalsIgnoreCase(nameToSearch)) {
                return r;
            }
        }
        System.out.println("Το εστιατόριο \"" + nameToSearch + "\" δεν βρέθηκε στη λίστα σας.");
        return null;
    }

    public void removeRestaurantByName(Pelatis user, String nameToRemove) {
        // Διαγραφή εστιατορίου

        ArrayList<Food> restaurantsList = user.getLikedRestaurants();
        if (restaurantsList == null || restaurantsList.isEmpty()) {
            System.out.println("Η λίστα με τα εστιατόρια είναι άδεια.");
            return;
        }

        boolean removed = false;
        for (int i = 0; i < restaurantsList.size(); i++) {
            Food restaurant = restaurantsList.get(i);
            if (restaurant.getName().equalsIgnoreCase(nameToRemove)) {
                restaurantsList.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Το εστιατόριο \"" + nameToRemove + "\" διαγράφηκε επιτυχώς.");
        } else {
            System.out.println("Δεν βρέθηκε το εστιατόριο \"" + nameToRemove + "\" στη λίστα σας.");
        }
    }

    private void addRoute(Pelatis user) {
        // Προσθήκη νέας διαδρομής
        Scanner input = new Scanner(System.in);
        System.out.println("Παρακαλώ εισάγετε το όνομα της διαδρομής:");
        String routeName = input.nextLine();
        Route newRoute = new Route(routeName);

        // Εισαγωγή στάσεων στη διαδρομή
        String addStopsResponse;
        do {
            System.out.println("Θέλετε να προσθέσετε στάσεις σε αυτή τη διαδρομή; (Ναι/Όχι)");
            addStopsResponse = input.nextLine();
            if (addStopsResponse.equalsIgnoreCase("Ναι")) {
                String stop;
                do {
                    System.out.println("Προσθέστε στάση (ή 'τέλος' για να ολοκληρώσετε):");
                    stop = input.nextLine();
                    if (!stop.equalsIgnoreCase("τέλος")) {
                        newRoute.addStop(stop);
                        System.out.println("Η στάση προστέθηκε.");
                    }
                } while (!stop.equalsIgnoreCase("τέλος"));
            }
        } while (!addStopsResponse.equalsIgnoreCase("Όχι"));

        user.addRoute(newRoute);
        System.out.println("Η διαδρομή προστέθηκε με επιτυχία.");
        user.showAllRoutes();
    }

    public static void savePelates(ArrayList<Pelatis> pelates, String filename) {
        // Αποθήκευση λίστας πελατών σε αρχείο
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pelates);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static ArrayList<Pelatis> loadPelates(String filename) {
        // Φόρτωση λίστας πελατών από αρχείο
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Δεν βρέθηκε αρχείο πελατών. Δημιουργείται νέα λίστα...");
            return new ArrayList<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<Pelatis>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
