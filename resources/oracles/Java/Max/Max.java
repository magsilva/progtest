public class Max {

	public static int maximum(int[] values) {
		int max = values[0];
		for(int i = 1; i < values.length; i++)
			if (max < values[i])
				max = values[i];
		return max;
	}

	public static int max(int[] values) throws IllegalArgumentException {
		if (values.length == 0)
			throw new IllegalArgumentException();
		else
			return maximum(values);
	}

}
