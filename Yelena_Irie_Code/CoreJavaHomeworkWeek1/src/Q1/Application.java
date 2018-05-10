package Q1;

public class Application {

	public static void main(String[] args) {
		// Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
        
		int blist[]= {1,0,5,6,3,2,3,7,9,8,4};
        bubble(blist);
		
	}

	public static void bubble(int blist[]) {
		// TODO Auto-generated method stub
		int i=0;
        boolean flag = true;
		do{
			
			if(blist[i] > blist[i+1] ) {
			    int Tmp = blist[i];
			    blist[i]=blist[i+1];
			    blist[i+1]=Tmp;
			}
			i++;
			
		}while(i+1 <blist.length);
		
		
		//Print Result
		for(int x : blist) {
			System.out.print(x+" ");
		}
		System.out.println("");
	}

	

}
