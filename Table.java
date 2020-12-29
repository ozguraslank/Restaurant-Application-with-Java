
public class Table
{
    private int tableId;
    private boolean tableSituation; // Is it empty(true) or full(false)?

    // Constructor and Getter Setter part
    public Table(int tableId, boolean tableSituation) {
        this.tableId = tableId;
        this.tableSituation = tableSituation;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public boolean getTableSituation() {
        return tableSituation;
    }

    public void setTableSituation(boolean tableSituation) {
        this.tableSituation = tableSituation;
    }
}
