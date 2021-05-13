package snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.ArrayList;

class SnakeLogic /**implements KeyListener**/{
	private int board[][];
	private int snakelength,playerheadx, playerheady, death;
	private char moveinput;
	private int x, y, z;
	
	
	ArrayList<Integer> snaketailx=new <Integer>ArrayList();
	ArrayList<Integer> snaketaily=new <Integer>ArrayList();
	

	
	
	Scanner reader=new Scanner(System.in);
	
	public SnakeLogic()
	{
		board=new int [10][10];
		playerheadx=3;
		playerheady=5;
		death=0;
		//starting snake lenght
		snakelength=3;
		//make the origanal tail of the snake
		snaketailx.add(3);
		snaketaily.add(5);
		snaketailx.add(2);
		snaketaily.add(5);
		snaketailx.add(1);
		snaketaily.add(5);
								
	}
	
	//print out the board array
	public void printboard()
	{
		//make the for loops looke like this so that x and y can ack like a standard cordinate plain.
		for(y=9;y>=0;y--)
		{
			System.out.println();
			for(x=0;x<10;x++)
			{
				System.out.print(board[x][y]+" ");
			}
		}
	}
	
	//update the board array
	public int updateboard()
	{
		//for each spot
		for(y=9;y>=0;y--)
		{
			for(x=0;x<10;x++)
			{
				//set it back to zero to start
				board[x][y]=0;	
			}
		}
		//for each the entire lenght of the snake
		for(z=0;z< snaketailx.size(); z++)
				{
			//set the the spots that have snake tails to 1
					board[snaketailx.get(z)][snaketaily.get(z)]=1;
					
					
				}
		//set the player head location to 2
		board[playerheadx][playerheady]=2;
		//return the varable death to let main know it died
		return death;
	}
	
	
	public void move()
	{
		//take in an input of WASD
		char moveinput = reader.next().charAt(0);
		//set z to the last spot of the snake tail array
		z=snakelength-1;
		//while it is 1 or greater
		while(z>0)
		{
			//set the snake tail cords to the next snake tails cords
			snaketailx.set(z, snaketailx.get(z-1));
			snaketaily.set(z, snaketaily.get(z-1));
			
			//get closer to the head by 1
			z--;
		}
		//cheack for each of the movment inputs
		if(moveinput=='w')
		{
			if(playerheady+1<10)
			{			
				playerheady++;
			}
			else
				
				death=1;
		}
		if(moveinput=='s')
		{
			if(playerheady-1>=0)
			{				
				playerheady--;
		
			}
			else
				death=1;
		}
		if(moveinput=='a')
		{
			if(playerheadx-1>=0)
			{								
			playerheadx--;
			}
			else
				death=1;
		}
		if(moveinput=='d')
		{
			if(playerheadx+1<10)
			{				
			playerheadx++;		
			}
			else
				death=1;
		}
		snaketaily.set(0, playerheady);
		snaketailx.set(0, playerheadx);
		
		
	}


	
	
	
	
	/**
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		int key = arg0.getKeyCode();
		
		if(key==KeyEvent.VK_W){
			playerheady++;
			
			
		}
		if(key==KeyEvent.VK_S){
			playerheady--;
			
		}
		
		if(key==KeyEvent.VK_A){
			playerheadx--;
			
		}
		if(key==KeyEvent.VK_D){
			playerheadx++;
			
		}
	}

	



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

**/
}
