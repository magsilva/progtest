
public class Main {

	public static String main(String sequence, int n) {

		String elements[] = sequence.split(",");

		int v[] = new int[elements.length];

		for (int i = 0; i < elements.length; i++)
			v[i] = Integer.valueOf(elements[i]);

		SelectionSort.sort(v, n);

		String output = "";

		for (int i : v) {
			if (!output.equals(""))
				output += ",";
			output += i;
		}

		return output;

	}

}
