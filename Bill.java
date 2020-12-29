import java.util.ArrayList;

public class Bill
{
    private int no;
    private ArrayList<Object> orders;  // We will keep orders and their prices here

    // Constructor and Getter Setter part
    public Bill(int no, int price)
    {
        this.no = no;
        this.orders = orders;
    }

    public Bill(Database database, ArrayList<Object> theOrders)     // we will generate the bill from database and will add the each meal and the meal's price
    {                                                               // into TheOrders that customer ordered, through using Object ArrayList in main, then
        this.no = database.getBillNo();                             // we will transmit the info in this.orders
        this.orders = theOrders;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ArrayList<Object> getOrders()
    {
        return orders;
    }

    public void setOrders(ArrayList<Object> orders)
    {
        this.orders = orders;
    }

}
