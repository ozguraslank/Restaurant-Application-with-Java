import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *@author OzgurAslan
 *
*/

public class Main
{
    static int menuCounter = 0;                            // We will display the menu to customer one by one, thats why we need counter for arrayList

    public static void showMenu(String[][] menu) {
        for (int i = menuCounter; i < menu.length; i++) {
            for (int j = 0; j < menu[i].length; j++) {
                System.out.print(menu[i][j]);
            }
            System.out.println();
            menuCounter++;                                 // We showed first part of menu, increase the counter
            break;                                         // as i mentioned above, we will show it's each part by one by which means when we call it -->
        }                                                  // --> in the main, so let's break the loop to avoid showing all parts of menu
    }

    public static void clearIt()                           // This function will provide us to clear the console and get rid of
    {                                                      // chat garbages
        for(int i = 0; i < 10;i ++)
        {
            System.out.print("\n");
        }
    }


    public static void sleep() throws InterruptedException // Sleep function with animation.
    {
        try {
            System.out.print("Loading.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println();
        }

        catch (InterruptedException ex)                    // To catch the InterruptedException error
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {

        // ******* DECLARING PART START *******
        Database database = new Database();                  // Declaring the restaurant variables
        Waiter waiter = new Waiter("John", "Reese");
        Cashier cashier = new Cashier("Joss", "Carter");
        Scanner scanner = new Scanner(System.in);
        int decision;                                       // We will ask something(Like press 1 to .....)
        int theTableIdofCostumer = 0;                       // we will look for a desk for customer, the answer will be != 0 if table found -->
                                                            // --> if couldn't found, it will stay like = 0
        // ******* DECLARING PART END *******

        while (true)
        {
            System.out.println("***********Ozgur Restaurant**********\n*\t\t\t\t\t\t\t\t\t*\n*\tPress 1 to ask a empty table\t*\n*\tPress 2 to quit\t\t\t\t\t*\n*\t\t\t\t\t\t\t\t\t*\n* ********************************* *");
            decision = scanner.nextInt();

            if (decision == 2)                                        // If the customer wants to leave the restaurant
            {
                System.out.println("Thanks for visiting us!");
                break;
            }

            else if (decision == 1)
            {
                String customerName;
                String customerSurname;
                scanner.nextLine();
                System.out.println("Please enter your name and surname by one by: ");
                System.out.print("Name: ");
                customerName = scanner.nextLine();
                System.out.print("Surname: ");
                customerSurname = scanner.nextLine();
                Customer customer = new Customer(customerName, customerSurname);               // Creating a new Customer object
                System.out.println("Alright, let me check for a empty table please wait");
                sleep();
                theTableIdofCostumer = customer.askForTable(waiter.checkTable(database));      // Waiter will check a table for the customer

                if (theTableIdofCostumer != 0)
                {
                    System.out.println("There is a table for you sir. Please go to Table " + theTableIdofCostumer + "\nYou can press 1 if you want me to bring the menu(Press 0 to leave restaurant): ");
                    customer.setCustomerTableId(theTableIdofCostumer);  // We took the customer to tableX, so let's declare customer's tableId
                    decision = scanner.nextInt();

                    if (decision == 0)                                  // If the customer wants to leave the restaurant
                    {
                        System.out.println("Have a good day!");
                        sleep();
                        break;
                    }

                    else if (decision == 1)
                    {
                        ArrayList<Object> orders = new ArrayList<Object>();       // We will keep the order name and order price in this array list -->
                                                                                  // --> it's a object array list because order name is String and  -->
                                                                                  // --> order price is int, so they are different types

                        String[][] theMenu = waiter.bringMenu(database);          // Bringing the menu

                        for (int i = 0; i < theMenu.length; i++)                  // In this part, we will take orders of each food table -->
                        {                                                         // --> Which means 4 orders, but if the customer doesn't wants -->
                            showMenu(theMenu);                                    // to order something from food tableX, he/she will press 0

                            System.out.print("Your order? (Press 0 to not to order anything for this part): ");
                            decision = scanner.nextInt();

                            if (decision == 0)
                            {
                                continue;
                            }

                            else if (decision == 1 || decision == 2 || decision == 3)  // In this part, we will find the order that customer decided from the database -->
                            {                                                          // --> if the customer entries invalid number like 4, 5 etc. We will ask the order again -->
                                                                                       // --> because we have only 3 meals for each table which are #1, #2, #3
                                int foodPrice = 0;                        // the order's price
                                String theOrder = theMenu[i][decision];   // the order (it contains order name, order price and \t \n stuffs) -->
                                                                          // --> we will get rid of the \t \n stuffs and find the order name and order price

                                char[] ch = new char[theOrder.length()];  // a new char array because the meal that in the database is a String
                                String orderName = "";                   // We will find the order name and transmit here


                                for (int d = 0; d < theOrder.indexOf('\t'); d++)  // Finding the order's name by checking and adding every char until \t
                                {
                                    orderName += theOrder.charAt(d);              // Adding the each char to orderName
                                }

                                orders.add(orderName);                            // Let's add the orderName to ArrayList

                                // ****FINDING THE ORDER'S PRICE PART START****
                                String orderPrice = "";                           // The order is in String form in database and the price as well -->
                                                                                  // So we will take the price's characters by one by and finally, -->
                                                                                  // We will convert this String to int

                                int beginIndex = theOrder.indexOf('$');   // In this part, we will find the order's price, so let's start to check from '$'
                                int j = 0;                                // Will be used as a counter in the following loop

                                for (int b = beginIndex; b < theOrder.length(); b++) // The String's characters between $ and last index
                                {
                                    ch[j] = theOrder.charAt(b);
                                    j++;
                                }

                                int lastIndex = String.valueOf(ch).indexOf('\t');    // We will find the index of second \t index
                                beginIndex = String.valueOf(ch).indexOf('$');        // declaring the index again, but for new ch array
                                j = 0;                                               // Will be used as a counter in the following loop

                                for (int c = beginIndex + 1; c < lastIndex; c++)
                                {
                                    orderPrice += String.valueOf(ch).charAt(c);      // Finding the numbers (the price)
                                    j++;

                                }

                                // ****FINDING THE ORDER'S PRICE PART END****

                                foodPrice = Integer.parseInt(orderPrice);             // Converting the String to int
                                orders.add(foodPrice);                                // Adding to Array list
                            }

                            else
                            {
                                System.out.println("Please enter a valid number!");
                                i--;                // We will say "continue" so the variable i will increase by 1, so if there are 2 more meal tables, it will show 1 meal table instead.
                                                    // --> so we should decrase the variable i by 1 to avoid this.
                                menuCounter--;      // There is same logic here as well. We increased the menuCounter by 1 when we display a meal table, and we want to display -->
                                                    // --> the same menu table, so let's decrase menuCounter variable by 1.
                                sleep();
                                clearIt();
                                continue;
                            }

                        }

                        System.out.println("Okay sir, i am bringing your meal, please wait.");
                        sleep();
                        System.out.println("Enjoy your meal!");
                        System.out.print("Please press 1 to ask for bill: ");  // When the customer finishes his/her meal, he/she will ask the bill -->
                        int decision2 = scanner.nextInt();                     // --> by pressing to 1

                        int totalPrice = 0;                       // We will transmit the total price of orders to here.
                        Bill bill = new Bill(database, orders);   // Let's create the bill object
                        clearIt();                                // Let's clear the console to get rid of garbage chat

                        if (decision2 == 1)                       // Showing the bill
                        {
                            System.out.println("\t\t\t  THE BILL");
                            System.out.println("------------------------------------");
                            totalPrice = customer.askTheBill(cashier, bill);
                            System.out.println("------------------------------------\nTotal Price: $" + totalPrice);
                        }

                        else                                      // Even the customer doesn't press to 1, he/she will pay it. No run from the bill!
                        {
                            System.out.println("Please pay the bill\n\n");
                            System.out.println("\t\tTHE BILL\t\t");
                            System.out.println("------------------------------------");
                            totalPrice = customer.askTheBill(cashier, bill);
                            System.out.println("------------------------------------\nTotal Price: $" + totalPrice);
                        }

                        System.out.println("Press 1 to pay it cash, Press 2 to pay it with credit card: ");   // Payment options
                        decision2 = scanner.nextInt();
                        if (decision2 == 1)
                        {
                            System.out.println("Thanks! Have a good day!");
                        }

                        else
                        {
                            System.out.println("Please enter your credit card's password");
                            decision2 = scanner.nextInt();                                                    // For better simulation(it won't do anything.)
                            System.out.println("Thanks! Have a good day!");
                        }

                        database.getTables().get(theTableIdofCostumer).setTableSituation(true);               // The customer has left, so table is empty now.
                        break;

                    }

                    else       // If the customer press to invalid number
                    {
                        System.out.println("Invalid operation! You are going back to menu");
                        sleep();
                        clearIt();
                        continue;
                    }
                }
                else    // If the all tables are full
                {
                    System.out.println("Unfortunately, there is no empty table, please wait in queue for empty table. You are going back to menu...");
                    clearIt();
                    continue;
                }

            }

            else       // If the customer entries invalid operation
            {
                System.out.println("Invalid operation! You are going back to menu");
                sleep();
                clearIt();
                continue;
            }

        }
    }

}
