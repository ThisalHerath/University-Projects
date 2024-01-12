import java.io.Serializable;

/**
 * The Product class represents a generic product with essential attributes.
 * It implements the Comparable and Serializable interfaces.
 */
class Product implements Comparable<Product>,Serializable {

    // Unique identifier for the product
    private String productId;

    // Name of the product
    private String productName;

    // Available quantity of the product
    private int amountAvailable;

    // Price of the product
    private int price;

    /**
     * Constructor for the Product class initializes a product with specified attributes.
     *
     * @param productId       The unique identifier for the product.
     * @param productName     The name of the product.
     * @param amountAvailable The available quantity of the product.
     * @param price           The price of the product.
     */

    public Product(String productId, String productName, int amountAvailable, int price) {
        this.productId = productId;
        this.productName = productName;
        this.amountAvailable = amountAvailable;
        this.price = price;
    }

    /**
     * Copy constructor for Product creates a new Product object based on an existing Product object.
     *
     * @param source The existing Product object to be copied.
     */
    public Product (Product source){
            this.productId = source.productId;
            this.productName = source.productName;
            this.amountAvailable = source.amountAvailable;
            this.price = source.price;
    }

    /**
     * Static method to create a Product object from a string representation.
     *
     * @param line The string representation of the product.
     * @return A new Product object created from the string representation.
     */
    public static Product fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        }
        return null;
    }

    // Getter methods

    /**
     * Getter method to retrieve the unique identifier of the product.
     *
     * @return The unique identifier of the product.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Getter method to retrieve the name of the product.
     *
     * @return The name of the product.
     */
    public String getProductName() {

        return productName;
    }

    /**
     * Getter method to retrieve the available quantity of the product.
     *
     * @return The available quantity of the product.
     */
    public int getAmountAvailable() {

        return amountAvailable;
    }

    /**
     * Getter method to retrieve the price of the product.
     *
     * @return The price of the product.
     */
    public int getPrice() {

        return price;
    }

    // Setter methods

    /**
     * Setter method to set the unique identifier of the product.
     *
     * @param productId The unique identifier to be set for the product.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Setter method to set the name of the product.
     *
     * @param productName The name to be set for the product.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Setter method to set the available quantity of the product.
     *
     * @param amountAvailable The available quantity to be set for the product.
     */
    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    /**
     * Setter method to set the price of the product.
     *
     * @param price The price to be set for the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Overrides the compareTo method to provide a natural ordering based on product identifiers.
     *
     * @param otherProduct The other product to be compared to.
     * @return The result of the comparison based on product identifiers.
     */
    @Override
    public int compareTo(Product otherProduct) {
        // Assuming productId is a String, adjust the comparison accordingly
        return this.productId.compareTo(otherProduct.productId);
    }
}