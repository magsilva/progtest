
public class Fatorial {
	
	public static int fatorial(int x){
		
		int fatorial;
		
		if(x > 1) {
			fatorial = x * fatorial(x-1);
		} else {
			fatorial = x;
		}
		
		return fatorial;
	
	}

}
