package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.util.*;



public class SnakeGraphics extends JPanel implements KeyListener
{

	    private static final long serialVersionUID = 7148504528835036003L;
	    
	    private int board[][];
		private int snakelength,playerheadx, playerheady, death,applex, appley, playerdirection;
		private char moveinput;
		private int x, y, z, q, a;
		
		
		
		ArrayList<Integer> snaketailx=new <Integer>ArrayList();
		ArrayList<Integer> snaketaily=new <Integer>ArrayList();
		

		
		//constructor
		 public SnakeGraphics()
	    	{
	    		board=new int [10][10];
	    		playerheadx=3;
	    		playerheady=5;
	    		death=0;
	    		//starting snake length
	    		snakelength=3;
	    		//make the origanal tail of the snake
	    		snaketailx.add(3);
	    		snaketaily.add(5);
	    		snaketailx.add(2);
	    		snaketaily.add(5);
	    		snaketailx.add(1);
	    		snaketaily.add(5);
	    		
	    		//make the origanal apple location
	    		applex=7;
	    		appley=5;
	    		//start the player movinf right
	    		playerdirection=4;
	    								
	    	}
		

	    // Runs whenever something needs to be painted, does all of the grpahics
	    public void paintComponent(Graphics g) {
	    	
	    	// Declare variables
	    	int iCountRows, iCountColumns, iXLocation = 0, iYLocation = 0, iRowEvenOrOdd = 0, iColumnEvenOrOdd, iProduct;
	    	
	        super.paintComponent(g);
	        
	        // Use for loop to print tiles
	        for (iCountRows = 0; iCountRows <= 9; iCountRows += 1) {
	        	// Multiply the count by 50 to determine coordinates for each row
		        iXLocation = iCountRows * 50;
		        iYLocation = iCountRows * 50;
		        for(iCountColumns = 0; iCountColumns <= 9; iCountColumns += 1) {
		        	// Use a nested for loop to modify the x to print each row
		        	iXLocation = iCountColumns * 50;
		        	
		        	// Based on whether the row is even or odd assign it a negative or positive value 
		        	if (iCountRows % 2 == 0) {
		        		iRowEvenOrOdd = 1;
		        	}
		        	else {
		        		iRowEvenOrOdd = -1;
		        	}
		        	
		        	// Based on whether the row is even or odd assign it a negative or positive value 
		        	if (iCountColumns % 2 == 0) {
		        		iColumnEvenOrOdd = 1;
		        	}
		        	else {
		        		iColumnEvenOrOdd = -1;
		        	}
		        	
		        	// Multiply the column number by the row
		        	iProduct = iColumnEvenOrOdd * iRowEvenOrOdd;
		        	
		        	// Based on the product of the column and row, set the color
		        	if (iProduct == -1) {
		        	g.setColor(Color.GREEN.darker());
		        	}
		        	else {
		        	g.setColor(Color.GREEN);
		        	}
		        	if (board[iCountColumns][iCountRows]==1)
		        	{
		        		g.setColor(Color.blue);
		        		
		        		
		        		
		        	}
		        
		        // Fills each rectangle with the set color at the specified location
		        g.fillRect(iXLocation, iYLocation, 50, 50);
				
		        if (board[iCountColumns][iCountRows] == 2) {
		        	g.setColor(Color.blue);
		        	g.fillOval(iXLocation, iYLocation, 50, 50);
		        }
		        if (board[iCountColumns][iCountRows] == 3) {
		        	g.setColor(Color.red);
		        	g.fillOval(iXLocation + 10, iYLocation + 10, 30, 30);
		        }
		        
		        }
	        }
	        	}
	    
	    //print out the board array in the console for trouble shooting
	    public void printboard()
	    	{
	    		//make the for loops looke like this so that x and y can ack like a standard cordinate plain.
	    		for(y=9;y>=0;y--)
	    		{
	    			System.out.println();
	    			for(x=0;x<10;x++)
	    			{
	    				//print out the number in that spot
	    				System.out.print(board[x][y]+" ");
	    			}
	    		}
	    		//go to the next line
	    		System.out.println();
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
	    		//set the position with th aplle to 3
	    		board[applex][appley]=3;
	    		//if hte player head is over an aplle
	    		if(board[playerheadx][playerheady]==3)
	    		{
	    			//add a another tail spot that is equal to the last spot of the exsisting tail
	    			snaketailx.add(snaketailx.get(snakelength-1));
	    			snaketaily.add(snaketaily.get(snakelength-1));
	    			//add 1 to the lenght varable
	    			snakelength++;	
	    			//generate a new apple
	    			generateapple();	    				    
	    		}
	    		
	    		
	    		//set the player head location to 2
	    		board[playerheadx][playerheady]=2;
	    		//return the varable death to let main know if it has died
	    		
	    		
	    		return death;
	    	}

	    	//generate an apple somewhere
	    public void generateapple()
	    	{
	    	//always do al least once
	    		do
	    		{
	    			
	    			Random dice = new Random();
	    			//initiailze
	    			appley = 0;
	    			applex = 0;
	    			//generate a random number from 0-9
	    	         	appley = dice.nextInt(10);
	    			applex = dice.nextInt(10);
	    					
	    			//keep generateing untill the apple is made in an open place on the board
	    		}while(board[applex][appley]!=0);
	    		
	    		
	    	}
	    	
	    	
	    	
	    	//moves the player and their tail
	    public void move()
	    	{
	    		
	    		
	    		//set z to the last spot of the snake tail array
	    		z=snakelength-1;
	    		//while it is 1 or greater
	    		while(z>0)
	    		{
	    			//set the snake tail's cords to the next snake tail's cords
	    			snaketailx.set(z, snaketailx.get(z-1));
	    			snaketaily.set(z, snaketaily.get(z-1));
	    			
	    			//get closer to the head by 1
	    			z--;
	    		}
	    		//check each player direction, up=1. left=2, down=3, right=4
	    		//up
	    		if(playerdirection==1)
	    		{
	    			//for each if first check if the player head will still be on the borad
	    			//and also check that the head will not be on top of the tail
	    			//if either of these happen done move and set death to 1
	    			if(playerheady+1<10&&board[playerheadx][playerheady+1]!=1)
	    			{			
	    				playerheady++;
	    			}
	    			else
	    				
	    				death=1;
	    		}
	    		
	    		//down
	    		if(playerdirection==3)
	    		{
	    			if(playerheady-1>=0&&board[playerheadx][playerheady-1]!=1)
	    			{				
	    				playerheady--;    		
	    			}
	    			else
	    				death=1;
	    		}
	    		
	    		//left
	    		if(playerdirection==2)
	    		{
	    			if(playerheadx-1>=0&&board[playerheadx-1][playerheady]!=1)
	    			{								
	    			playerheadx--;
	    			}
	    			else
	    				death=1;
	    		}
	    		
	    		//right
	    		if(playerdirection==4)
	    		{
	    			if(playerheadx+1<10&&board[playerheadx+1][playerheady]!=1)
	    			{				
	    			playerheadx++;		
	    			}
	    			else
	    				death=1;
	    		}
	    		//move the first spot of the tail to the new snake head location
	    		snaketaily.set(0, playerheady);
	    		snaketailx.set(0, playerheadx);
	        }

	    //change the direction that the player is moving
	    @Override
		public void keyPressed(KeyEvent arg0)
		{
			int key = arg0.getKeyCode();
			
			if(key==KeyEvent.VK_W){
				playerdirection=1;
				
				
			}
			if(key==KeyEvent.VK_S){
				playerdirection=3;
				
			}
			
			if(key==KeyEvent.VK_A){
				playerdirection=2;
				
			}
			if(key==KeyEvent.VK_D){
				playerdirection=4;
				
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
	    
	    
	    //main
	    public static void main(String[] args) throws InterruptedException 
{
	    	// Creates panel object of Snake class
	    	SnakeGraphics panel = new SnakeGraphics();
			int death=0;
			    JFrame frame = new JFrame("Snake");
			while(death==0)
				{  
			// Creates a JFrame object
	            
	            // Sets the size of the window
	            frame.setSize(506, 532);
	         	 
	            
	            // Exit application when window is closed
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            // Center pane
	            frame.getContentPane().add(panel, BorderLayout.CENTER);
	            // Make frame visible
	            frame.setVisible(true);
				
		
				Thread.sleep(1000);
				death=panel.updateboard();
				panel.printboard();
				panel.move();
	       
				}
}

	    
	    
}
