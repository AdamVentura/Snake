public int[][] CheckApple()
	{
		do
		{
			GenerateApples();		
			
		}while(board[a][q]!=0);
		
		board[a][q] = 3;
		
		return board;
	}
	
	
	
	public void GenerateApples() {
		Random dice = new Random();
		q = 0;
		a = 0;
		
         	q = dice.nextInt(10);
		a = dice.nextInt(10);
		
		//System.out.println(a + " " + q);
		
     } 
     
     
     public int updateboard()
	{
		//for each
		for(y=9;y>=0;y--)
		{
			for(x=0;x<10;x++)
			{
				if(x==a&&y==q)
				{
					board[x][y]=3;
				}
				else
				{
				board[x][y]=0;
				}
				
				for(z=0;z< snaketailx.size(); z++)
				{
					board[snaketailx.get(z)][snaketaily.get(z)]=1;
					
					
				}
			
				
			}
		}
		for(y=9;y>=0;y--)
		{
			for(x=0;x<10;x++)
			{
		if(playerheadx==x&&playerheady==y)
				{
					board[x][y]=2;
				}
		
		
			}
		}
		return death;
	}
