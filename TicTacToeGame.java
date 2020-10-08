 import java.util.*;

public class TicTacToeGame 
{
    public static String user = "", computer ="";
    String board[] = new String[10];
    int boardFlag[] = new int[10];
    String option = "";

    //UC1
    public void createBoard()
    {
        for(int i = 0; i < board.length; i++)
		{
            board[i] = "";
            boardFlag[i] = 00;
		}
    }

    //UC2
    public void chooseOption(String player)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter option user chooses to play X/O:");
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

        System.out.println("User plays with symbol : " + user);
        System.out.println("Computer plays with symbol : " + computer);
    }

    //UC3
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

    //UC4 UC5
    void makeMove(String input)
    {
        Scanner scanner = new Scanner(System.in);
        int index = 0, flag = 0;
       
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
                        boardFlag[index-1] = 1 ;
                    }
                    else
                    {
                        System.out.println("Index filled");
                        flag = 1;
                    }
                }

            }while(flag == 1);        
    }

    //UC6
    int choosingToss()
    {
        int options=1 + (int)(Math.random() * ((2 - 1) + 1));
        return options;
    }

    //UC7
    int gameResult()
    {
        int flagresult = 0;
        int flag = 0;

        
            //if((board[0]+board[4]+board[8]).equals("XXX") || (board[0]+board[4]+board[8]).equals("OOO"))
            if(board[0].equals(board[4]) && board[0].equals(board[8]) && (board[0].equals("X") || board[0].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //elseif((board[2]+board[4]+board[6]).equals("XXX") || (board[2]+board[4]+board[6]).equals("OOO"))
            else if(board[2].equals(board[4]) && board[2].equals(board[6]) && (board[2].equals("X") || board[2].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //if((board[0]+board[1]+board[2]).equals("XXX") || (board[0]+board[1]+board[2]).equals("OOO"))
            else if(board[0].equals(board[1]) && board[0].equals(board[2]) && (board[0].equals("X") || board[0].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //if((board[3]+board[4]+board[5]).equals("XXX") || (board[3]+board[4]+board[5]).equals("OOO"))
            else if(board[3].equals(board[4]) && board[3].equals(board[5]) && (board[3].equals("X") || board[3].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //elseif((board[6]+board[7]+board[8]).equals("XXX") || (board[6]+board[7]+board[8]).equals("OOO"))
            else if(board[6].equals(board[7]) && board[6].equals(board[8]) && (board[6].equals("X") || board[6].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //elseif((board[0]+board[3]+board[6]).equals("XXX") || (board[0]+board[3]+board[6]).equals("OOO"))
            else if(board[0].equals(board[3]) && board[0].equals(board[6]) && (board[0].equals("X") || board[0].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //if((board[1]+board[4]+board[7]).equals("XXX") || (board[1]+board[4]+board[7]).equals("OOO"))
            else if(board[1].equals(board[4]) && board[1].equals(board[7]) && (board[1].equals("X") || board[1].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            }
            //elseif((board[2]+board[5]+board[8]).equals("XXX") || (board[2]+board[4]+board[8]).equals("OOO"))
            else if(board[2].equals(board[5]) && board[2].equals(board[8]) && (board[2].equals("X") || board[2].equals("O")))
            {
                flagresult = 1;
                return flagresult;
            } 
            else
            {
                for(int i = 0; i < boardFlag.length ; i++)
                {
                    flagresult =0;

                    if(boardFlag[i] == 1)
                    {
                        flagresult = 2;
                    }
                }
            }

        return flagresult;
    }

    void game(String player)
    {
        TicTacToeGame gameObject = new TicTacToeGame();
        int gameresult, count = 0;
        String currentPlayer = "";

        gameObject.createBoard();
        gameObject.chooseOption(player);

        do
        {   
            if(player == "User")
            {
                if(count % 2 == 0)
                {
                    currentPlayer = "User";
                }
                else
                {
                    currentPlayer = "Computer";
                }
                count++;
            }

            if(player == "Computer")
            {
                if(count % 2 == 0)
                {
                    currentPlayer = "Computer";
                }
                else
                {
                    currentPlayer = "User";
                }
                count++;
            }

            System.out.println(currentPlayer + " playing");
            //System.out.println(user+"----"+computer);
            if(currentPlayer == "User")
            {
                gameObject.makeMove(user);
            }
            
            if(currentPlayer == "Computer")
            {
                gameObject.makeMove(computer);
            }

            gameObject.showBoard();
            gameresult = gameObject.gameResult();
            
            System.out.println("RESULT:"+gameresult);
            if(gameresult == 1)
            {
                System.out.println(currentPlayer+" wins");
            }
            if(gameresult == 2)
            {
                System.out.println("Tie match");
            }

        }while(gameresult!= 1 && gameresult!=2);
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
            System.out.println("User starts Game");
            gameObject.game("User");
        }
        if(toss ==2 )
        {
            System.out.println("Computer starts Game");
            gameObject.game("Computer");
        }

        //gameObject.gameresult("User");
        /*
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
        }while(choice>=1 && choice<=4);*/
	}

}