package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class player implements KeyListener{
	
	int direction=4;
    
    //change the direction that the player is moving
    public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		System.out.println("Helllo2");
		if(key==KeyEvent.VK_SPACE){
			direction=1;
			System.out.println("Hello");
			
		}
		if(key==KeyEvent.VK_S){
			direction=3;
			
		}
		
		if(key==KeyEvent.VK_A){
			direction=2;
			
		}
		if(key==KeyEvent.VK_D){
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
