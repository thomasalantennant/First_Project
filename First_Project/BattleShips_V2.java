import java.util.Scanner;

public class BattleShips_V2
{

	int[][][] board = new int[12][12][2];
	int[][] winner = new int[1][2];
	static int gameover = 0;
	int x=0;
	int y=0;
	int z=0;
	Scanner scanner = new Scanner (System.in);

	public static void main(String[] args)
	{
		BattleShips_V2 game1= new BattleShips_V2();
		game1.setupboard();
		game1.placeships(); 
		do{
			game1.shooting();
		}while(gameover == 0);
		game1.scanner.close();
		
	}

	/** Intialises the board and sets all values to "0" which is an empty space in game **/
	public void setupboard()
	{
		for(int i = 0; i<2; i++)
		{
			for(int j = 0; j<12; j++)
			{
				for(int k = 0; k<12; k++)
				{
					board[k][j][i]=0;
/*					System.out.println(k+" "+j+" "+i+" = "+board[k][j][i]); */
				}
			}
		}
	}
	/** placing ship by collect start position and direction **/
	public void placeships()
	{
		int counter=1, size=0, shipId=0;
		int xstart, ystart, direction, end, permanentend, currentposition;
		int check, check2, check3, successdeploy;
		int player=0;

		
		do{
			check2 = 0;
			check3 = 0;
			successdeploy = 0;
			do{
				check = 0;
				System.out.println("Please enter the X coordinate (0-11) for the start of ship "+counter);
				xstart = scanner.nextInt();
				if(xstart < 12 && xstart >-1)
				{
					check = 1;
				}else{
					check = 0;
				}
				if(check == 0)
				{
					System.out.println("That is not a position on the board");
				}
			}while(check == 0);
			do{
				check = 0;
				System.out.println("Please enter the Y coordinate (0-11) for the start of ship "+counter);
				ystart = scanner.nextInt();
				if(ystart < 12 && ystart >-1)
				{
					check = 1;
				}else{
					check = 0;
				}
				if(check == 0)
				{
					System.out.println("That is not a position on the board");
				}
			}while(check == 0);
			do{
				check = 0;
				System.out.println("Do you what the ship "+counter+" to face up(1), down(2), left(3), or right(4)");
				direction = scanner.nextInt();

				if(direction > 0 && direction < 5)
				{
					check = 1;
				}else{
					check = 0;
				}
			}while(check == 0);
			/** sets values of the ship to be used **/
			switch(counter)
			{
			case 1:
				size=1;
				shipId=10;
				break;
			case 2:
				size=1;
				shipId=20;
				break;
			case 3:
				size=2;
				shipId=30;
				break;
			case 4:
				size=2;
				shipId=40;
				break;
			case 5:
				size=2;
				shipId=50;
				break;
			case 6:
				size=3;
				shipId=60;
				break;
			case 7:
				size=4;
				shipId=70;
				break;
			}

			switch(direction)
			{
			case 1:
				end = ystart-size;
				permanentend = xstart;
				if(end < 12 && end >-1)
				{
					check2 = 1;
				}
				if(check2 == 1)
				{
					currentposition = ystart;
					do{
						if(board[permanentend][currentposition][player] != 0)
						{
							check3 = 1;
						}
						currentposition--;
					}while(currentposition >= end && check3 != 1);
					if(check3 == 0)
					{
						currentposition = ystart;
						do{
							board[permanentend][currentposition][player] = shipId;
							currentposition--;
							successdeploy = 1;
						}while(currentposition >= end);
					}
				}
				break;
			case 2:
				end = ystart+size;
				permanentend = xstart;
				if(end < 12 && end >-1)
				{
					check2 = 1;
				}
				if(check2 == 1)
				{
					currentposition = ystart;
					do{
						if(board[permanentend][currentposition][player] != 0)
						{
							check3 = 1;
						}
						currentposition++;
					}while(currentposition <= end && check3 != 1);
					if(check3 == 0)
					{
						currentposition = ystart;
						do{
							board[permanentend][currentposition][player] = shipId;
							currentposition++;
							successdeploy = 1;
						}while(currentposition <= end);
					}
				}
				break;
			case 3:
				end = xstart-size;
				permanentend = ystart;
				if(end < 12 && end >-1)
				{
					check2 = 1;
				}
				if(check2 == 1)
				{
					currentposition = xstart;
					do{
						if(board[currentposition][permanentend][player] != 0)
						{
							check3 = 1;
						}
						currentposition--;
					}while(currentposition >= end && check3 != 1);
					if(check3 == 0)
					{
						currentposition = xstart;
						do{
							board[currentposition][permanentend][player] = shipId;
							currentposition--;
							successdeploy = 1;
						}while(currentposition >= end);
					}
				}
				break;
			case 4:
				end = xstart+size;
				permanentend = ystart;
				if(end < 12 && end >-1)
				{
					check2 = 1;
				}
				if(check2 == 1)
				{
					currentposition = xstart;
					do{
						if(board[currentposition][permanentend][player] != 0)
						{
							check3 = 1;
						}
						currentposition++;
					}while(currentposition <= end && check3 != 1);
					if(check3 == 0)
					{
						currentposition = xstart;
						do{
							board[currentposition][permanentend][player] = shipId;
							currentposition++;
							successdeploy = 1;
						}while(currentposition <= end);
					}
				}
				break;
			}

			if(check2 == 0)
			{
				System.out.println("there is not enough space there");
			}
			if(check3 == 1)
			{
				System.out.println("there is a ship already there");
			}
			if(successdeploy == 1)
			{
				counter++;
			}

/*
			for(int i = 0; i<1; i++)
			{
				for(int j = 0; j<12; j++)
				{
					for(int k = 0; k<12; k++)
					{
						System.out.println(k+" "+j+" "+i+" = "+board[k][j][i]);
					}
				}
			}
*/
		}while(counter < 8);
		

	}
	
	public void shooting()
	{
		int hit=0;
		int xhit=-1, yhit=-1, check=0;
		int player=0;
		
		

		do{
			check = 0;
			hit = 0;
	
			do{
				check = 0;
				System.out.println("Please enter the X coordinate (0-11) of target location");
				xhit = scanner.nextInt();
				if(xhit < 12 && xhit >-1)
				{
					check = 1;
				}else{
					check = 0;
				}
				if(check == 0)
				{
					System.out.println("That is not a position on the board");
				}
			}while(check == 0);
			do{
				check = 0;
				System.out.println("Please enter the Y coordinate (0-11) of target location");
				yhit = scanner.nextInt();
				if(yhit < 12 && yhit >-1)
				{
					check = 1;
				}else{
					check = 0;
				}
				if(check == 0)
				{
					System.out.println("That is not a position on the board");
				}
			}while(check == 0);
			if(board[xhit][yhit][player] == 1)
			{
				System.out.println("you have already missed there, try again");
				hit=1;
			}
			if(board[xhit][yhit][player] != 0 && board[xhit][yhit][player]/10 != 0 && board[xhit][yhit][player]%10 != 0)
			{
				System.out.println("you have already hit there, try again");
				hit=1;
			}
			if(board[xhit][yhit][player] == 0)
			{
				board[xhit][yhit][player] = 1;
				System.out.println("you have missed");
			}
			if(board[xhit][yhit][player] != 0 && board[xhit][yhit][player]/10 != 0 && board[xhit][yhit][player]%10 == 0)
					{
						board[xhit][yhit][player] = board[xhit][yhit][player] + 6;
						System.out.println("HIT!!!");
						hit=1;
						 winner[0][player] = winner[0][player]++;
						 if(winner[0][player] == 22)
						 {
							 System.out.println("WINNER!!!");
							 gameover = 1;
						 }else{
							 System.out.println("fire again!!!");
						 }
					}
		}while(hit == 1);
		
	}

}





