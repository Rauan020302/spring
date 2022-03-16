package amigos.code.testing.spring_boot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ApplicationTests {
    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        int numberOne = 20;
        int numberTwo = 30;

        // when
        int result = underTest.add(numberOne, numberTwo);

        // then
        int expected = 50;
         assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

}
