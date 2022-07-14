import java.util.Scanner;

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