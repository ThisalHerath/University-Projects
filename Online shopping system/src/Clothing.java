/**
 * The Clothing class represents a clothing product, extending the base Product class.
 * It includes specific attributes for clothing such as size and color.
 */
public class Clothing extends Product {
    // Size of the clothing product
    private String size;
    // Color of the clothing product
    private String colour;
    /**
     * Constructor for Clothing initializes the clothing product with specified attributes.
     *
     * @param productId      The ID of the clothing product.
     * @param productName    The name of the clothing product.
     * @param amountAvailable The available quantity of the clothing product.
     * @param price           The price of the clothing product.
     * @param size            The size of the clothing product.
     * @param colour          The color of the clothing product.
     */
    public Clothing(String productId, String productName, int amountAvailable, int price, String size, String colour) {
        super(productId, productName, amountAvailable, price);
        this.size = size;
        this.colour = colour;
    }
    /**
     * Copy constructor for Clothing creates a new Clothing object based on an existing Clothing object.
     *
     * @param source The existing Clothing object to be copied.
     */
    public Clothing (Clothing source){
        super(source);
        this.size = source.size;
        this.colour = source.colour;
    }
    /**
     * Getter method to retrieve the size of the clothing product.
     *
     * @return The size of the clothing product.
     */
    public String getSize() {
        return size;
    }
    /**
     * Getter method to retrieve the color of the clothing product.
     *
     * @return The color of the clothing product.
     */
    public void setSize(String size) {
        this.size = size;
    }
    /**
     * Getter method to retrieve the color of the clothing product.
     *
     * @return The color of the clothing product.
     */
    public String getColour() {
        return colour;
    }
    /**
     * Setter method to set the color of the clothing product.
     *
     * @param colour The color to be set for the clothing product.
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
    /**
     * Overrides the toString method to provide a formatted string representation of the Clothing object.
     *
     * @return Formatted string representation of the Clothing object.
     */
    @Override
    public String toString() {
        return "Product\nType = Clothing," +
                "productId = " + super.getProductId() +
                ", productName = " + super.getProductName() +
                ", amountAvailable = " + super.getAmountAvailable() +
                ", price = " + super.getPrice() +
                ", size = " + getSize() +
                ", colour = " + getColour();
    }
}
