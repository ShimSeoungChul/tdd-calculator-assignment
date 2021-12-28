import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String numbers) throws Exception {
		if (numbers.equals("")) {
			return 0;
		} else {
			String[] numStringArr = splitStringNumber(numbers);
			int[] rawNumArr = stringArrTointArr(numStringArr);
			int[] filteredNumArr = numFilter(rawNumArr);

			return Arrays.stream(filteredNumArr).sum();
		}
	}

	private int[] numFilter(int[] numArr) throws Exception {
		checkNegative(numArr);
		return getUnderHundred(numArr);
	}

	private int[] getUnderHundred(int[] numArr){
		return Arrays.stream(numArr)
			.filter(num -> num <100)
			.toArray();
	}

	private void checkNegative(int[] numArr) throws Exception {
		var negativeList = new ArrayList<Integer>();
		for (int num : numArr) {
			if (num < 0) {
				negativeList.add(num);
			}
		}

		if (negativeList.size() >= 1) {
			StringJoiner sj = new StringJoiner(", ", "음수는 허용되지 않음: [", "]");
			for (int negative : negativeList) {
				sj.add(Integer.toString(negative));
			}

			throw new Exception(sj.toString());
		}
	}

	private int[] stringArrTointArr(String[] numStringArr) {
		return Arrays.stream(numStringArr)
			.mapToInt(stringNum -> Integer.parseInt(stringNum))
			.toArray();
	}

	private String[] splitStringNumber(String numbers) {
		if (hasSeperator(numbers)) {
			String seperator = getSeperator(numbers);
			numbers = deleteSeperatorPart(numbers);

			return numbers.split(seperator);
		} else {
			return numbers.split(",");
		}
	}

	private String deleteSeperatorPart(String numbers) {
		String regExpression = "//(.*?)\n";
		return numbers.replaceAll(regExpression, "");
	}

	private boolean hasSeperator(String numbers) {
		String regExpression = "//(.*?)\n";
		return isMatched(regExpression, numbers);
	}

	private String getSeperator(String numbers) {
		String regExpression = "//(.*?)\n";
		String seperatorPart = getMatched(regExpression, numbers);
		if (isMoreThanTwoWordsSeperator(seperatorPart)) {
			seperatorPart = getMoreThanTwoWordsSeperator(seperatorPart);
		}
		return seperatorPart;
	}

	private String getMoreThanTwoWordsSeperator(String seperatorString) {
		String regExpression = "[\\[](.*?)[\\]]";
		return getMatched(regExpression, seperatorString);
	}

	private boolean isMoreThanTwoWordsSeperator(String numbers) {
		String regExpression = "[\\[](.*?)[]]";
		return isMatched(regExpression, numbers);
	}

	private boolean isMatched(String regExpression, String input) {
		Pattern speratorPattern = Pattern.compile(regExpression);
		Matcher matcher = speratorPattern.matcher(input);
		return matcher.find();
	}

	private String getMatched(String regExpression, String string) {
		Pattern speratorPattern = Pattern.compile(regExpression);
		Matcher matcher = speratorPattern.matcher(string);
		if(matcher.find()) {
			return matcher.group(1);
		} else {
			throw new IllegalStateException("No Match Found");
		}
	}
}
