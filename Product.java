// Create the Product class
// The Product class will encapsulate the attributes of a product:
// Product name
// Number of grams of fat
// Number of grams of carbohydrates
// Number of grams of protein
// Total number of calories
// The Product class will also contain the operations for a product
// Class-related computeCalories method (valid for all objects)
// The method accepts as parameters the number of grams of fats, carbohydrates and proteins
// The method returns the total number of calories

public class Product {
    String name;
    int fat;
    int carbs;
    int proteins;
    int calories;

    public Product(String name, int fat, int carbs, int proteins) {
        this.name = name;
        this.fat = fat;
        this.carbs = carbs;
        this.proteins = proteins;
        this.calories = computeCalories(fat, carbs, proteins);
    }

    public static int computeCalories(int fat, int carbs, int proteins) {
        int calories = fat + carbs + proteins;
        return calories;
    }

    public String toString() {
        return "Product {" +
                "name=" + name +
                ", fat='" + fat + '\'' +
                ", carbs='" + carbs + '\'' +
                ", proteins=" + proteins +
                ", calories=" + calories +
                '}';
    }
}