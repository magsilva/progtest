public class Min {

	public static int minimum(int[] values) {
		int min = values[0];
		for (int i = 1; i < values.length; i++)
			if (min > values[i])
				min = values[i];
		return min;
	}
	
	public static int min(int[] values) throws IllegalArgumentException {
		if (values.length == 0)
			throw new IllegalArgumentException();
		else
			return minimum(values);
	}
	
}
