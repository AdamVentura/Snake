package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SnakeGraphics extends JPanel {

	    private static final long serialVersionUID = 7148504528835036003L;

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
		        
		        // Fills each rectangle with the set color at the specified location
		        g.fillRect(iXLocation, iYLocation, 50, 50);
		        
		        }
	        	}
	        }

	    
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	        	// Creates panel object of Snake class
	            var panel = new SnakeGraphics();
	            // Creates a JFrame object
	            var frame = new JFrame("Snake");
	            // Sets the size of the window
	            frame.setSize(506, 532);
	            // Exit application when window is closed
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            // Center pane
	            frame.getContentPane().add(panel, BorderLayout.CENTER);
	            // Make frame visible
	            frame.setVisible(true);
	        }
	        );
	    }
	}
