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
           System.out.print(" "+board[i-1] + " |");
           if(i % 3 == 0)
           {
               System.out.println();
               System.out.println("----------");
           }
       }
   }

   //UC4 UC5
   String[] makeMove(String input, int winPosition)
   {
       Scanner scanner = new Scanner(System.in);
       int index = 0, flag = 0, compflag = 0;// pos = 1;
      
           do
           {
               flag = 0;

               //user turn
               if(winPosition == 0)
               {
                   System.out.println("Enter Index from 1 to 9:");
                   index = scanner.nextInt();
               }
               else
               {
            	   index = winPosition;
            	   
                   //computer turn
            	   if(compflag == 1)
            	   {
            		   int pos = 1 + (int)(Math.random() * ((9 - 1) + 1));
            		   index = pos;
            		   System.out.println("Computer Random Move: "+index);
            	   }            	   
                   
               }

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
                       compflag = 1;
                   }
               }

               //System.out.println("flag: "+flag);
           }while(flag == 1);        

           return board;
   }

   //UC6
   int choosingToss()
   {
       int options=1 + (int)(Math.random() * ((2 - 1) + 1));
       return options;
   }

   //UC7
   int gameResult(String board[])
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
               for(int i = 0; i < 9 ; i++)
               {
                   //System.out.println(i+1+"--"+boardFlag[i]+"--"+board[i]);
                   if(boardFlag[i] == 1)
                   {
                       flag = flag +1;
                   }

                   if(flag == 9)
                   {
                       return 2;
                   }
               }     
           }

       return flagresult;
   }

   //UC8
   int checkComputerWin()
   {
       String copyofBoard[] = board.clone();

       for(int i=0; i<9 ;i++)
       {
           if(copyofBoard[i].equals(""))
           {
               copyofBoard[i] = computer;

               if(gameResult(copyofBoard) == 1)
               {
                   return i;
               }
               else
               {
                   copyofBoard[i] = "";
               }
           }
       }
       return -1;
   }
   
   //UC9
   int blockUserPosition()
   {
	   String copyofBoard[] = board.clone();

       for(int i=0; i<9 ;i++)
       {
           if(copyofBoard[i].equals(""))
           {
               copyofBoard[i] = user;

               if(gameResult(copyofBoard) == 1)
               {
                   return i;
               }
               else
               {
                   copyofBoard[i] = "";
               }
           }
       }
       return -1;
   }

   //UC10
   int availableCorners()
   {
	   String copyofBoard[] = board.clone();

       if(copyofBoard[0].equals(""))
       {
    	   return 0;
       }
       if(copyofBoard[2].equals(""))
       {
    	   return 2;
       }
       if(copyofBoard[6].equals(""))
       {
    	   return 6;
       }
       if(copyofBoard[8].equals(""))
       {
    	   return 8;
       }
       
       return -1;   
   }
   
   //UC11
   int availableCentre()
   {
	   String copyofBoard[] = board.clone();

       if(copyofBoard[4].equals(""))
       {
    	   return 4;
       }
       
       return -1;
   }
   
   void game(String player)
   {
       TicTacToeGame gameObject = new TicTacToeGame();
       int gameresult, count = 0;
       String currentPlayer = "";
       String board1[] = null;

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
               board1 = gameObject.makeMove(user, 0);
           }
           
           if(currentPlayer == "Computer")
           {
               int winPosition = gameObject.checkComputerWin();
               
               if(winPosition == -1)
               {
            	   int blockPosition = gameObject.blockUserPosition();
            	   
            	   if(blockPosition == -1)
            	   {
            		   int cornerPosition = gameObject.availableCorners();
            		   if(cornerPosition == -1)
            		   {
            			   int centrePosition = gameObject.availableCentre();
            			   
            			   if(centrePosition == -1)
            			   {
            				   int options = 1 + (int)(Math.random() * ((9 - 1) + 1));
    		                   System.out.println("Computer Random Move: " + options);
    		                   board1 = gameObject.makeMove(computer, options);   
            			   }
            			   else
            			   {
            				   System.out.println("Computer Centre Move: " + (centrePosition+1));
        	                   board1 = gameObject.makeMove(computer, centrePosition+1);
            			   }
            		   }
            		   else
            		   {
            			   System.out.println("Computer Corner Move: " + (cornerPosition+1));
    	                   board1 = gameObject.makeMove(computer, cornerPosition+1);
            		   }
            	   }
            	   else
            	   {
            		   System.out.println("Computer Block Move: " + (blockPosition+1));
	                   board1 = gameObject.makeMove(computer, blockPosition+1);
            	   }
               }
               else
               {
                   System.out.println("Computer Win Position move: " + (winPosition+1));
                   board1 = gameObject.makeMove(computer, winPosition+1);              
               }
           }

           gameObject.showBoard();
           gameresult = gameObject.gameResult(board1);
           
           //System.out.println("RESULT:"+gameresult);
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
	}

}
