
public class Waiter extends Employee
{

    public Waiter(String name, String surname)
    {
        super(name, surname);
    }
    public int checkTable(Database database)                          // In this function, we will check for a empty table.
    {
        int tableId;                                                  // We will return this value, if there is no empty table, we will return 0
                                                                      // If there is, we will return the tableId
        for(int i = 0; i < database.getTables().size(); i++)
        {
            Table theTable = database.getTables().get(i);             // Check each table of restaurant
            if (theTable.getTableSituation() == true)                 // search for a empty table
            {
                database.getTables().get(i).setTableSituation(false); // We arranged this table for the customer, so the situation of the table -->
                tableId = database.getTables().get(i).getTableId();   // --> will be full(false)
                return tableId;
            }
        }
        tableId = 0;                                                  // If there is no empty table for the customer.
        return tableId;
    }

    public String[][] bringMenu(Database database)                    // Take the menu from database and take it to customer
    {
        return database.getMenu();

    }

}
