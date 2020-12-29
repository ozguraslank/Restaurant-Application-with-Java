
public class Menu
{
    private String[][] theMenu;

    public Menu(String[][] theMenu) {
        this.theMenu = theMenu;
    }

    public Menu(Database database)
    {
        this.theMenu = database.getMenu();
    }

    public String[][] getTheMenu() {
        return theMenu;
    }

    public void setTheMenu(String[][] theMenu) {
        this.theMenu = theMenu;
    }
}
