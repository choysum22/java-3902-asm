/*
 *Filename      : FourInALine
 *Programmer    : CHOY Ming San
 *StudentId     : 200216545
 *Class         : IT114105/1C
 *Description   : Two players race to connect 4 tokens in a row to win the game
 *Input         : Table width, table height, column of next token
 *Output        : Gameplay of four in a row printed on table
 *History
 *      30/10/2020 new today
 *      31/10/2020 debug - win condition
 *      01/11/2020 made a better print table
 *      02/11/2020 debug - print table
 *      11/11/2020 debug
 *      29/11/2020 improve table size check
 */

import java.util.*;

public class FourInALine {
    static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        String kbInput;
        int input;
        int player = 1;     // player id
        WinCondition winCon = new WinCondition();
        PlayTable table = new PlayTable();
        PrintTable prTable = new PrintTable();

        do {
            // prompt height and width input
            System.out.print("Enter height of the table (4-10):");
            int tableHeight = kb.nextInt();
            table.setHeight(tableHeight);
            // check table height
            if (table.checkTableHeight())
                continue;

            System.out.print("Enter width of the table (5-10):");
            int tableWidth = kb.nextInt();
            table.setWidth(tableWidth);
            // check table width
            if (table.checkTableWidth())
                continue;

            System.out.println();

            int[][] playTable = new int[tableHeight][tableWidth];
            int moves = tableWidth * tableHeight;
            int[] inputCount = new int[tableWidth];

            // initialize print table
            String[][] printTable = new String[tableHeight][tableWidth];
            for (int i = 0; i < tableHeight; i++) {
                for (int j = 0; j < tableWidth; j++)
                    printTable[i][j] = " ";
            }

            while (true) {
                // player's move
                kbInput = promptPlayerInput(tableWidth, player);

                // quit game
                if (kbInput.equals("X") || kbInput.equals("x")) {
                    if (playAgain()) {
                        break;
                    } else
                        return;
                }
                input = Integer.parseInt(kbInput);

                // check input
                if (table.isInputValid(input))
                    continue;

                // column full
                if (table.isColumnFull(inputCount, input))
                    continue;

                // input table
                playTable[inputCount[input]][input] = player;
                if (player == 1) {
                    printTable[inputCount[input]][input] = "O";
                } else if (player == 2) {
                    printTable[inputCount[input]][input] = "X";
                }
                inputCount[input]++;
                prTable.print(tableHeight, tableWidth, printTable);

                // check win condition
                if (winCon.WinCondition(tableHeight, tableWidth, playTable, player)) {
                    System.out.println("Player " + player + " won.");
                    if (playAgain()) {
                        break;
                    } else
                        return;
                }

                // alternate between players
                if (player == 2)
                    player = 1;
                else
                    player++;

                // check remaining moves
                --moves;
                if (moves == 0) {
                    System.out.println("Draw.");
                    System.out.println("Play again? 'Y' or 'N':");
                    if (playAgain()) {
                        break;
                    } else
                        return;
                }
            }
        } while (true);
    }

    // play again
    public static boolean playAgain() {
        while (true) {
            System.out.println("\nPlay again? 'Y' or 'N':");
            String goAgain = kb.next();
            if (goAgain.equals("Y") || goAgain.equals("y"))
                return true;
            else if (goAgain.equals("N") || goAgain.equals("n")) {
                System.out.println("Bye Bye!");
                return false;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    // playerId
    public static String promptPlayerInput(int tableWidth, int player) {
        System.out.print("Player " + player + " type a column (0-" +
                (tableWidth - 1) + ") or type 'x' to quit current game:");
        String kbInput = kb.next();
        return kbInput;
    }
}
