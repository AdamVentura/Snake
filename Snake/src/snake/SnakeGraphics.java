package src;

import java.awt.*;
import javax.swing.*;
import java.util.*;



public class SnakeGraphics extends JPanel {

	    private static final long serialVersionUID = 7148504528835036003L;
	    
	    private int board[][];
		private int snakelength,playerheadx, playerheady, death,applex, appley, playerdirection;
		private char moveinput;
		private int x, y, z, q, a;
		
		
		
		ArrayList<Integer> snaketailx=new <Integer>ArrayList();
		ArrayList<Integer> snaketaily=new <Integer>ArrayList();
		

		
		
		
		

	    // Runs whenever something needs to be painted
	    public void paintComponent(Graphics g) {
	    	
	    	// Declare variables
	    	int iCountRows, iCountColumns, iAlternate = 0, iXLocation = 0, iYLocation = 0, iRowEvenOrOdd = 0, iColumnEvenOrOdd, iProduct;
	    	
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
		        
		        
		        }
	        }
	        	}
	
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
	    		
	    		applex=7;
	    		appley=5;
	    		playerdirection=4;
	    								
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
	    		board[applex][appley]=3;
	    		if(board[playerheadx][playerheady]==3)
	    		{
	    			
	    			snaketailx.add(snaketailx.get(snakelength-1));
	    			snaketaily.add(snaketaily.get(snakelength-1));
	    			snakelength++;	    			
	    			generateapple();	    				    
	    		}
	    		
	    		
	    		//set the player head location to 2
	    		board[playerheadx][playerheady]=2;
	    		//return the varable death to let main know it died
	    		
	    		
	    		return death;
	    	}

	    	
	    public void generateapple()
	    	{
	    		do
	    		{
	    			Random dice = new Random();
	    			appley = 0;
	    			applex = 0;
	    			
	    	         	appley = dice.nextInt(10);
	    			applex = dice.nextInt(10);
	    					
	    			
	    		}while(board[applex][appley]!=0);
	    		
	    		
	    	}
	    	
	    	
	    	
	    	
	    public void move()
	    	{
	    		//take in an input of WASD
	    		
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
	    		//check for each of the movement inputs
	    		if(playerdirection==1)
	    		{
	    			if(playerheady+1<10)
	    			{			
	    				playerheady++;
	    			}
	    			else
	    				
	    				death=1;
	    		}
	    		if(playerdirection==3)
	    		{
	    			if(playerheady-1>=0)
	    			{				
	    				playerheady--;
	    		
	    			}
	    			else
	    				death=1;
	    		}
	    		if(playerdirection==2)
	    		{
	    			if(playerheadx-1>=0)
	    			{								
	    			playerheadx--;
	    			}
	    			else
	    				death=1;
	    		}
	    		if(playerdirection==4)
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

	    
	    public static void main(String[] args) throws InterruptedException 
{
	    	// Creates panel object of Snake class
	    	SnakeGraphics panel = new SnakeGraphics();
			int death=0;
			    // Creates a JFrame object
	            JFrame frame = new JFrame("Snake");
	            // Sets the size of the window
	            frame.setSize(506, 532);
	            // Exit application when window is closed
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            // Center pane
	            frame.getContentPane().add(panel, BorderLayout.CENTER);
	            // Make frame visible
	            frame.setVisible(true);
				
			while(death==0)
				{
				Thread.sleep(1000);
			death=panel.updateboard();
			panel.printboard();
			panel.move();
	       
	    }
	    }

	    
	    
}
