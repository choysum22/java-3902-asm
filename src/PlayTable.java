public class PlayTable {
    private int tableHeight;
    private int tableWidth;

    // check table height
    public boolean checkTableHeight() {
        // minimum height = 4, maximum height = 10
        if (tableHeight < 4 || tableHeight > 10) {
            System.out.println("Table height should be between 4-10.");
            System.out.println("Try again");
            return true;
        }
        return false;
    }

    // check table width
    public boolean checkTableWidth(){
        // minimum width = 5, maximum width = 10
        if(tableWidth<5 || tableWidth>10){
            System.out.println("Table width should be between 5-10.");
            System.out.println("Try again.");
            return true;
        }
        return false;
    }

    // check if column is full
    public boolean isColumnFull(int[] inputCount,int input){
        if(inputCount[input]>=tableHeight){
            System.out.println("Column " + input + " is full.");
            System.out.println("Try another column.");
            return true;
        }
        return false;
    }

    // check if input is valid
    public boolean isInputValid(int input){
        if(input >= tableWidth || input < 0) {
            System.out.println("\nInvalid input.");
            System.out.println("Please input between 0-" +(tableWidth-1) + ".\n" );
            return true;
        }
        return false;
    }

    // setter
    public void setHeight(int tableHeight) {
        this.tableHeight = tableHeight;
    }

    public void setWidth(int tableWidth) {
        this.tableWidth = tableWidth;
    }
}
