 import java.util.*;

public class TicTacToeGame 
{
    String board[] = new String[10];
    String user, computer;

    public void createBoard()
    {
        for(int i = 0; i < board.length; i++)
		{
			board[i] = "";
		}
    }

    /*public void chooseOption()
    {
        Scanner scanner = new Scanner(System.in);
        String option = "";

        do
        {
            System.out.println("Enter option X/O:");
            option = scanner.next();

            if(option == "X" && option == "O")
            {
                switch (option) 
                {
                    case "X":   user = "X";
                                computer = "O";
                                break;
                
                    case "O":   user = "O";
                                computer = "X";
                                break;            
                    
                    default:    System.out.println("Invalid Input"); 
                }
            }

        }while(option =="X" || option =="O");
    }

    void showBoard()
    {
        for(int i = 0; i < board.length ; i++)
        {
            System.out.println("Position: " + i +" : " + board[i]);
        }
    }*/


	public static void main(String[] args) 
	{
        TicTacToeGame gameObject = new TicTacToeGame();
        gameObject.createBoard();
       // gameObject.chooseOption();
       // gameObject.showBoard();
	}

}