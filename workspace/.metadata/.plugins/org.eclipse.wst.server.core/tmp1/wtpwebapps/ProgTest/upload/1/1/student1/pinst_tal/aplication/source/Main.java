

public class Main {
	
	public static String main(String sequence) {
		
		String elements[] = sequence.split(",");
		
		int v[] = new int[elements.length];
		
		for(int i = 0; i < elements.length; i++)
			v[i] = Integer.valueOf(elements[i]);
		
		return String.valueOf(Max.max(v));
		
	}

}
