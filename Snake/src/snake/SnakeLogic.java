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
		//for each
		for(y=9;y>=0;y--)
		{
			for(x=0;x<10;x++)
			{
				board[x][y]=0;
				for(z=0;z< snaketailx.size(); z++)
				{
					board[snaketailx.get(z)][snaketaily.get(z)]=1;
					
					
				}
			
				
			}
		}
		for(y=9;y>=0;y--)
		{
			for(x=0;x<10;x++)
			{
		if(playerheadx==x&&playerheady==y)
				{
					board[x][y]=2;
				}
		
		
			}
		}
		return death;
	}
	
	
	public void move()
	{
		char moveinput = reader.next().charAt(0);
		
		z=snakelength-1;
		while(z>0)
		{
			snaketailx.set(z, snaketailx.get(z-1));
			snaketaily.set(z, snaketaily.get(z-1));
			
			z--;
		}
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
