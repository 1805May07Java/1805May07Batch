package Q1;

public class Application {

	public static void main(String[] args) {
		// Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
        Application app = new Application();
        
		int blist[]= {1,0,5,6,3,2,3,7,9,8,4};
        app.bubble(blist);
		
	}

	public int[] bubble(int blist[]) {
		// TODO Auto-generated method stub
		int i=0;
        boolean change = true;
		do{
			
			if(blist[i] > blist[i+1] ) {
			    int Tmp = blist[i+1];
			    blist[i+1]=blist[i];
			    blist[i]=Tmp;
			    i=0;
			    
			}else {
			 i++;
			}
			
		}while(i+1 <blist.length);
		
		
		//Print Result
		for(int x : blist) {
			System.out.print(x+" ");
		}
		System.out.println("");
		return blist;
	}

	

}
