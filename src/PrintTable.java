public class PrintTable {
    // print table
    public void print(int tableHeight, int tableWidth, String[][] printTable){
        for (int i = tableHeight-1; i >= 0; i--) {
            System.out.print(" " + i + " |");
            for (int j = 0; j < tableWidth; j++)
                System.out.print(printTable[i][j]+"|");
            System.out.println();
        }
        System.out.print("   +");
        for (int k = 0; k < tableWidth; k++)
            System.out.print("-+");
        System.out.print("\n   ");
        for (int k = 0; k < tableWidth; k++)
            System.out.print(" " + k);
        System.out.println();
    }
}
