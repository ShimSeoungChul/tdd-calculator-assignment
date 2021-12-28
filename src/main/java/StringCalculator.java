import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private final String regExpression = "//(.*?)\n";
	Pattern speratorPattern = Pattern.compile(regExpression);

	public int add (String numbers) {
		if (numbers.equals("")) {
			return 0;
		} else {
			String[] numArr = splitStringNumber(numbers);
			int sum = Arrays.stream(numArr)
				.mapToInt(stringNum ->  Integer.parseInt(stringNum))
				.sum();
			return sum;
		}
	}

	private String[] splitStringNumber (String numbers) {
		if (hasSeperator(numbers)) {
			String seperator = getSeperator(numbers);
			numbers = deleteSeperatorPart(numbers);

			return numbers.split(seperator);
		} else {
			return numbers.split(",");
		}
	}

	private String deleteSeperatorPart(String numbers) {
		return numbers.replaceAll(regExpression, "");
	}

	private boolean hasSeperator(String numbers) {
		Matcher matcher = speratorPattern.matcher(numbers);
		return matcher.find();
	}

	private String getSeperator(String numbers) {
		Matcher matcher = speratorPattern.matcher(numbers);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			throw new IllegalStateException("No Match Found");
		}
	}
}
