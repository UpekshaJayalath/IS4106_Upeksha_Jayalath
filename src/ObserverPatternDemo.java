import java.util.ArrayList;
import java.util.List;

// Subject Interface
// This interface defines the contract for the subject (shop) that observers will follow.
 interface Shop {
    void register(Customer customer);   // Method to register observers (customers).
    void unregister(Customer customer); // Method to unregister observers (customers).
    void notifyCustomers();            // Method to notify observers (customers) of any updates.
} // these methods manage the list of customers and notify them about any updates.

// Concrete Subject
// This class represents the concrete subject (shop) that implements the Shop interface.
 class OnlineShop implements Shop {
    private List<Customer> customers; // List of registered observers (customers).
    private String shopName;          // Name of the shop.
    private List<String> availableProducts; // List of available products.

    // Constructor to initialize the subject (shop).
    public OnlineShop(String shopName) {
        this.shopName = shopName;
        this.customers = new ArrayList<>();
        this.availableProducts = new ArrayList<>();
    }

    // Method to add new products and notify observers (customers).
    public void addProduct(String product) {
        availableProducts.add(product);
        notifyCustomers();
    }

    // Methods to register, unregister, and notify observers (customers).
    @Override
    public void register(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void unregister(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void notifyCustomers() {
        for (Customer customer : customers) {
            customer.update(availableProducts);
        }
    }
}

// Observer Interface
// This interface defines the contract for observers (customers).
 interface Customer {
    void update(List<String> availableProducts); // Method to update observers (customers) of any changes.
}

// Concrete Observer
// This class represents a concrete observer (customer) that implements the Customer interface.
 class ShopCustomer implements Customer {
    private String customerName; // Name of the customer.

    // Constructor to initialize the observer (customer).
    public ShopCustomer(String customerName) {
        this.customerName = customerName;
    }

    // Method to update the observer (customer) with new product information.
    @Override
    public void update(List<String> availableProducts) {
        System.out.println("Dear " + customerName + ", new products available: " + availableProducts);
    }
}

// Client
// This class demonstrates the use of the Observer pattern in the online shop application.
 public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create a subject (online shop).
        OnlineShop shop = new OnlineShop("MyShop");

        // Create observers (customers).
        Customer customer1 = new ShopCustomer("Alice");
        Customer customer2 = new ShopCustomer("Bob");

        // Register observers (customers) with the subject (online shop).
        shop.register(customer1);
        shop.register(customer2);

        // Add a new product and notify observers (customers).
        shop.addProduct("Smartphone");

        // Unregister an observer (customer) and add another product.
        shop.unregister(customer2);
        shop.addProduct("Laptop");
    }
}
