import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator stringCalculator = new StringCalculator();

	@Test
	void 인자가_빈_문자열이면_0을_반환() {
		int returnNum = stringCalculator.add("");

		assertThat(returnNum).isEqualTo(0);
	}

	@Test
	void 인자가_하나의_정수면_해당_정수를_반환() {
		int returnNum = stringCalculator.add("1");

		assertThat(returnNum).isEqualTo(1);
	}

	@Test
	void 인자가_두개의_정수면_합계를_반환() {
		int returnNum = stringCalculator.add("1,2");

		assertThat(returnNum).isEqualTo(3);
	}

	@Test
	void 인자가_두개를_초과하는_정수면_합계를_반환 () {
		int returnNum = stringCalculator.add("1,2,3,4,5");

		assertThat(returnNum).isEqualTo(15);
	}
}