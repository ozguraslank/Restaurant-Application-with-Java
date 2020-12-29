import java.util.ArrayList;

public class Database
{
    private int tableAmount = 7;                  // Assume that the restaurant has 7 tables.
    private int emptyTableAmount = 5;             // In the Database() part, i will declare 2 tables as full, so emptyTableAmount should be= 7 - 2 = 5
    private int billNo = 1;                       // We will keep the bills amount, working hour didn't start yet so it will be 1.
    private String[][] menu;                      // We will fill the menu in constructor part.
    private ArrayList<Table> tables;              // We will declare each table as object. I declared tables variable as Table ArrayList ->
                                                  // -> Because we will keep table objects in here.

    // Constructor and Getter Setter part
    public Database(int tableAmount, int emptyTableAmount, int billNo, String[][] menu, ArrayList<Table> tables) {
        this.tableAmount = tableAmount;
        this.emptyTableAmount = emptyTableAmount;
        this.billNo = billNo;
        this.menu = menu;
        this.tables = tables;
    }

    public Database()    // We will call the database as database() in the main class, so let's declare it's variables here.
    {
        this.tableAmount = 7;
        this.emptyTableAmount = 5;
        this.billNo = 1;
        this.menu = new String[][]         // Filling the menu
        {
                {"--------------Starters--------------\n", "Tomato soup:\t\t$5\t\t#1\n", "Caesar salad:\t\t$8\t\t#2\n", "Fish Sandwich:\t\t$5\t\t#3\n"},
                {"--------------Main Course-----------\n", "Meatballs:\t\t\t$19\t\t#1\n", "Turkish kebab:\t\t$22\t\t#2\n", "Perch fish:\t\t\t$20\t\t#3\n"},
                {"--------------Desserts--------------\n", "Baklava:\t\t\t$6\t\t#1\n", "Tiramisu:\t\t\t$8\t\t#2\n", "Waffle:\t\t\t\t$8\t\t#3\n"},
                {"--------------Drinks----------------\n", "Tea:\t\t\t\t$3\t\t#1\n", "Coffee:\t\t\t\t$5\t\t#2\n", "Coca Cola:\t\t\t$4\t\t#3\n"}
        };

        int[] tablesId = {1,2,3,4,5,6,7};                                   // We have 7 tables
        boolean[] tablesSituation = {true,false,true,true,true,true,false}; // Assume that some tables are full(false).
        ArrayList<Table> theTables = new ArrayList<Table>();                // Let's declare each table as object and add them in theTables

        for(int i = 0; i < tablesId.length; i++)
        {
            Table newTable = new Table(tablesId[i], tablesSituation[i]);    // Create a new table object
            theTables.add(newTable);                                        // Add the new table object into Table ArrayList
        }
        this.tables = theTables;

    }

    public int getTableAmount() {
        return tableAmount;
    }

    public void setTableAmount(int tableAmount) {
        this.tableAmount = tableAmount;
    }

    public int getEmptyTableAmount() {
        return emptyTableAmount;
    }

    public void setEmptyTableAmount(int emptyTableAmount) {
        this.emptyTableAmount = emptyTableAmount;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public String[][] getMenu() {
        return menu;
    }

    public void setMenu(String[][] menu) {
        this.menu = menu;
    }

    public ArrayList<Table> getTables()
    {
        return tables;
    }

    public void setTables(ArrayList<Table> tables)
    {
        this.tables = tables;
    }
}
