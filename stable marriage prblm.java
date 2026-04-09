public class Main
{
	public static void main(String[] args) {
	    int men[][] = {
	        {0,1},
	        {0,1}
	    };
	    int women[][] = {
	        {1,0},
	        {0,1}
	    };
	    int match[] = {-1,-1};
	    boolean free[] = {true,true};
	    while(free[0]  || free[1]) {
	        int m = free[0] ? 0:1;
	        for(int i = 0;i < 2;i++) {
	            int w = men[m][i];
	            if(match[w] == -1) {
	                match[w] = m;
	                free[m] = false;
	                break;
	            } else {
	                int m1 = match[w];
	                if(women[w][0] == m) {
	                    match[w] = m;
	                    free[m] = false;
	                    free[m1] = true;
	                    break;
	                }
	            }
	        }
	    }
		System.out.println("w0 - M" + match[0]);
		System.out.println("w1 - M" + match[1]);
	}
}
