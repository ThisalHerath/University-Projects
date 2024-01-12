
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The WestminsterShoppingManager class represents a shopping manager for Westminster Electronics Store.
 * It allows users to perform various operations such as adding new products, deleting products,
 * displaying the list of products, loading and saving data, and navigating through a simple menu system.
 */
public class WestminsterShoppingManager implements ShoppingManager {
    private ArrayList<Product> productsList;
    /**
     * Constructor for WestminsterShoppingManager initializes an empty ArrayList to store products.
     */
    public WestminsterShoppingManager() {
        productsList = new ArrayList<>();
    }

    /**
     * Displays the main menu for the Westminster Shopping Manager, allowing users to choose
     * from different options like adding a new product, deleting a product, displaying products,
     * and exiting the program. The method continuously prompts the user for input until the user chooses to exit.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Displaying the main menu with options
        while(true){
            System.out.println("╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║              Westminster Shopping Manager Menu                 ║");
            System.out.println("╠═══════════════════╦════════════════════════════════════════════╣");
            System.out.println("║         1.        ║           Add a new product                ║");
            System.out.println("║         2.        ║            Delete a product                ║");
            System.out.println("║         3.        ║            Display products                ║");
            System.out.println("║         4.        ║                                            ║");
            System.out.println("║         5.        ║                                            ║");
            System.out.println("║         0.        ║                Save and Exit               ║");
            System.out.println("║                   ║                                            ║");
            System.out.println("╚═══════════════════╩════════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            // Switch statement to handle user choices
            switch (choice) {
                case "1":
                    if(productsList.size() == 50){
                        System.out.println("Stock is full. You cannot add more products");
                        displayMenu();
                    }else {
                        addNewProduct();
                    }
                    break;
                case "2":
                    if(productsList.size() ==0){
                        System.out.println("Cannot delete products. Stock is empty");
                    }else {
                        deleteProduct();
                    }
                    break;
                case "3":
                    if(productsList.size() ==0){
                        System.out.println("Cannot preview products. Stock is empty");
                    }else {
                        displayProducts();
                    }
                    break;
                case "0":
                    saveData("products.txt");
                    System.out.println("Exiting Westminster Shopping Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }    
    }

    /**
     * Loads product data from a file named "products.dat" if the file exists.
     * The data is deserialized into the productsList ArrayList.
     */
    public void loadData() {
        File file = new File("products.dat");
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream("products.dat");
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                Object object = objectInputStream.readObject();

                if (object instanceof ArrayList<?>) {
                    productsList = (ArrayList<Product>) object;
                } else {
                    System.out.println("Invalid data format in the file.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Saves the product list to a specified file using ObjectOutputStream for binary serialization.
     *
     * @param fileName The name of the file to which the product list will be saved.
     */
    public void saveData(String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
            objectOutputStream.writeObject(productsList);
            System.out.println("Product list saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving product list to file: " + e.getMessage());
        }
    }
    /**
     * Adds a new product to the productsList ArrayList based on user input.
     * The user is prompted to enter product details such as ID, name, amount available, and price.
     * Additionally, the user can choose to add an electronic or clothing product, each with specific details.
     */
    private void addNewProduct() {

        Scanner scanner_2 = new Scanner(System.in);
        String choice_2;

        Scanner scanner_3 = new Scanner(System.in);
        String productId = "";

        if(productsList.size()==50){
            System.out.println("Maximum product limit has reached. Try removing products from the system.");
            displayMenu();
        }

        while(true){
            while(true){
                System.out.println("Enter the product ID:");
                productId = scanner_3.nextLine();
                if (productId.isEmpty()) {
                    System.out.println("This field cannot be empty. Please enter a product ID.");
                }else{
                    break;
                }
            }

            Boolean idExsist = false;
            for(Product product : productsList){
                if(productId.equals(product.getProductId())){
                    System.out.println("Product with ID " + productId + " already exists. Please enter a different ID.");
                    idExsist=true;
                    break;
                }
            }
            if(!idExsist){
                break;
            }
        }
        String productName = "";

        while(true){
            System.out.println("Enter the product name:");
            productName = scanner_3.nextLine();
            if (productName.isEmpty()) {
                System.out.println("This field cannot be empty. Please enter a product name.");
            }else{
                break;
            }
        }

        int amountAvailable;
        while (true) {
            try {
                System.out.println("Enter the available amount of the product:");
                String amountInput = scanner_3.nextLine();
                if ( amountInput.isEmpty()) {
                    System.out.println("This field cannot be empty. Please enter a valid integer for the amount.");
                } else {
                    amountAvailable = Integer.parseInt(amountInput );
                    if (amountAvailable >= 0) {
                        break;
                    } else {
                        System.out.println("Please enter a correct amount. Amount cannot be negative.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer for the amount.");
            }
        }

        int price;
        while (true){
            try {
                System.out.println("Enter the product price:");
                String priceInput = scanner_3.nextLine();
                if (priceInput.isEmpty()) {
                    System.out.println("This field cannot be empty. Please enter a valid integer for the amount.");
                } else {
                    price = Integer.parseInt(priceInput);
                    if (price > 0) {
                        break;
                    } else {
                        System.out.println("Please enter a correct price. Price cannot be negative or zero.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer for the price.");
            }
            try {
                System.out.println("Enter the product price:");
                price = scanner_3.nextInt();

                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter a valid integer for the price.");
                scanner_3.next();
            }
        }
        // Other input validations and product details entry...
        while(true) {
            System.out.println("Please select the category:");
            System.out.println("1. Add a new electronic product");
            System.out.println("2. Add  a new Clothing product");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            choice_2 = scanner_2.nextLine();

            // Switch statement for handling category choices...
            switch (choice_2) {
                case "1":
                    //Scanner scanner_4 = new Scanner(System.in);

                    System.out.println("Enter the product brand:");
                    String brand = scanner_2.nextLine();

                    int warrantyPeriod;
                    while (true) {
                        try {
                            System.out.println("Enter the number of months given for the warranty period:");
                            warrantyPeriod = scanner_2.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid integer for the warranty period.");
                            scanner_2.next();
                        }
                    }

                    Electronic electronicProduct = new Electronic(productId, productName, amountAvailable, price, brand, warrantyPeriod);
                    productsList.add(electronicProduct);
                    displayMenu();
                    break;
                case "2":
                    //Scanner scanner_2 = new Scanner(System.in);

                    System.out.println("Enter the size of the product:");
                    String size = scanner_2.nextLine();

                    System.out.println("Enter the colour of the product:");
                    String colour = scanner_2.nextLine();


                    Clothing clothingProduct = new Clothing(productId, productName, amountAvailable, price, size, colour);
                    productsList.add(clothingProduct);
                    displayMenu();
                    break;
                case "3":
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }




    }


    /**
     * Deletes a product from the productsList ArrayList based on the provided product ID.
     * The method prompts the user to enter the ID of the product they want to delete.
     * If the product is found, it is removed from the list; otherwise, the user is prompted to try again.
     */
    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the product ID to delete: ");
        String productIdToDelete = scanner.nextLine();

        for (Product product : productsList) {
            if (product.getProductId().equals(productIdToDelete)) {
                productsList.remove(product);
                System.out.println("Product with ID " + productIdToDelete + " deleted successfully.");
                displayMenu();
            }
        }
        System.out.println("Invalid product ID. Please check your input.");
        deleteProduct();



    }

    /**
     * Displays the list of products in a sorted order. The products are sorted based on their natural order,
     * as determined by the Comparable interface implemented by the Product class.
     */
    private void displayProducts() {
        System.out.println(productsList);
        Collections.sort(productsList);
        for (Product product : productsList){
            System.out.println(product);
        }
        displayMenu();
    }

}
