import java.util.Arrays;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.equals("")) {
			return 0;
		} else {
			String[] numArr = numbers.split(",");
			int sum = Arrays.stream(numArr)
				.mapToInt(stringNum -> Integer.parseInt(stringNum))
				.sum();
			return sum;
		}
	}
}
