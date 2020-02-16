package calculator.support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SplitterTest {

    @DisplayName("문자열 쪼개기")
    @Test
    void split(){
        String input = "1 + 2 + 3";
        assertThat(new String[] {"1", "+", "2", "+",  "3"}).isEqualTo(Splitter.split(input));
    }
}
