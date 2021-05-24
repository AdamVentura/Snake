package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class player implements KeyListener{
	
	int direction=4;
    
    //change the direction that the player is moving
    public void keyPressed(KeyEvent e)
	{
    	// Get the key that the player pressed
		int key = e.getKeyCode();
		
		// For the keys W, A, S, and D
		if(key==KeyEvent.VK_W){
			direction=3;
		}
		if(key==KeyEvent.VK_S){
			direction=1;
		}
		if(key==KeyEvent.VK_A){
			direction=2;
		}
		if(key==KeyEvent.VK_D){
			direction=4;
		}
		
		// For the arrow keys
		if(key==KeyEvent.VK_UP){
			direction=3;
		}
		if(key==KeyEvent.VK_DOWN){
			direction=1;
		}
		if(key==KeyEvent.VK_LEFT){
			direction=2;
		}
		if(key==KeyEvent.VK_RIGHT){
			direction=4;
		}
		
	}
    

    public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
    public int getdirection()
    {
    	return direction;
    }
    
}

