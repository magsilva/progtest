

public class Main {

	public static String main(String sequence) {

		String elements[] = sequence.split(",");

		int v[] = new int[elements.length];

		for (int i = 0; i < elements.length; i++)
			v[i] = Integer.valueOf(elements[i]);

		int result[] = MaxMin.maxMin(v);

		String output = String.valueOf(result[0]) + ","
				+ String.valueOf(result[1]);

		return output;

	}

}
