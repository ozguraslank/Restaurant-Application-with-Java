public class Cashier extends Employee
{
    public Cashier(String name, String surname) {
        super(name, surname);
    }

    public int computeBill(Bill bill)                        // This function will calculate the bill's price
    {
        int totalPrice = 0;
        for(int i = 0; i < bill.getOrders().size(); i++)
        {
            if (i == (bill.getOrders().size() - 1))          // To avoid OutofIndex error
            {
                break;
            }

            // Taking each order and the order's price from the bill
            System.out.print((String)bill.getOrders().get(i));                      // Order name
            System.out.println("\t\t\t$" + (Integer)bill.getOrders().get(i+1));     // Order price
            totalPrice += (Integer)bill.getOrders().get(i+1);                       // add the price to sum
            i++;
        }
        return totalPrice;
    }

}
