class TicTacToe
{
    char[][] board;
    
    public TicTacToe()
    {
        board = new char[3][3];
        initBoard();
    }

    void initBoard(){
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                board[row][col] = ' ';
            }
        }
    }
    void displayBoard(){
            System.out.println("-------------");
           for(int i=0; i<board.length; i++){
            System.out.print("| ");
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    void placeMark(int row, int col, char mark){
        if(row >=0 && row <=2 && col >=0 && col <=2)
            board[row][col] = mark;
        else
            System.out.println("Invalid Position");
    }
     boolean checkColWin(){
        for(int j=0; j<=2; j++){
            if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]){
                return true;
            }
     }
        return false;  
    }
    boolean checkRowWin(){
        //1direct chack by tracking index
        // if(board[0][0] == board[0][1] && board[0][1] == board[0][2] ||
        //         board[1][0] == board[1][1] && board[1][1] == board[1][2]||
        //         board[2][0] == board[2][1] && board[2][1] == board[2][2]){
        //             return true;
        //         }
        //         return false;
        // 2 by for loop
        for(int i=0; i<=2; i++){
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        return false;
    }
    boolean checkDiagWin(){
        // board[0][0] != ' ' && is for that it not shpuld be empty becaous if it is
        // all (row, col. diag) empty then it will sow true to avoid we check this first
        if(board[0][0] != ' ' && board[0][0] == board[1][1]
           && board[1][1] == board[2][2]
           || board[0][2] != ' ' && board[0][2] == board[1][1]
           && board[1][1] == board [2][0]){
            return true;
           }else{
            return false;
           }
    }
}
public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.displayBoard();
        
        t.placeMark(0, 2, 'X');
        t.placeMark(0, 1, 'O');
        t.placeMark(2, 2, 'X');
        t.placeMark(1, 1, 'X');
        t.placeMark(2, 1, 'O');
        t.placeMark(1, 2, 'X');
        t.placeMark(0, 0, 'O');
        t.placeMark(2, 0, 'X');
        t.placeMark(1, 0, 'O');
        

        t.displayBoard();
        System.out.println(t.checkColWin());
        System.out.println(t.checkRowWin());
        System.out.println(t.checkDiagWin());
    }
}
 