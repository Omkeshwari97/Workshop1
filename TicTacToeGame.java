 import java.util.*;

public class TicTacToeGame 
{
    String board[] = new String[10];
    String user, computer;
    String option = "";

    public void createBoard()
    {
        for(int i = 0; i < board.length; i++)
		{
			board[i] = "";
		}
    }

    public void chooseOption()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter option X/O:");
        option = scanner.next();

        if(option.equals("X") || option.equals("O"))
        {
            switch (option) 
            {
                    case "X":   user = "X";
                                computer = "O";
                                break;
                    
                    case "O":   user = "O";
                                computer = "X";
                                break;            
            }
        }
        else
        {
                System.out.println("Invalid Input");
        }

    }

    void showBoard()
    {
        for(int i = 1; i < 10 ; i++)
        {
            System.out.print(board[i] + "|");
            if(i % 3 == 0)
            {
                System.out.println();
            }
        }
    }

    void makeMove()
    {
        Scanner scanner = new Scanner(System.in);
        int index = 0, flag = 0;

        do
        {
            flag = 0;

            System.out.println("Enter Index from 1 to 9:");
            index = scanner.nextInt();

            if(index<1 || index>9)
            {
                flag = 1;
                System.out.println("Index out of range");
            }
        }while(flag == 1);


        if(board[index-1].equals(""))
        {
            board[index-1] = option;
        }
        else
        {
            System.out.println("Index filled");
        }
        
    }


	public static void main(String[] args) 
	{
        TicTacToeGame gameObject = new TicTacToeGame();
        gameObject.createBoard();
        gameObject.chooseOption();
        gameObject.showBoard();
        gameObject.makeMove();
	}

}