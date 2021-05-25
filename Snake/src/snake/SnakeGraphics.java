package src;

import java.awt.*;
import javax.swing.*;
import java.util.*;


public class SnakeGraphics extends JPanel 
{
	    private static final long serialVersionUID = 1L;	    
	    private int board[][];
		private int snakelength,playerheadx, playerheady, death,applex, appley;
		String snakelengthstring;
		private int x, y, z;
		//make instance of the keylistener class
		player player=new player();		
		ArrayList<Integer> snaketailx=new <Integer>ArrayList<Integer>();		
		ArrayList<Integer> snaketaily=new <Integer>ArrayList<Integer>();	
		
		//constructor
		 public SnakeGraphics() throws InterruptedException
	    	{
			 //add these to make the keylistener work
			 addKeyListener(player);
			 setFocusable(true);
		     requestFocusInWindow();
		     //make the array 10 by 10 for the board
	    		board=new int [10][10];
	    		//set the starting spot for th player head
	    		playerheadx=3;
	    		playerheady=5;
	    		//make death start at 0[alive]
	    		death=0;
	    		//starting snake length
	    		snakelength=3;
	    		//make the original tail of the snake	    		
	    		snaketailx.add(3);
	    		snaketaily.add(5);
	    		snaketailx.add(2);
	    		snaketaily.add(5);
	    		snaketailx.add(1);
	    		snaketaily.add(5);
	    		//make the original apple location
	    		applex=7;
	    		appley=5;
	    		    		
	    		}
		 
		 //method that will run the entire game
		 public void DoAll() throws InterruptedException 
		 {
			//while the player is still alive
			 Thread.sleep(500);
			 while (death==0) {	    			    	
		    	//move the snake
		    	move();
		    	//repaint the frame
		    	repaint();
		    	//wait for .3 of a second in between frames		    	
		    	death = updateboard();
		    	//update the board and return the death varable to tell if th player has died
		    	Thread.sleep(200);
		    	
			 }
		 }
		

	    // Paints makes the graphics
	    public void paintComponent(Graphics g) {
	    	
	    	// Declare variables
	    	int iCountRows, iCountColumns, iXLocation = 0, iYLocation = 0, iRowEvenOrOdd = 0, iColumnEvenOrOdd, iProduct;
	    	
	        super.paintComponent(g);
	        
	        // Use for loop to print tiles
	        for (iCountRows = 9; iCountRows >=0; iCountRows --) {
	        	// Multiply the count by 50 to determine coordinates for each row
		        iXLocation = iCountRows * 50;
		        iYLocation = iCountRows * 50;
		        for(iCountColumns = 9; iCountColumns >=0; iCountColumns --) {
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
	        g.setColor(Color.green.darker().darker());
	        g.fillRect(0, 498, 516, 50);
	      
	        	
	        
	        
	        	snakelengthstring=String.valueOf(snakelength);
	        	
	        	        Graphics2D g2 = (Graphics2D)g;
	        	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	        	        RenderingHints.VALUE_ANTIALIAS_ON);
	        	        g2.setColor(Color.white);;
	        	        g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
	        	        g2.drawString(snakelengthstring,240,538); 
	        	       	        	 	        	           
	        	    
	           
	   }
	    	
	    
	    //print out the board array in the console for trouble shooting
	    public void printboard()
	    	{
	    		//make the for loops looke like this so that x and y can look like a standard coordinate plain.
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
	    		
	    		//for each the entire length of the snake
	    		for(z=0;z< snaketailx.size(); z++)
	    				{
	    			//set the the spots that have snake tails to 1
	    					board[snaketailx.get(z)][snaketaily.get(z)]=1;
	    					
	    				}
	    		
	    		//for all of the snake tail other than the part that is directly under the head
	    		//check if it is the same location as the head
	    		//if so you died
	    		for(z=1;z< snaketailx.size(); z++)
	    		{
	    		if(snaketailx.get(z)==playerheadx&&snaketaily.get(z)==playerheady)
	    					death=1;
	    		}
	    		
	    		//put the apple on the board
	    		board[applex][appley]=3;
	    		//when the head hits and apple
	    		if(board[playerheadx][playerheady]==3)
	    		{
	    			//add another spot to the end of the snake tail
	    			//make it in the same locations as the very end of the tail
	    			snaketailx.add(snaketailx.get(snakelength-1));
	    			snaketaily.add(snaketaily.get(snakelength-1));
	    			//add 1 to the lenght varable
	    			snakelength++;	
	    			//generate a new apple
	    			generateapple();	    				    
	    		}
	    		
	    		//set the player head location to 2
	    		board[playerheadx][playerheady]=2;
	    		
	    		//return the variable death to let main know it died	    		    		
	    		return death;
	    	}

	    	//generate an apple somewhere
	    public void generateapple()
	    	{
	    	//always run once
	    		do
	    		{
	    			//make a new random instance
	    			Random dice = new Random();
	    			//set the apple to a random location on the board
	    			appley = dice.nextInt(10);
	    			applex = dice.nextInt(10);
	    					
	    			//repeat if the apple isn't in an empty space
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
	    			//set the snake tail cords to the next snake tails cords
	    			snaketailx.set(z, snaketailx.get(z-1));
	    			snaketaily.set(z, snaketaily.get(z-1));
	    			
	    			//get closer to the head by 1
	    			z--;
	    		}
	    		
	    		//check for each direction
	    		//if the direction is 1 move up
	    		if(player.getdirection()==1)
	    		{
	    			//if it will be on the board move
	    			if(playerheady+1<10)
	    			{			
	    				playerheady++;
	    			}
	    			//if it will be off the board th eplayer died
	    			else
	    				death=1;
	    		}
	    		//does everything the same but moves down
	    		if(player.getdirection()==3)
	    		{
	    			if(playerheady-1>=0)
	    			{				
	    				playerheady--;
	    			}
	    			else
	    				death=1;
	    		}
	    		//left
	    		if(player.getdirection()==2)
	    		{
	    			if(playerheadx-1>=0)
	    			{								
	    			playerheadx--;
	    			}
	    			else
	    				death=1;
	    		}
	    		//right
	    		if(player.getdirection()==4)
	    		{
	    			if(playerheadx+1<10)
	    			{				
	    			playerheadx++;		
	    			}
	    			else
	    				death=1;
	    		}
	    	
	    		//move the closes part of the snake tail to where the new head is
	    		snaketaily.set(0, playerheady);
	    		snaketailx.set(0, playerheadx);
	        }			
}
