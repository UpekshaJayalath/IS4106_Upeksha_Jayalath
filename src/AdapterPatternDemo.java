// Target Interface
// This interface defines the standard methods for processing payments.
 interface PaymentProcessor {
    void processPayment(double amount); /*double is used for the amount variable in financial applications
                                         due to its ability to accurately represent fractional values with high precision.*/
}

// Adaptee (Legacy System)
// This class represents the legacy payment gateway.
 class LegacyPaymentGateway {
    // Method to make a payment using the legacy system.
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed using Legacy Payment Gateway.");
    }
}

// New Payment Gateway
// This class represents the new payment gateway that needs to be integrated.
 class NewPaymentGateway {
    // Method to make a payment using the new system.
    public void executeTransaction(double amount) {
        System.out.println("Payment of $" + amount + " processed using New Payment Gateway.");
    }
}

// Adapter Class
// This class adapts the NewPaymentGateway to be compatible with PaymentProcessor.
 class PaymentAdapter implements PaymentProcessor {
    private NewPaymentGateway newPaymentGateway; // Instance of the new payment gateway.

    // Constructor that initializes the new payment gateway.
    public PaymentAdapter() {
        newPaymentGateway = new NewPaymentGateway();
    }

    // Method to process the payment using the new payment gateway.
    @Override
    public void processPayment(double amount) {
        newPaymentGateway.executeTransaction(amount);
    }
}

// Concrete Implementation of PaymentProcessor
// This class represents the payment service which can use either the legacy or new payment gateway.
 class PaymentService {
    private PaymentProcessor paymentProcessor; // Instance of the payment processor.

    // Constructor that takes a payment processor.
    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    // Method to process the payment using the given payment processor.
    public void pay(double amount) {
        paymentProcessor.processPayment(amount);
    }
}

// Client
// This class demonstrates the use of the Adapter pattern to process payments using different payment gateways.
 public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Using the legacy payment gateway.
        // Creating a PaymentProcessor instance that uses the LegacyPaymentGateway's makePayment method.
        PaymentProcessor legacyPayment = new LegacyPaymentGateway()::makePayment;
        // Creating a PaymentService instance that uses the legacyPayment processor.
        PaymentService legacyPaymentService = new PaymentService(legacyPayment);
        // Initiating a payment of $15000.00 using the legacyPaymentService.
        legacyPaymentService.pay(15000.00);

        // Using the new payment gateway via the adapter.
        // Creating a PaymentProcessor instance using the PaymentAdapter, which adapts the NewPaymentGateway.
        PaymentProcessor newPayment = new PaymentAdapter();
        // Creating a PaymentService instance that uses the newPayment processor.
        PaymentService newPaymentService = new PaymentService(newPayment);
        // Initiating a payment of $23500.00 using the newPaymentService.
        newPaymentService.pay(23500.00);
    }
}
