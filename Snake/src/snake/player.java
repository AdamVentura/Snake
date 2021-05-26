package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class player implements KeyListener{
	//start the player moving right
	int iDirection=4;
    
    //change the direction that the player is moving
    public void keyPressed(KeyEvent e)
	{
    	//set key to the inputed code from the letters pressed
		int key = e.getKeyCode();
		
		//if they pressed w and the wont do a 180 change the direction to up
		if(key==KeyEvent.VK_W&&iDirection!=1){
			
			iDirection=3;
		}
		//is they pressed s and it wont be a 180 turn change the direction to down
		if(key==KeyEvent.VK_S&&iDirection!=3){
			iDirection=1;
		}
		//change to left
		if(key==KeyEvent.VK_A&&iDirection!=4){
			iDirection=2;
		}
		//change to right
		if(key==KeyEvent.VK_D&&iDirection!=2){
			iDirection=4;
		}
		
		//if they pressed the up key and the wont do a 180 change the direction to up
		//if they pressed the up key and the wont do a 180 change the direction to up
		if(key==KeyEvent.VK_UP&&iDirection!=1){		
			iDirection=3;
			}
		//is they pressed down and it wont be a 180 turn change the direction to down
		if(key==KeyEvent.VK_DOWN&&iDirection!=3){
			iDirection=1;
			}
		//change to left
		if(key==KeyEvent.VK_LEFT&&iDirection!=4){
			iDirection=2;
			}
		//change to right
		if(key==KeyEvent.VK_RIGHT&&iDirection!=2){
			iDirection=4;
			}
		
	}
    
//no used but is need for the interface
    public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    //methed that returns the diretcion
    public int GetDirection()
    {
    	return iDirection;
    }
    
}
