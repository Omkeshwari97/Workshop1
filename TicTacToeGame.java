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

    public String chooseOption()
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

        return user;
    }

    void showBoard()
    {
        for(int i = 1; i < 10 ; i++)
        {
            System.out.print(board[i-1] + "|");
            if(i % 3 == 0)
            {
                System.out.println();
                System.out.println("----");
            }
        }
    }

    void makeMove(String input)
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
            else
            {
                if(board[index-1].equals(""))
                {
                    board[index-1] = input;
                }
                else
                {
                    System.out.println("Index filled");
                    flag = 1;
                }
            }

        }while(flag == 1);        
    }


	public static void main(String[] args) 
	{
        TicTacToeGame gameObject = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("1. createBoard");
            System.out.println("2. show board");
            System.out.println("3. make move");
            System.out.println("Enter choice:");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1: gameObject.createBoard();
                        break;
                case 2: gameObject.showBoard();
                        break;
                case 3: String input = gameObject.chooseOption();
                        gameObject.makeMove(input);
                        break;
            }
        }while(choice>=1 && choice<=4);
	}

}