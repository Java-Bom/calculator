package operation;

import input.Split;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorPackTest {

    @ParameterizedTest
    @DisplayName("계산식 입력값에 있는 연산자만 분리해서 보유하고 있는지 확인")
    @CsvSource({"1 + 3 + 4,+ +", "1 * 3 * 2 / 5 + 5,* * / +", "1 + 1,+"})
    void getNextOperatorTest(String input, String operators) {
        Split split = new Split(input);
        List<String> operatorValues = Arrays.stream(operators.split(" "))
                .collect(Collectors.toList());

        OperatorPack operatorPack = new OperatorPack(split.getExpression());
        int operatorCount = operatorPack.getOperatorPackCounts();

        for (int i = 0; i < operatorCount; i++) {
            assertThat(operatorValues.get(i)).isEqualTo(operatorPack.pollOperator());
        }
    }
}