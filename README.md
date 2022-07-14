Calorie Counter Catalog

Create the Product class. The Product class will encapsulate the attributes of a product:
- Product name
- Number of grams of fat
- Number of grams of carbohydrates
- Number of grams of protein
- Total number of calories
The Product class will also contain the operations for a product
- Class-related computeCalories method (valid for all objects)
The method accepts as parameters the number of grams of fats, carbohydrates and proteins. The method returns the total number of calories.

Create the ProductCatalog class. The ProductCatalog class will have the following attributes:
- A list of products (maximum 30 products are accepted in the list)
- Maximum number of products = 30 (constant)
- Number of products added to the list
The ProductCatalog class will also contain the following operations:
- printProducts method
    The method does not accept any parameters
    The method does not return anything, it only prints the list of products in the console
- addProduct method
    The method receives a product as parameter
    If the product is already in the list or if the list is already full, it will return false (operation failed)
    If it is not already in the list, the product will be added to the list and returned true (operation successful)
- getProductByName method
    The method receives as parameter the name of a product
    The method returns the product in the list that has the name equal to the name received as a parameter
    If the product was not found, null will be returned
- deleteProduct method
    The method receives as parameter the name of a product
    The product will be searched in the list of products by name
    If the product was not found it will return false (operation failed)
    Otherwise, the product will be deleted from the product list and will return true (operation successful)
    
Tips: the operation of searching for a product by name is used in 2 places so it can be created a private method to search for the product by name in the list,
which returns the index in the array to which find the product or -1 if it was not found.

Create the CalorieCounter class. The CalorieCounter class will not have fields, but will contain the main method (entry point in the application).
In the main a menu of options for the user will be displayed which will be displayed again after each choice performed until the user chooses the option to exit the application (EXIT). Another method will be created to display the menu: printMenu (which will be called in main). It will display the user menu in the console
MENU:
 - "1. Add product to computer and calculate its calories"
 - "2. Calculate the calories for a product without being added to the catalog"
 - "3. Displays all products in the catalog and the calories for each"
 - "4. Delete a product from the catalog"
 - "5. Find product by name"
 - "6. Exit the application"
 - "----------------------------------------------- ----------------- ”
 - "Choose the action with the number:";
After displaying the menu, read the number corresponding to the option, entered by the user in the console and the operation specific to the chosen option will be performed. Based on the input (the number read from the console) it will be decided which operation should be performed using switch instruction.
This block of code will fit into a performSelectedAction method (which will be called in main after reading the input) (receives as parameter the number read from the console specific to the option chosen by the user and does not return anything, only performs the operation specific to the number introduced). On each branch of the case from the switch instruction, the ProductCatalog object will be called, the method corresponding to the chosen option. To perform operations 1,3,4,5 you need an instance of the ProductCatalog class. This instance (object) is created in the main method before any line of code and is passed as a parameter of the performSelectedAction method (along with the input from the console) in order to be used to perform the necessary operations.
