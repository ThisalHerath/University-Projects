/**
 * The Main class serves as the entry point for the Westminster Electronics Store application.
 * It creates an instance of WestminsterShoppingManager, loads existing product data, and displays the main menu.
 */
public class Main {
    /**
     * The main method where the execution of the Westminster Electronics Store application begins.
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of WestminsterShoppingManager to manage the shopping operations
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        // Load existing product data from the file "products.dat"
        shoppingManager.loadData();
        // Display the main menu to the user, allowing them to interact with the shopping manager
        shoppingManager.displayMenu();
    }
}
