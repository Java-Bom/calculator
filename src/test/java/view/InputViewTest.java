package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @DisplayName("문자열을 터미널로 입력받는 인풋뷰")
    @Test
    void inputview1() throws IOException {

        String input = "2 + 3 - 1 ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView(new Scanner(in));

        String mathExpression = inputView.inputMathExpression();
        assertThat(mathExpression).isEqualTo("2 + 3 - 1 ");
    }


}
