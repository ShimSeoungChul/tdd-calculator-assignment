import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	StringCalculator stringCalculator = new StringCalculator();

	@Test
	void 인자가_빈_문자열이면_0을_반환 () throws Exception {
		int returnNum = stringCalculator.add("");

		assertThat(returnNum).isEqualTo(0);
	}

	@Test
	void 인자가_하나의_정수면_해당_정수를_반환 () throws Exception {
		int returnNum = stringCalculator.add("1");

		assertThat(returnNum).isEqualTo(1);
	}

	@Test
	void 인자가_두개의_정수면_합계를_반환 () throws Exception {
		int returnNum = stringCalculator.add("1,2");

		assertThat(returnNum).isEqualTo(3);
	}

	@Test
	void 인자가_두개를_초과하는_정수면_합계를_반환 () throws Exception {
		int returnNum = stringCalculator.add("1,2,3,4,5");

		assertThat(returnNum).isEqualTo(15);
	}

	@Test
	void 문자열_맨앞에_구분자를_넣으면_해당_구분자로_문자열을_나눈다 () throws Exception {
		// "//구분자\n숫자"형식으로 구분자를 넣을 수 있음
		int returnNum = stringCalculator.add("//;\n1;2;3;4;5");

		assertThat(returnNum).isEqualTo(15);
	}

	@Test
	void add_메서드에_음수를_전달하면_예외_발생 () {
		assertThatThrownBy(() -> {
			int returnNum = stringCalculator.add("//;\n-1;2;3;-4;5");
		}).isInstanceOf(Exception.class)
			.hasMessageContaining("음수는 허용되지 않음: [-1, -4]");
	}
}
