package snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.ArrayList;

class SnakeLogic /**implements KeyListener**/{
	private int board[][];
	private int snakelength,playerheadx, playerheady, death;
	private char moveinput;
	private int x, y;
	
	
	ArrayList<Integer> snaketailx=new <Integer>ArrayList();
	ArrayList<Integer> snaketaily=new <Integer>ArrayList();
	

	
	
	Scanner reader=new Scanner(System.in);
	
	public SnakeLogic()
	{
		board=new int [10][10];
		playerheadx=2;
		playerheady=5;
		death=0;
		
		snakelength=3;
		snaketailx.add(0, )
	}
	
	
	public void printboard()
	{
		board[playerheadx][playerheady]=1;
		for(y=9;y>=0;y--)
		{
			System.out.println();
			for(x=0;x<10;x++)
			{
				System.out.print(board[x][y]+" ");
			}
		}
	}
	
	
	public int updateboard()
	{
		for(y=9;y>=0;y--)
		{
			for(x=0;x<10;x++)
			{
				board[x][y]=0;
				if(playerheadx==x&&playerheady==y)
				{
					board[x][y]=1;
				}
			}
		}
		return death;
		
		
	}
	
	
	public void move()
	{
		char moveinput = reader.next().charAt(0);
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