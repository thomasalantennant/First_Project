import java.util.*;

public class BattleShips_V1 
{

	int[][][] board =new int[12][12][2];
	int x=0;
	int y=0;
	int z=0;
	
	public static void main(String[] args)
	{
		BattleShips_V1 game1= new BattleShips_V1(); 
		game1.setupboard();
	}	

	/** Intializes the board and sets all values to "0" which is an empty space in game **/
	public void setupboard()
	{
		for(int i = 0; i<2; i++)
		{
			for(int j = 0; j<12; j++)
			{
				for(int k = 0; k<12; k++)
				{
					board[k][j][i]=0;
					System.out.println(k+" "+j+" "+i+" = "+board[k][j][i]);
				}
			}
		}
	}
	
	public void placeships()
	{
		int counter=1, size, shipId;
		int xstart, ystart, xend, yend;
		int direction, checkspace, currentposition;
		int player=0;
		
		Scanner scanner = new Scanner (System.in);
		do{
			checkspace = 0;
			System.out.println("Please enter the X coordinate (0-11) for the start of ship "+counter);
			xstart = scanner.nextInt();
			if(xstart < 12 && xstart >-1)
				{
				checkspace = 1;
				}else{
					checkspace = 0;
				}
		}while(checkspace == 0);
		do{
			checkspace = 0;
			System.out.println("Please enter the Y coordinate (0-11) for the start of ship "+counter);
			ystart = scanner.nextInt();
			if(ystart < 12 && ystart >-1)
				{
				checkspace = 1;
				}else{
					checkspace = 0;
				}
		}while(checkspace == 0);	
		do{
			checkspace = 0;
			System.out.println("Do you what the ship "+counter+" to face up(1), down(2), left(3), or right(4)");
			direction = scanner.nextInt();
			
			if(xstart < 12 && xstart >-1)
				{
				checkspace = 1;
				}else{
					checkspace = 0;
				}
		}while(checkspace == 0);
		if(counter == 1)
		{
			size=2;
			shipId=10;
		}
		if(counter == 2)
		{
			size=2;
			shipId=20;
		}
		if(counter == 3)
		{
			size=3;
			shipId=30;
		}
		if(counter == 4)
		{
			size=3;
			shipId=40;
		}
		if(counter == 5)
		{
			size=3;
			shipId=50;
		}
		if(counter == 6)
		{
			size=4;
			shipId=60;
		}
		if(counter == 7)
		{
			size=5;
			shipId=70;
		}
		
		
		for(int i = 0; currentposition == xstart+size; currentposition++)
		{
			if(board[xstart][ystart][player] ==0)
			{
				
			}
			
			
			
			
			
			for(int j = 0; j<12; j++)
			{
				for(int k = 0; k<12; k++)
				{
					board[k][j][i]=0;
					System.out.println(k+" "+j+" "+i+" = "+board[k][j][i]);
				}
			}
		}
		System.out.println("there is not enough space there");
			
		scanner.close();
		
	}
}






