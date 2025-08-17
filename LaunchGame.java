import java.util.Random;
import java.util.Scanner;

class TicTacToe
{
    static char[][] board;
    
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
    static void displayBoard(){
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
    static void placeMark(int row, int col, char mark){
        if(row >=0 && row <=2 && col >=0 && col <=2)
            board[row][col] = mark;
        else
            System.out.println("Invalid Position");
    }
    static boolean checkColWin(){
        for(int j=0; j<=2; j++){
            if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]){
                return true;
            }
     }
        return false;  
    }
    static boolean checkRowWin(){
        //1 direct chack by tracking index
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
    static boolean checkDiagWin(){
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
    static boolean isDraw(){
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                if(board[i][j] == ' '){
                    return false; // if any cell is empty, it's not a draw  
                }
            }
        }
        return true; // if all cells are filled, it's a draw
    }
}
abstract class Player{
    String name;
    char mark;
    
    abstract void makeMove();

    boolean isValidMove(int row, int col){
        if(row >= 0 && row <= 2 && 
               col >=0 && col <= 2){
            if(TicTacToe.board[row][col] == ' '){
                return true;
            } else {
                System.out.println("Position already occupied.");
                return false;
            }
        }
        return false;
    }

}
class HumanPlayer extends Player
{
    // HumanPlayer is a subclass of Player
    // It inherits the properties and methods of Player

    public HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        int row;
        int col;
       Scanner scan = new Scanner(System.in);
       
       do {
            System.out.println(name + ", enter your move (row and column): ");
            row = scan.nextInt();
            col = scan.nextInt();
        } while (!isValidMove(row, col));
        // Place the mark on the board
        TicTacToe.placeMark(row, col, mark);
        System.out.println(name + " placed " + mark + " at (" + row + ", " + col + ")");

        
    }
}
class AIPlayer extends Player{


    public AIPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        int row;
        int col;
       Scanner scan = new Scanner(System.in);
       do{
         Random r = new Random();
         row = r.nextInt(3);
         col = r.nextInt(3);
       }while (!isValidMove(row, col));
        // Place the mark on the board
        TicTacToe.placeMark(row, col, mark);
        System.out.println(name + " placed " + mark + " at (" + row + ", " + col + ")");

        
    }
}



public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        //new HumanPlayer("Priyenka", 'O').makeMove(); // by anonymous object
        HumanPlayer h1 = new HumanPlayer("Husain", 'X');
        AIPlayer Ai = new AIPlayer("robo", 'O');
        Player cp ;
        cp = h1;

        while (true) {
           System.out.println("Current Player turn: " + cp.name + " with mark: " + cp.mark);
        cp.makeMove();
        TicTacToe.displayBoard();
        if (TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) {
            TicTacToe.displayBoard();
            System.out.println("Game Over! " + cp.name + " wins!"); 
            break;           
        }else if(TicTacToe.isDraw()){
          TicTacToe.displayBoard();
          System.out.println("Game Over! It's a draw!");
          break;
        }else{
          cp = (cp == h1) ? Ai : h1;
        }
    }

        // for(int i=0; i<9; i++){
        //     TicTacToe.displayBoard();
        //     if(i % 2 == 0){
        //         h1.makeMove();
        //     } else {
        //         Ai.makeMove();
        //     }
        //     if(TicTacToe.checkRowWin() || TicTacToe.checkColWin() || TicTacToe.checkDiagWin()){
        //         TicTacToe.displayBoard();
        //         System.out.println("Game Over! " + (i % 2 == 0 ? h1.name : Ai.name) + " wins!");
        //         return;
        //     }else if(TicTacToe.isDraw()){
        //             TicTacToe.displayBoard();
        //             System.out.println("Game Over! It's a draw!");
        //             return;
        //         }  
            
        // }
    }
}
 