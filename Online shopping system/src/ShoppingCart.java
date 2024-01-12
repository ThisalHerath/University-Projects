import java.util.ArrayList;

/**
 * The ShoppingCart class represents a shopping cart that can store a list of products.
 * It provides methods to add and remove products, calculate the total cost of the products in the cart,
 * and access the list of products in the cart.
 */
public class ShoppingCart {
    // ArrayList to store the list of products in the shopping cart
    private ArrayList<Product> listOfProducts;

    /**
     * Constructor for ShoppingCart initializes an empty ArrayList to store products.
     */
    public ShoppingCart() {
        this.listOfProducts = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param product The product to be added to the shopping cart.
     */
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product The product to be removed from the shopping cart.
     */
    public void removeProduct(Product product) {
        listOfProducts.remove(product);
    }

    /**
     * Calculates and returns the total cost of all products in the shopping cart.
     *
     * @return The total cost of the products in the shopping cart.
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (Product product : listOfProducts) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    /**
     * Getter method to retrieve the list of products in the shopping cart.
     *
     * @return The list of products in the shopping cart.
     */
    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    /**
     * Setter method to set the list of products in the shopping cart.
     *
     * @param listOfProducts The list of products to be set in the shopping cart.
     */
    public void setListOfProducts(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
}
