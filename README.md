# Java-Project
🍕 Online Food Delivery System
A Java console application simulating a real-world food ordering platform using Object-Oriented Programming (OOP) principles.
📋 Table of Contents
About the Project
Features
Class Structure
Getting Started
Sample Output
Delivery Charge Logic
Project Structure
Technologies Used
Author
📖 About the Project
This project simulates an Online Food Delivery System where multiple restaurants can list their food items with prices. Users can browse menus, add items to an order with quantities, and receive a fully calculated bill — including item subtotals, delivery charges, and taxes.
Built as part of the Object-Oriented Programming with Java curriculum to demonstrate real-world application of OOP concepts like encapsulation, object composition, and method-driven logic.
✨ Features
🏪 Multiple restaurants with individual menus
🍔 Browse food items by name, category, and price
🛒 Add multiple items with quantities to a single order
💰 Auto-calculates subtotal per item
🚗 Smart delivery charge logic (free above ₹500, else ₹10/km)
🧾 5% tax applied on food total
📄 Complete formatted order summary / bill
🏗️ Class Structure
OnlineFoodDeliverySystem
│
├── FoodItem
│   ├── name : String
│   ├── price : double
│   ├── category : String
│   ├── getName()
│   ├── getPrice()
│   ├── getCategory()
│   └── displayItem()
│
├── Restaurant
│   ├── name : String
│   ├── location : String
│   ├── distanceKm : double
│   ├── menu[] : FoodItem
│   ├── addFoodItem(item)
│   └── displayMenu()
│
├── Order
│   ├── restaurant : Restaurant
│   ├── orderedItems[] : FoodItem
│   ├── quantities[] : int
│   ├── subtotals[] : double
│   ├── addItem(item, qty)
│   ├── calculateTotal()
│   ├── applyDeliveryCharge()
│   └── displayOrderSummary()
│
└── OnlineFoodDeliverySystem (Main)
    └── main()
🚀 Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
Any terminal / command prompt
Installation & Run
1. Clone the repository
git clone https://github.com/your-username/online-food-delivery-system.git
cd online-food-delivery-system
2. Compile
javac OnlineFoodDeliverySystem.java
3. Run
java OnlineFoodDeliverySystem
🖥️ Sample Output
╔══════════════════════════════════════════╗
║    ONLINE FOOD DELIVERY SYSTEM           ║
╚══════════════════════════════════════════╝

=== Menu: PizzaHub | Location: MG Road ===
  Item                      Category        Price
  --------------------------------------------------
  Margherita Pizza          Main Course     Rs.199.00
  Pepperoni Pizza           Main Course     Rs.249.00
  Garlic Bread              Starter         Rs.89.00
  Cold Coffee               Beverage        Rs.79.00
  Choco Lava Cake           Dessert         Rs.129.00

--- Placing Order from PizzaHub ---
  Added: 2x Margherita Pizza  =>  Rs.398.00
  Added: 1x Garlic Bread      =>  Rs.89.00
  Added: 2x Cold Coffee       =>  Rs.158.00
  Added: 1x Choco Lava Cake   =>  Rs.129.00

==============================================
              ORDER SUMMARY
==============================================
  Restaurant : PizzaHub
  Location   : MG Road  (4.5 km away)
==============================================
  Item                    Qty      Subtotal
  ----------------------------------------
  Margherita Pizza           2  Rs.398.00
  Garlic Bread               1  Rs. 89.00
  Cold Coffee                2  Rs.158.00
  Choco Lava Cake            1  Rs.129.00
  ----------------------------------------
  Food Total                  Rs.774.00
  Delivery Charge             Rs.  0.00
  Tax (5%)                    Rs. 38.70
==============================================
  GRAND TOTAL                 Rs.812.70
==============================================
  ✓ Free delivery applied (order above Rs.500)
🚗 Delivery Charge Logic
Condition
Delivery Charge
Food Total ≥ ₹500
✅ Free
Food Total < ₹500
₹10 × distance (km)
Example: Order of ₹297 from a restaurant 2 km away → Delivery = ₹10 × 2 = ₹20
📁 Project Structure
online-food-delivery-system/
│
├── OnlineFoodDeliverySystem.java   # All classes + Main driver
├── README.md                       # Project documentation
└── Report/
    └── OnlineFoodDeliverySystem_Report.pdf
🛠️ Technologies Used
Language: Java (JDK 8+)
Paradigm: Object-Oriented Programming (OOP)
Concepts Used: Encapsulation, Object Composition, Array-based Storage, Method Design
👤 Author
[Your Name]
📧 your.email@example.com
🔗 GitHub Profile
📄 License
This project is open source and available under the MIT License.
⭐ If you found this helpful, give it a star!
