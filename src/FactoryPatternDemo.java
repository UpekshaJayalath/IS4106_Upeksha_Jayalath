// Product interface
// Defines a contract for all medications to implement the displayInfo method.
  interface Medication {
    void displayInfo(); // Method to display medication information.
}

// Concrete Product: Tablet
// Represents a Tablet medication and implements the Medication interface.
  class Tablet implements Medication {
    private String name;
    private int dosage;

    // Constructor to initialize a Tablet medication with a name and dosage.
    public Tablet(String name, int dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    @Override
    public void displayInfo() {
        // Prints the information of the Tablet medication.
        System.out.println("Tablet Medication: " + name + ", Dosage: " + dosage + "mg");
    }
}

// Concrete Product: Syrup
// Represents a Syrup medication and implements the Medication interface.
  class Syrup implements Medication {
    private String name;
    private String flavor;

    // Constructor to initialize a Syrup medication with a name and flavor.
    public Syrup(String name, String flavor) {
        this.name = name;
        this.flavor = flavor;
    }

    @Override
    public void displayInfo() {
        // Prints the information of the Syrup medication.
        System.out.println("Syrup Medication: " + name + ", Flavor: " + flavor);
    }
}

// Concrete Product: Injection
// Represents an Injection medication and implements the Medication interface.
  class Injection implements Medication {
    private String name;
    private double dosage;

    // Constructor to initialize an Injection medication with a name and dosage.
    public Injection(String name, double dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    @Override
    public void displayInfo() {
        // Prints the information of the Injection medication.
        System.out.println("Injection Medication: " + name + ", Dosage: " + dosage + "ml");
    }
}

// MedicationFactory class
// Factory class to create instances of different medications based on medication type.
   class MedicationFactory {
    // Method to create a medication based on the type and details provided.
    public Medication createMedication(String medicationType, String... details) {
        if (medicationType == null) {
            return null; // If no medication type is provided, return null.
        }
        // Check medication type and create the corresponding medication object.
        if (medicationType.equalsIgnoreCase("TABLET")) {
            return new Tablet(details[0], Integer.parseInt(details[1])); // Create a Tablet medication.
            //This condition checks if the `medicationType` string is equal to `"TABLET"`,
            // ignoring case differences (`equalsIgnoreCase` ensures it's case-insensitive).
        } else if (medicationType.equalsIgnoreCase("SYRUP")) {
            return new Syrup(details[0], details[1]); // Create a Syrup medication.
            //This condition checks if the `medicationType` string is equal to `"SYRUP"`,
            // ignoring case differences (`equalsIgnoreCase` ensures it's case-insensitive).
        } else if (medicationType.equalsIgnoreCase("INJECTION")) {
            return new Injection(details[0], Double.parseDouble(details[1])); // Create an Injection medication.
            //This condition checks if the `medicationType` string is equal to `"INJECTION"`,
            // ignoring case differences (`equalsIgnoreCase` ensures it's case-insensitive).
        }
        return null; // If medication type doesn't match, return null.
    }
}

// Main class to demonstrate the Factory Pattern for Pharmacy Shop
  public class FactoryPatternDemo {
    public static void main(String[] args) {
        MedicationFactory medicationFactory = new MedicationFactory(); // Create a MedicationFactory object.

        // Create a Tablet medication using the factory.
        Medication tablet = medicationFactory.createMedication("TABLET", "Paracetamol", "500");
        tablet.displayInfo(); // Display the information of the Tablet medication.

        // Create a Syrup medication using the factory.
        Medication syrup = medicationFactory.createMedication("SYRUP", "CoughSyrup", "Cherry");
        syrup.displayInfo(); // Display the information of the Syrup medication.

        // Create an Injection medication using the factory.
        Medication injection = medicationFactory.createMedication("INJECTION", "Insulin", "10.0");
        injection.displayInfo(); // Display the information of the Injection medication.
    }
}
