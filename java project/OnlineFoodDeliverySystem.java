// ============================================================
//   ONLINE FOOD DELIVERY SYSTEM
//   OOP with Java - All classes in one file for easy running
//   Compile : javac OnlineFoodDeliverySystem.java
//   Run     : java Main
// ============================================================

// ─── FoodItem Class ──────────────────────────────────────────
class FoodItem {
    private String name;
    private double price;
    private String category;

    public FoodItem(String name, double price, String category) {
        this.name     = name;
        this.price    = price;
        this.category = category;
    }

    public String getName()     { return name;     }
    public double getPrice()    { return price;    }
    public String getCategory() { return category; }

    public void displayItem() {
        System.out.printf("  %-25s %-15s Rs.%.2f%n", name, category, price);
    }
}

// ─── Restaurant Class ────────────────────────────────────────
class Restaurant {
    private String     name;
    private String     location;
    private double     distanceKm;
    private FoodItem[] menu;
    private int        itemCount;

    public Restaurant(String name, String location, double distanceKm) {
        this.name       = name;
        this.location   = location;
        this.distanceKm = distanceKm;
        this.menu       = new FoodItem[50];
        this.itemCount  = 0;
    }

    public void addFoodItem(FoodItem item) {
        if (itemCount < menu.length) {
            menu[itemCount++] = item;
        }
    }

    public void displayMenu() {
        System.out.println("\n=== Menu: " + name + " | Location: " + location + " ===");
        System.out.printf("  %-25s %-15s %s%n", "Item", "Category", "Price");
        System.out.println("  " + "-".repeat(50));
        for (int i = 0; i < itemCount; i++) {
            menu[i].displayItem();
        }
    }

    public String    getName()       { return name;       }
    public String    getLocation()   { return location;   }
    public double    getDistanceKm() { return distanceKm; }
    public FoodItem[] getMenu()      { return menu;       }
    public int       getItemCount()  { return itemCount;  }
}

// ─── Order Class ─────────────────────────────────────────────
class Order {
    private Restaurant restaurant;
    private FoodItem[] orderedItems;
    private int[]      quantities;
    private double[]   subtotals;
    private int        itemCount;
    private double     foodTotal;
    private double     deliveryCharge;
    private double     tax;

    // Delivery is free when food total >= FREE_DELIVERY_THRESHOLD
    private static final double FREE_DELIVERY_THRESHOLD = 500.0;
    // Otherwise charge Rs.10 per km from restaurant
    private static final double CHARGE_PER_KM           = 10.0;
    // Tax rate
    private static final double TAX_RATE                = 0.05;

    public Order(Restaurant restaurant) {
        this.restaurant     = restaurant;
        this.orderedItems   = new FoodItem[20];
        this.quantities     = new int[20];
        this.subtotals      = new double[20];
        this.itemCount      = 0;
        this.foodTotal      = 0;
        this.deliveryCharge = 0;
        this.tax            = 0;
    }

    // Add a food item with a quantity; computes and stores the subtotal
    public void addItem(FoodItem item, int qty) {
        if (itemCount < orderedItems.length) {
            orderedItems[itemCount] = item;
            quantities[itemCount]   = qty;
            subtotals[itemCount]    = item.getPrice() * qty;
            itemCount++;
            System.out.println("  Added: " + qty + "x " + item.getName()
                + "  =>  Rs." + String.format("%.2f", subtotals[itemCount - 1]));
        } else {
            System.out.println("  Order is full. Cannot add more items.");
        }
    }

    // Sum all subtotals to get food total
    public double calculateTotal() {
        foodTotal = 0;
        for (int i = 0; i < itemCount; i++) {
            foodTotal += subtotals[i];
        }
        return foodTotal;
    }

    // Apply delivery charge based on distance rule; calculate tax
    public void applyDeliveryCharge() {
        if (foodTotal >= FREE_DELIVERY_THRESHOLD) {
            deliveryCharge = 0.0;   // Free delivery on orders >= Rs.500
        } else {
            deliveryCharge = restaurant.getDistanceKm() * CHARGE_PER_KM;
        }
        tax = foodTotal * TAX_RATE;
    }

    // Print the complete formatted order summary / bill
    public void displayOrderSummary() {
        System.out.println("\n" + "=".repeat(46));
        System.out.println("              ORDER SUMMARY");
        System.out.println("=".repeat(46));
        System.out.printf("  Restaurant : %s%n", restaurant.getName());
        System.out.printf("  Location   : %s  (%.1f km away)%n",
            restaurant.getLocation(), restaurant.getDistanceKm());
        System.out.println("=".repeat(46));
        System.out.printf("  %-22s %4s  %9s%n", "Item", "Qty", "Subtotal");
        System.out.println("  " + "-".repeat(40));
        for (int i = 0; i < itemCount; i++) {
            System.out.printf("  %-22s %4d  Rs.%6.2f%n",
                orderedItems[i].getName(), quantities[i], subtotals[i]);
        }
        System.out.println("  " + "-".repeat(40));
        System.out.printf("  %-27s Rs.%6.2f%n", "Food Total",     foodTotal);
        System.out.printf("  %-27s Rs.%6.2f%n", "Delivery Charge", deliveryCharge);
        System.out.printf("  %-27s Rs.%6.2f%n", "Tax (5%)",       tax);
        System.out.println("=".repeat(46));
        System.out.printf("  %-27s Rs.%6.2f%n", "GRAND TOTAL",
            foodTotal + deliveryCharge + tax);
        System.out.println("=".repeat(46));
        if (deliveryCharge == 0) {
            System.out.println("  ✓ Free delivery applied (order above Rs.500)");
        } else {
            System.out.printf("  Delivery charge: Rs.10 x %.1f km = Rs.%.2f%n",
                restaurant.getDistanceKm(), deliveryCharge);
        }
        System.out.println("=".repeat(46) + "\n");
    }
}

// ─── Main Driver Class ───────────────────────────────────────
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║    ONLINE FOOD DELIVERY SYSTEM           ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // ── Restaurant 1 ──────────────────────────
        Restaurant r1 = new Restaurant("PizzaHub", "MG Road", 4.5);

        FoodItem pizza1 = new FoodItem("Margherita Pizza",  199.0, "Main Course");
        FoodItem pizza2 = new FoodItem("Pepperoni Pizza",   249.0, "Main Course");
        FoodItem bread  = new FoodItem("Garlic Bread",       89.0, "Starter");
        FoodItem coffee = new FoodItem("Cold Coffee",        79.0, "Beverage");
        FoodItem cake   = new FoodItem("Choco Lava Cake",   129.0, "Dessert");

        r1.addFoodItem(pizza1);
        r1.addFoodItem(pizza2);
        r1.addFoodItem(bread);
        r1.addFoodItem(coffee);
        r1.addFoodItem(cake);

        // ── Restaurant 2 ──────────────────────────
        Restaurant r2 = new Restaurant("BurgerKing", "Brigade Road", 2.0);

        FoodItem burger1 = new FoodItem("Whopper Burger",  179.0, "Main Course");
        FoodItem burger2 = new FoodItem("Veggie Burger",   129.0, "Main Course");
        FoodItem fries   = new FoodItem("French Fries",     69.0, "Starter");
        FoodItem shake   = new FoodItem("Chocolate Shake",  99.0, "Beverage");

        r2.addFoodItem(burger1);
        r2.addFoodItem(burger2);
        r2.addFoodItem(fries);
        r2.addFoodItem(shake);

        // ── Display Menus ─────────────────────────
        r1.displayMenu();
        r2.displayMenu();

        // ══ ORDER 1 from PizzaHub (total will exceed Rs.500 → free delivery) ══
        System.out.println("\n--- Placing Order from PizzaHub ---");
        Order order1 = new Order(r1);
        order1.addItem(pizza1, 2);   // 2 x Rs.199  = Rs.398
        order1.addItem(bread,  1);   // 1 x Rs.89   = Rs.89
        order1.addItem(coffee, 2);   // 2 x Rs.79   = Rs.158
        order1.addItem(cake,   1);   // 1 x Rs.129  = Rs.129
        // Food Total = Rs.774 → free delivery (>= Rs.500)

        order1.calculateTotal();
        order1.applyDeliveryCharge();
        order1.displayOrderSummary();

        // ══ ORDER 2 from BurgerKing (total below Rs.500 → distance charge) ══
        System.out.println("--- Placing Order from BurgerKing ---");
        Order order2 = new Order(r2);
        order2.addItem(burger2, 1);  // 1 x Rs.129  = Rs.129
        order2.addItem(fries,   1);  // 1 x Rs.69   = Rs.69
        order2.addItem(shake,   1);  // 1 x Rs.99   = Rs.99
        // Food Total = Rs.297 → delivery = 2.0 km x Rs.10 = Rs.20

        order2.calculateTotal();
        order2.applyDeliveryCharge();
        order2.displayOrderSummary();
    }
}