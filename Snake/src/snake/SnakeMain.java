package snake;
import java.util.*;
class SnakeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeLogic sl=new SnakeLogic();
		
		
		int death=0;
		Scanner reader=new Scanner(System.in);
			
		while(death==0)
			{
		
		sl.printboard();
		sl.move();
		death=sl.updateboard();
		

		
		
			}
			
		
		
		
	}

}
