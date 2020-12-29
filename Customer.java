
public class Customer
{
    private String name;
    private String surname;
    private int customerTableId;          // The table id that the customer sits


    public int askForTable(int theAnswer) // we will transmit waiter's checkTable function's result here.
    {
        return theAnswer;
    }

    public int askTheBill(Cashier cashier, Bill bill)     // We will transmit cashier's computeBill function's result here.
    {
        return cashier.computeBill(bill);

    }

    // Constructor and Getter Setter part
    public Customer(String name, String surname, int customerTableId) {
        this.name = name;
        this.surname = surname;
        this.customerTableId = customerTableId;
    }

    public Customer(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
        this.customerTableId = 0;   // We will declare this after we take the customer to tableX
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getCustomerTableId() {
        return customerTableId;
    }

    public void setCustomerTableId(int customerTableId) {
        this.customerTableId = customerTableId;
    }
}
