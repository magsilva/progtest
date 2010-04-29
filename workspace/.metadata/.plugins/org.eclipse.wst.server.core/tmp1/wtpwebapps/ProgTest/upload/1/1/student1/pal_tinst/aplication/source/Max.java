public class Max {

	public static int max(int v[]) {
		//correto int max = v[0];
		//correto for (int i = 1; i < v.length; i++)
		int max = v[1];
		for (int i = 2; i < v.length; i++)
			if (max < v[i])
				max = v[i];
		return max;
	}

}
