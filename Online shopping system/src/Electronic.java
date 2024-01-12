/**
 * The Electronic class represents an electronic product, extending the base Product class.
 * It includes specific attributes for electronic products such as brand and warranty period.
 */
public class Electronic extends Product {

    // Brand of the electronic product
    private String brand;

    // Warranty period (in months) of the electronic product
    private int warrantyPeriod;

    /**
     * Constructor for Electronic initializes the electronic product with specified attributes.
     *
     * @param productId       The ID of the electronic product.
     * @param productName     The name of the electronic product.
     * @param amountAvailable The available quantity of the electronic product.
     * @param price           The price of the electronic product.
     * @param brand           The brand of the electronic product.
     * @param warrantyPeriod  The warranty period (in months) of the electronic product.
     */
    public Electronic(String productId, String productName, int amountAvailable, int price, String brand, int warrantyPeriod) {
        super(productId, productName, amountAvailable, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * Copy constructor for Electronic creates a new Electronic object based on an existing Electronic object.
     *
     * @param source The existing Electronic object to be copied.
     */
    public Electronic (Electronic source){
        super(source);
        this.brand = source.brand;
        this.warrantyPeriod = source.warrantyPeriod;
    }

    /**
     * Getter method to retrieve the brand of the electronic product.
     *
     * @return The brand of the electronic product.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter method to set the brand of the electronic product.
     *
     * @param brand The brand to be set for the electronic product.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter method to retrieve the warranty period (in months) of the electronic product.
     *
     * @return The warranty period of the electronic product.
     */
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    /**
     * Setter method to set the warranty period (in months) of the electronic product.
     *
     * @param warrantyPeriod The warranty period to be set for the electronic product.
     */
    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * Overrides the toString method to provide a formatted string representation of the Electronic object.
     *
     * @return Formatted string representation of the Electronic object.
     */
    @Override
    public String toString() {
        return "Product\nType = Electronic, " +
                "productId = " + super.getProductId() +
                ", productName = " + super.getProductName() +
                ", amountAvailable = " + super.getAmountAvailable() +
                ", price = " + super.getPrice() +
                ", brand = " + getBrand() +
                ", Warranty Period = " + getWarrantyPeriod() +
                " months ";
    }
}
