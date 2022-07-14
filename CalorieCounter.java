import java.util.Scanner;

// Create the CalorieCounter class
// The CalorieCounter class will not have fields, but will contain the main method (entry point in the application)
// In the main a menu of options for the user will be displayed which will be displayed again after each choice
// performed until the user chooses the option to exit the application (EXIT)
// Another method will be created to display the menu: printMenu (which will be called in main)
// It will display the user menu in the console
// MENU:
// "1. Add product to computer and calculate its calories"
// "2. Calculate the calories for a product without being added to the catalog"
// "3. Displays all products in the catalog and the calories for each"
// "4. Delete a product from the catalog"
// "5. Find product by name"
// "6. Exit the application"
// "----------------------------------------------- ----------------- ”
// "Choose the action with the number:";
// After displaying the menu, read the number corresponding to the option, entered by the user in the console
// and the operation specific to the chosen option will be performed
// Based on the input (the number read from the console) it will be decided which operation should be performed using
// switch instruction. This block of code will fit into a performSelectedAction method
// (which will be called in main after reading the input) (receives as parameter the number read from the colossus,
// specific to the option chosen by the user and does not return anything, only performs the operation specific
// to the number introduced). On each branch of the case from the switch instruction, the ProductCatalog object
// will be called, the method corresponding to the chosen option.
// To perform operations 1,3,4,5 you need an instance of the ProductCatalog class.
// This instance (object) is created in the main method before any line of code and is passed
// as a parameter of the performSelectedAction method (along with the input from the console) in order to be
// used to perform the necessary operations

public class CalorieCounter {
    public static void main(String[] args) {
        ProductCatalog myCatalog = new ProductCatalog();
        Scanner console = new Scanner(System.in);
        int option;

        do {
            printMenu();
            option = console.nextInt();
            performSelectedAction(myCatalog, option);
        } while (option != 6);
    }

    public static void printMenu() {
        System.out.println("MENU:");
        System.out.println("1. Add product and calculate it's calories");
        System.out.println("2. Calculate calories for a product without adding it to the catalog");
        System.out.println("3. Display all products in the catalog and their calories");
        System.out.println("4. Delete a product from the catalog");
        System.out.println("5. Find product by name");
        System.out.println("6. EXIT!");
        System.out.println("--------------------------------------------");
        System.out.print("Choose option: ");
    }

    public static void addProductAndCalculateCalories(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.print("Add a product: ");
        String addProduct = console.next();
        System.out.print("Enter fat count: ");
        int fatProduct = console.nextInt();
        System.out.print("Enter carbs count: ");
        int carbProduct = console.nextInt();
        System.out.print("Enter protein count: ");
        int proteinProduct = console.nextInt();
        Product product = new Product(addProduct, fatProduct, carbProduct, proteinProduct);

        if (productCatalog.addProduct(product)) {
            System.out.println("Product " + product.name + " has been added successfully");
            System.out.println("Calorie number is: " + product.computeCalories(product.fat, product.carbs, product.proteins));
        } else {
            System.out.println("List is full or product is already in the list!");
        }
    }

    public static void calculateCalories() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter fat count: ");
        int fatProduct = console.nextInt();
        System.out.print("Enter carbs count: ");
        int carbProduct = console.nextInt();
        System.out.print("Enter protein count: ");
        int proteinProduct = console.nextInt();

        Product.computeCalories(fatProduct, carbProduct, proteinProduct);

        System.out.println("Number of calories is: " + Product.computeCalories(fatProduct, carbProduct, proteinProduct));
    }

    public static void eraseProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.print("Delete a product: ");
        String productName = console.next();

        if (productCatalog.deleteProduct(productName)) {
            System.out.println("Product " + productName + " has been deleted successfully");
        } else {
            System.out.println("Product not in the list");
        }
    }

    public static void findProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.print("Find a product: ");
        String productName = console.next();

        if (productCatalog.getProductByName(productName) != null) {
            System.out.println("Product " + productName + " has been found");
        } else if (productCatalog.getProductByName(productName) == null) {
            System.out.println("Product not found");
        }
    }

    public static void performSelectedAction(ProductCatalog productCatalog, int option) {
        switch (option) {
            case 1 -> addProductAndCalculateCalories(productCatalog);
            case 2 -> calculateCalories();
            case 3 -> productCatalog.printProducts();
            case 4 -> eraseProduct(productCatalog);
            case 5 -> findProduct(productCatalog);
            case 6 -> System.out.println("I'll be back");
            default -> System.out.println("Invalid option.....TRY AGAIN!");
        }
    }
}