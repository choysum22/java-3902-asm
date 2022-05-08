public class WinCondition {
    public boolean WinCondition(int tableHeight, int tableWidth,
                                int[][] pTable, int player){
        // check horizontal
        for(int h = 0;h < tableHeight;h++){
            for(int w = 0;w < tableWidth-3;w++){
                if(pTable[h][w]==player && pTable[h][w+1]==player &&
                        pTable[h][w+2]==player && pTable[h][w+3]==player)
                    return true;
            }
        }

        // check vertical
        for(int w = 0;w < tableWidth;w++){
            for(int h = 0;h < tableHeight-3;h++){
                if(pTable[h][w]==player && pTable[h+1][w]==player &&
                        pTable[h+2][w]==player && pTable[h+3][w]==player)
                    return true;
            }
        }

        // check left ascending diagonal
        for(int w = 3;w < tableWidth;w++){
            for(int h = 0;h < tableHeight-3;h++){
                if(pTable[h][w]==player && pTable[h+1][w-1]==player &&
                        pTable[h+2][w-2]==player && pTable[h+3][w-3]==player)
                    return true;
            }
        }

        // check left descending diagonal
        for(int w = 0;w < tableWidth-3;w++){
            for(int h = tableHeight-1;h >= 3;h--){
                if(pTable[h][w]==player && pTable[h-1][w+1]==player &&
                        pTable[h-2][w+2]==player && pTable[h-3][w+3]==player)
                    return true;
            }
        }

        // check right ascending diagonal
        for(int w = 3;w < tableWidth;w++){
            for(int h = tableHeight-1;h > tableHeight-3;h--){
                if(pTable[h][w]==player && pTable[h-1][w-1]==player &&
                        pTable[h-2][w-2]==player && pTable[h-3][w-3]==player)
                    return true;
            }
        }

        // check right descending diagonal
        for(int w = 0;w < tableWidth-3;w++){
            for(int h = 0;h < tableHeight-3;h++){
                if(pTable[h][w]==player && pTable[h+1][w+1]==player &&
                        pTable[h+2][w+2]==player && pTable[h+3][w+3]==player)
                    return true;
            }
        }
        return false;
    }
}
