 import java.util.*;

public class TicTacToeGame 
{
    String board[] = new String[10];
    int boardFlag[] = new int[10];
    String user = "1", computer ="2";
    String option = "";

    public void createBoard()
    {
        for(int i = 0; i < board.length; i++)
		{
            board[i] = "";
            boardFlag[i] = 0;
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
            System.out.print(board[i-1] + " |");
            if(i % 3 == 0)
            {
                System.out.println();
                System.out.println("----");
            }
        }
    }

    int makeMove(String input)
    {
        Scanner scanner = new Scanner(System.in);
        int index = 0, flag = 0, flagFull = 1;

        for(int i = 0; i < boardFlag.length; i++)
        {
            if(boardFlag[i] == 0)
            {
                flagFull = 0;
            }
        }

        if(flagFull == 1)
        {
            return 1;
        }
        else
        {
            do
            {
                flag = 0;

                System.out.println("Enter Index from 1 to 9:");
                index = scanner.nextInt();

                if(index < 1 || index > 9)
                {
                    flag = 1;
                    System.out.println("Index out of range");
                }
                else
                {
                    if(board[index-1].equals(""))
                    {
                        board[index-1] = input;
                        boardFlag[index-1] = 1;
                    }
                    else
                    {
                        System.out.println("Index filled");
                        flag = 1;
                    }
                }

            }while(flag == 1);        
        }

        return 0;
    }

    int choosingToss()
    {
        int options=1 + (int)(Math.random() * ((2 - 1) + 1));
        return int;
    }

	public static void main(String[] args) 
	{
        TicTacToeGame gameObject = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);
        int choice, full;

        gameObject.createBoard();
        int toss = gameObject.choosingToss();
        if(toss == 1)
        {
            System.out.println("User first");
        }
        if(toss ==2 )
        {
            System.out.println("Computer First");
        }

        do
        {
            System.out.println("1. show board");
            System.out.println("2. make move");
            System.out.println("Enter choice:");
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1: gameObject.showBoard();
                        break;
                case 2: String input = gameObject.chooseOption();
                        full = gameObject.makeMove(input);
                        if(full == 1)
                        {
                            System.out.println("game over");
                            return;
                        }
                        break;
            }
        }while(choice>=1 && choice<=4);
	}

}