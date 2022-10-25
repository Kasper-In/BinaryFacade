import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.*;

class BinOpsTest {

    BinOps binOps;

    @BeforeEach
    public void setUp() {
        binOps = new BinOps();
    }

    @DisplayName("Проверка суммирования")
    @ParameterizedTest
    @MethodSource("getSumArguments")
    void sum(String a, String b, String result) {
        Assertions.assertEquals(result, binOps.sum(a, b));
    }

    @DisplayName("Проверка произведения")
    @ParameterizedTest
    @MethodSource("getMultArguments")
    void mult(String a, String b, String result) {
        Assertions.assertEquals(result, binOps.mult(a, b));
    }

    private static Stream<Arguments> getSumArguments() {
        return Stream.of(
                Arguments.of("101", "010", "111"),
                Arguments.of("1011", "111", "10010"),
                Arguments.of("111", "111", "1110")
        );
    }

    private static Stream<Arguments> getMultArguments() {
        return Stream.of(
                Arguments.of("101", "010", "1010"),
                Arguments.of("1011", "111", "1001101"),
                Arguments.of("111", "000", "0")
        );
    }
}