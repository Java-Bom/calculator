package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("입력 받기 성공")
    @Test
    void inputEquation1() {
        //given
        InputStream inputStream = new ByteArrayInputStream("2 + 3 * 4 % 2".getBytes());
        Scanner scanner = new Scanner(inputStream);
        InputView inputView = new InputView(scanner);

        //when
        InputExpressionDTO result = inputView.inputEquation();

        //then
        assertThat(result).isEqualTo(new InputExpressionDTO("2 + 3 * 4 % 2"));
    }

    @DisplayName("비어 있는 입력을 받은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"\n", "  "})
    void inputEquation2(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::inputEquation)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어 있습니다.");
    }

}