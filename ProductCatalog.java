import java.lang.reflect.Array;

public class ProductCatalog {
    Product[] products = new Product[30];
    public static final int maxProducts = 30;
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