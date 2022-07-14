import java.lang.reflect.Array;

// Create the ProductCatalog class
// The ProductCatalog class will have the following attributes:
// A list of products (maximum 30 products are accepted in the list)
// Maximum number of products = 30 (constant)
// Number of products added to the list
// The ProductCatalog class will also contain the following operations:
// PrintProducts method
// The method does not accept any parameters
// The method does not return anything, it only prints the list of products in the console
// AddProduct method
// The method receives a product as parameter
// If the product is already in the list or if the list is already full, it will return false (operation failed)
// If it is not already in the list, the product will be added to the list and returned true (operation successful)
// GetProductByName method
// The method receives as parameter the name of a product
// The method returns the product in the list that has the name equal to the name received as a parameter
// If the product was not found, null will be returned
// deleteProduct method
// The method receives as parameter the name of a product
// The product will be searched in the list of products by name.
// If the product was not found it will return false (operation failed)
// Otherwise, the product will be deleted from the product list and will return true (operation successful)
// Tips: the operation of searching for a product by name is used in 2 places so it can be created
// a private method to search for the product by name in the list, which returns the index in the array to which
// find the product or -1 if it was not found

public class ProductCatalog {
    Product[] products = new Product[4];
    public static final int maxProducts = 4;
    int addedProducts = 0;

    public void printProducts() {
        if (addedProducts == 0) {
            System.out.println("No products in the list!");
            return;
        }

        System.out.println("Current product list is: ");

        for (int i = 0; i < addedProducts; i++) {
            System.out.println(products[i].name + ": " + products[i].calories);
        }
    }

    public boolean addProduct(Product product) {
        if ((getProductByName(product.name) != null) || (addedProducts >= maxProducts)) {
            return false;
        } else {
            Array.set(products, addedProducts, product);
            addedProducts++;
            return true;
        }
    }

    public Product getProductByName(String productName) {
        int index = findProductIndex(productName);

        if (index == -1) {
            return null;
        } else {
            return products[index];
        }
    }

    public boolean deleteProduct(String productName) {
        int index = findProductIndex(productName);

        if (index == -1) {
            return false;
        } else {
            for (int i = index; i < addedProducts - 1; i++) {
                products[i] = products[i + 1];
            }
            addedProducts--;
            return true;
        }
    }

    private int findProductIndex(String productName) {
        if (addedProducts > 0) {
            for (int i = 0; i < addedProducts; i++) {
                if (productName.equals(products[i].name)) {
                    return i;
                }
            }
        }
        return -1;
    }
}