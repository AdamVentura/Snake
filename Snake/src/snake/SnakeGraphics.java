package src;

import java.awt.*;
import javax.swing.*;
import java.util.*;


public class SnakeGraphics extends JPanel 
{
	    private static final long serialVersionUID = 1L;	    
	    private int board[][];
		private int iSnakeLength, iPlayerHeadX, iPlayerHeadY, iDeath, iAppleX, iAppleY;
		String sSnakeLengthString;
		private int x, y, z;
		//make instance of the Key Listener class
		player player=new player();		
		ArrayList<Integer> SnakeTailX=new <Integer>ArrayList<Integer>();		
		ArrayList<Integer> SnakeTailY=new <Integer>ArrayList<Integer>();	
		
		//constructor
		 public SnakeGraphics() throws InterruptedException
	    	{
			 //add these to make the Key Listener work
			 addKeyListener(player);
			 setFocusable(true);
		     requestFocusInWindow();
		     //make the array 10 by 10 for the board
	    		board=new int [10][10];
	    		//set the starting spot for the player head
	    		iPlayerHeadX=3;
	    		iPlayerHeadY=5;
	    		//make death start at 0[alive]
	    		iDeath=0;
	    		//starting snake length
	    		iSnakeLength=3;
	    		//make the original tail of the snake	    		
	    		SnakeTailX.add(3);
	    		SnakeTailY.add(5);
	    		SnakeTailX.add(2);
	    		SnakeTailY.add(5);
	    		SnakeTailX.add(1);
	    		SnakeTailY.add(5);
	    		//make the original apple location
	    		iAppleX=7;
	    		iAppleY=5;
	    		    		
	    		}
		 
		 //method that will run the entire game
		 public void doAll() throws InterruptedException 
		 {
			//while the player is still alive
			 Thread.sleep(500);
			 while (iDeath==0) {	    			    	
		    	//move the snake
		    	Move();
		    	//repaint the frame
		    	repaint();
		    	//wait for .3 of a second in between frames		    	
		    	iDeath = updateBoard();
		    	//update the board and return the death variable to tell if the player has died
		    	Thread.sleep(200);
			 }
		 }
		

	    // Paints makes the graphics
	    public void paintComponent(Graphics g) {
	    	
	    	// This is the method that is updating the snake location in the panel as well as the apples
	    	updateGraphics(g);
	    	// This method continuously updates the score of the game
	        setScore(g);
	        
	        // If a player reaches the maximum score which is 100...
	        if (iSnakeLength == 100) {
	        	// Display image that 
	        	displayWin(g);
	        }
	        else if (iDeath == 1) {
	        	try {
					gameOver(g);
				} catch (InterruptedException e) {
					// prints error
					e.printStackTrace();
				}
	        }
	   }
	    

	    public void displayWin(Graphics g) {
	    	Toolkit t=Toolkit.getDefaultToolkit();  
	        Image i=t.getImage("Win.png");  
	        g.drawImage(i, 120,100,this);
	    }
	    
	    
	    public void gameOver(Graphics g) throws InterruptedException {
	    	Thread.sleep(50);
	    	Toolkit t=Toolkit.getDefaultToolkit();  
	        Image i=t.getImage("Game_Over.png");  
	        g.drawImage(i, 120,100,this);
	    }
	    
	    
	    public void updateGraphics(Graphics g) {
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
		        	
		        	// If this part of the board is where the snake body is then set this tile to blue
		        	if (board[iCountColumns][iCountRows]==1)
		        	{
		        		g.setColor(Color.blue);
		        		
		        		
		        		
		        	}
		        
		        // Fills each rectangle with the set color at the specified location
		        g.fillRect(iXLocation, iYLocation, 50, 50);
				
		        // If this part of the board is where the snake head is then create a blue circle
		        if (board[iCountColumns][iCountRows] == 2) {
		        	g.setColor(Color.blue);
		        	g.fillOval(iXLocation, iYLocation, 50, 50);
		        }
		        // If this part of the board is where the apple is, add a red circle
		        if (board[iCountColumns][iCountRows] == 3) {
		        	g.setColor(Color.red);
		        	g.fillOval(iXLocation + 10, iYLocation + 10, 30, 30);
		        }
		        
		        
		        }
		        
		       
	        }
	    }
	    
	    // Method to update score
	    public void setScore(Graphics g) {
	    	// Set color of score background
	        g.setColor(Color.green.darker().darker());
	        // Create the dimensions of the rectangle
	        g.fillRect(0, 498, 516, 50);
	      
	        // Get the length of the snake string
	        sSnakeLengthString = String.valueOf(iSnakeLength);
	        
	        // Set color of text
	        g.setColor(Color.white);
	        // Set the font of text
	        g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
	        // Draw the length of the string in specified location
	        g.drawString(sSnakeLengthString,240,538);
	        }
	        
	    
	    
	    //print out the board array in the console for troubleshooting
	    public void printBoard()
	    	{
	    		//make the for loops look like this so that x and y can look like a standard coordinate plain.
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
	    public int updateBoard()
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
	    		for(z=0;z< SnakeTailX.size(); z++)
	    				{
	    			//set the the spots that have snake tails to 1
	    					board[SnakeTailX.get(z)][SnakeTailY.get(z)]=1;
	    					
	    				}
	    		
	    		//for all of the snake tail other than the part that is directly under the head
	    		//check if it is the same location as the head
	    		//if so you died
	    		for(z=1;z< SnakeTailX.size(); z++)
	    		{
	    		if(SnakeTailX.get(z)==iPlayerHeadX&&SnakeTailY.get(z)==iPlayerHeadY)
	    					iDeath=1;
	    		}
	    		
	    		//put the apple on the board
	    		board[iAppleX][iAppleY]=3;
	    		//when the head hits and apple
	    		if(board[iPlayerHeadX][iPlayerHeadY]==3)
	    		{
	    			//add another spot to the end of the snake tail
	    			//make it in the same locations as the very end of the tail
	    			SnakeTailX.add(SnakeTailX.get(iSnakeLength-1));
	    			SnakeTailY.add(SnakeTailY.get(iSnakeLength-1));
	    			//add 1 to the length variable
	    			iSnakeLength++;	
	    			//generate a new apple
	    			generateApples();	    				    
	    		}
	    		
	    		//set the player head location to 2
	    		board[iPlayerHeadX][iPlayerHeadY]=2;
	    		
	    		//return the variable death to let main know it died	    		    		
	    		return iDeath;
	    	}

	    // generate an apple somewhere
	    public void generateApples()
	    	{
	    	// always run once
	    		do
	    		{
	    			// make a new random instance
	    			Random dice = new Random();
	    			// set the apple to a random location on the board
	    			iAppleY = dice.nextInt(10);
	    			iAppleX = dice.nextInt(10);
	    					
	    		// repeat if the apple isn't in an empty space
	    		} while(board[iAppleX][iAppleY]!=0);
	    		
	    		
	    	}
	    	
	    	
	    //moves the player and their tail
	    public void Move()
	    	{
	    		//set z to the last spot of the snake tail array
	    		z = iSnakeLength-1;
	    		//while it is 1 or greater
	    		while(z>0)
	    		{
	    			//set the snake tail cords to the next snake tails cords
	    			SnakeTailX.set(z, SnakeTailX.get(z-1));
	    			SnakeTailY.set(z, SnakeTailY.get(z-1));
	    			
	    			//get closer to the head by 1
	    			z--;
	    		}
	    		
	    		//check for each direction
	    		//if the direction is 1 move up
	    		if(player.GetDirection()==1)
	    		{
	    			//if it will be on the board move
	    			if(iPlayerHeadY+1<10)
	    			{			
	    				iPlayerHeadY++;
	    			}
	    			//if it will be off the board the player died
	    			else
	    				iDeath = 1;
	    		}
	    		//does everything the same but moves down
	    		if(player.GetDirection()==3)
	    		{
	    			if(iPlayerHeadY-1>=0)
	    			{				
	    				iPlayerHeadY--;
	    			}
	    			else
	    				iDeath = 1;
	    		}
	    		//left
	    		if(player.GetDirection()==2)
	    		{
	    			if(iPlayerHeadX-1>=0)
	    			{								
	    				iPlayerHeadX--;
	    			}
	    			else
	    				iDeath = 1;
	    		}
	    		//right
	    		if(player.GetDirection()==4)
	    		{
	    			if(iPlayerHeadX +1<10)
	    			{				
	    				iPlayerHeadX++;		
	    			}
	    			else
	    				iDeath = 1;
	    		}
	    	
	    		//move the closes part of the snake tail to where the new head is
	    		SnakeTailY.set(0, iPlayerHeadY);
	    		SnakeTailX.set(0, iPlayerHeadX);
	        }			
}
