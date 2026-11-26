import java.util.*;
 class ProductInventorySystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Integer> inventory = new HashMap<>();
    static HashMap<Integer, String> productNames = new HashMap<>();
    static HashMap<Integer, String> productCategories = new HashMap<>();
    static HashMap<Integer, Double> productPrices = new HashMap<>();
    static HashSet<String> categories = new HashSet<>();
    static LinkedHashSet<String> recentProducts = new LinkedHashSet<>();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println("       PRODUCT INVENTORY SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Sell Product");
            System.out.println("6. Remove Product");
            System.out.println("7. Add Product Category");
            System.out.println("8. Display Unique Categories");
            System.out.println("9. Display Sorted Categories");
            System.out.println("10. Display Recently Added Products");
            System.out.println("11. Generate Inventory Report");
            System.out.println("12. Exit");
            System.out.println("13. Remove Product Category");
            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    updateQuantity();
                    break;
                case 5:
                    sellProduct();
                    break;
                case 6:
                    removeProduct();
                    break;
                case 7:
                    addCategory();
                    break;
                case 8:
                    displayCategories();
                    break;
                case 9:
                    displaySortedCategories();
                    break;
                case 10:
                    displayRecentProducts();
                    break;
                case 11:
                    generateReport();
                    break;
                case 12:
                    System.out.println("Thank You! Application Closed.");
                    break;
                case 13:
                    removeCategory();
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 12);
        sc.close();
    }
    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (inventory.containsKey(id)) {
            System.out.println("Product ID Already Exists!");
            return;
        }
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Category: ");
        String category = sc.nextLine();
        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Available Quantity: ");
        int quantity = sc.nextInt();
        if (price < 0 || quantity < 0) {
            System.out.println("Price and Quantity Cannot Be Negative!");
            return;
        }
        inventory.put(id, quantity);
        productNames.put(id, name);
        productCategories.put(id, category);
        productPrices.put(id, price);
        categories.add(category);
        recentProducts.add(name);
        System.out.println("\nProduct Added Successfully!");
    }
    static void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No Products Available!");
            return;
        }
        System.out.println("\n---------- PRODUCT INVENTORY ----------");
        System.out.printf("%-10s %-18s %-18s %-12s %-10s%n",
                "ID", "Product", "Category", "Price", "Quantity");
        for (Integer id : inventory.keySet()) {
            System.out.printf("%-10d %-18s %-18s %-12.2f %-10d%n",
                    id,
                    productNames.get(id),
                    productCategories.get(id),
                    productPrices.get(id),
                    inventory.get(id));
        }
        System.out.println("\nTotal Number of Products: " + inventory.size());
    }
    static void searchProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            System.out.println("\nProduct Found!");
            System.out.println("Product ID: " + id);
            System.out.println("Product Name: " + productNames.get(id));
            System.out.println("Category: " + productCategories.get(id));
            System.out.println("Price: " + productPrices.get(id));
            System.out.println("Available Quantity: " + inventory.get(id));
        } else {
            System.out.println("Product Not Found!");
        }
    }
    static void updateQuantity() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            System.out.print("Enter Quantity to Add: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Enter a Valid Quantity!");
                return;
            }
            inventory.put(id, inventory.get(id) + quantity);
            System.out.println("Stock Updated Successfully!");
            System.out.println("Available Quantity: " + inventory.get(id));
        } else {
            System.out.println("Product Not Found!");
        }
    }
    static void sellProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            System.out.print("Enter Quantity Sold: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Enter a Valid Quantity!");
                return;
            }
            if (inventory.get(id) >= quantity) {
                inventory.put(id, inventory.get(id) - quantity);
                System.out.println("\nSale Completed Successfully!");
                System.out.println("Product ID: " + id);
                System.out.println("Product: " + productNames.get(id));
                System.out.println("Remaining Quantity: " + inventory.get(id));
            } else {
                System.out.println("Insufficient Stock Available!");
            }
        } else {
            System.out.println("Product Not Found!");
        }
    }
    static void removeProduct() {
        System.out.print("Enter Product ID to Remove: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            String name = productNames.get(id);
            String category = productCategories.get(id);
            inventory.remove(id);
            productNames.remove(id);
            productCategories.remove(id);
            productPrices.remove(id);
            boolean nameExists = productNames.containsValue(name);
            if (!nameExists) {
                recentProducts.remove(name);
            }
            if (!productCategories.containsValue(category)) {
                categories.remove(category);
            }
            System.out.println("Product Removed Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }
    }
    static void addCategory() {
        System.out.print("Enter Product Category: ");
        String category = sc.nextLine();
        if (categories.add(category)) {
            System.out.println("Category Added Successfully!");
        } else {
            System.out.println("Category Already Exists!");
        }
    }
    static void displayCategories() {
        System.out.println("\n--------- PRODUCT CATEGORIES ---------");
        if (categories.isEmpty()) {
            System.out.println("No Categories Available!");
            return;
        }
        for (String category : categories) {
            System.out.println(category);
        }
        System.out.println("\nTotal Unique Categories: " + categories.size());
    }
    static void displaySortedCategories() {
        TreeSet<String> sortedCategories = new TreeSet<>(categories);
        System.out.println("\n--------- SORTED CATEGORIES ---------");
        if (sortedCategories.isEmpty()) {
            System.out.println("No Categories Available!");
            return;
        }
        System.out.println("Alphabetical Order:");
        for (String category : sortedCategories) {
            System.out.println(category);
        }
        System.out.println("\nFirst Category: " + sortedCategories.first());
        System.out.println("Last Category: " + sortedCategories.last());
        System.out.println("\nDescending Order:");
        for (String category : sortedCategories.descendingSet()) {
            System.out.println(category);
        }
    }
    static void displayRecentProducts() {
        System.out.println("\n--------- RECENTLY ADDED PRODUCTS ---------");
        if (recentProducts.isEmpty()) {
            System.out.println("No Products Available!");
            return;
        }
        for (String product : recentProducts) {
            System.out.println(product);
        }
        System.out.println("\nSearch Product Name:");
        String search = sc.nextLine();
        if (recentProducts.contains(search)) {
            System.out.println(search + " is Available!");
        } else {
            System.out.println(search + " is Not Available!");
        }
    }
    static void generateReport() {
        if (inventory.isEmpty()) {
            System.out.println("No Products Available for Report!");
            return;
        }
        System.out.println("\n========== INVENTORY REPORT ==========");
        displayProducts();
        System.out.println("\nProducts with Quantity Below 5:");
        boolean found = false;
        for (Integer id : inventory.keySet()) {
            if (inventory.get(id) < 5) {
                System.out.println("Product: " + productNames.get(id)
                        + " | Quantity: " + inventory.get(id));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Products with Low Stock!");
        }
        int totalUnits = 0;
        for (int quantity : inventory.values()) {
            totalUnits += quantity;
        }
        System.out.println("\nTotal Product Units Available: " + totalUnits);
        int highestQuantity = -1;
        int highestId = 0;
        for (Integer id : inventory.keySet()) {
            if (inventory.get(id) > highestQuantity) {
                highestQuantity = inventory.get(id);
                highestId = id;
            }
        }
        System.out.println("\nProduct with Highest Available Quantity:");
        System.out.println("Product: " + productNames.get(highestId));
        System.out.println("Quantity: " + highestQuantity);
        System.out.println("\nAll Unique Categories:");
        for (String category : categories) {
            System.out.println(category);
        }
        System.out.println("Total Unique Categories: " + categories.size());
        System.out.println("\n=======================================");
    }
    static void removeCategory() {
        System.out.print("Enter Category to Remove: ");
        String category = sc.nextLine();
        if (!categories.contains(category)) {
            System.out.println("Category Not Found!");
            return;
        }
        if (productCategories.containsValue(category)) {
            System.out.println("Cannot Remove! Products Still Use This Category.");
            return;
        }
        categories.remove(category);
        System.out.println("Category Removed Successfully!");
    }
}
