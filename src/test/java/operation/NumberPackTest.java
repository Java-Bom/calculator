package operation;

import input.Split;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumberPackTest {

    @ParameterizedTest
    @DisplayName("계산식 입력값에 있는 숫자만 분리해서 보유하고 확인.")
    @CsvSource({"1 + 3 + 4,1 3 4", "1 * 3 * 2 / 5 + 5,1 3 2 5 5", "1,1", "1 + 10 + 455,1 10 455"})
    public void getNextNumberTest(String input, String numbers) {
        // given
        Split split = new Split(input);
        List<Double> numberValues = Arrays.stream(numbers.split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        NumberPack numberPack = new NumberPack(split.getExpression());
        int numberPackCount = numberPack.getNumberCount();

        for (int i = 0; i < numberPackCount; i++) {
            assertThat(numberValues.get(i)).isEqualTo(numberPack.pollNumber());
        }
    }

}