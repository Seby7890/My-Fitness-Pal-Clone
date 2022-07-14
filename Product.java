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