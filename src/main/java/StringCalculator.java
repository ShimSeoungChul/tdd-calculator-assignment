public class StringCalculator {

	public int add(String numbers) {
		if (numbers.equals("")) {
			return 0;
		} else {
			String[] numArr = numbers.split(",");
			if (numArr.length == 1) {
				return Integer.parseInt(numArr[0]);
			} else {
				return Integer.parseInt(numArr[0]) + Integer.parseInt(numArr[1]);
			}
		}
	}
}
